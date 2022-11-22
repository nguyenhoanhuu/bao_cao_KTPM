package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.CustomerConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.OrderConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.PromotionConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.ProductInventoryDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.PromotionDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.OrderRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private Environment env;

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IPromotionService promotionService;

    @Autowired
    private PromotionConverter promotionConverter;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IProductInventoryService productInventoryService;

    @Autowired
    private ICartDetailService cartDetailService;

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderDTO> orders = new ArrayList<>();
        orderRepository.findAll().forEach((order -> {
            OrderDTO orderDTO = orderConverter.toDto(order);
            orders.add(orderDTO);
        }));
        return orders;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        Order result = orderRepository.findById(orderId).orElse(null);
        if (Objects.isNull(result)) {
            return null;
        }
        return orderConverter.toDto(result);
    }

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toEntity(orderDTO);

        order.setShippingCost(Double.parseDouble(Objects.requireNonNull(env.getProperty("order.settings.default.shippingcost"))));

        PromotionDTO promotionDTO = promotionService.getPromotionByCode(orderDTO.getPromotionCode());

        order.setPromotion(
                orderDTO.getPromotionCode() == null ? null :
                        promotionConverter.toEntity(
                                promotionDTO
                        ));

        order.setCustomer(
                customerConverter.toEntity(
                        customerService.getCustomer(orderDTO.getCustomer())
                )
        );

        orderRepository.save(order);

        order.setSubTotal(orderDetailService.addOrderDetail(order, orderDTO.getDetails()));

        order.setTotal(order.getSubTotal() + order.getShippingCost());

        if (order.getPromotion() != null) {
            order.setDiscount(order.getPromotion().getDeducted());
            order.setTotal(order.getTotal() * (1 - order.getDiscount()));

            promotionDTO.setLimit(promotionDTO.getLimit() - 1);
            promotionService.updatePromotion(promotionDTO);
        }

        orderRepository.save(order);

        orderDTO.getDetails().forEach(
                orderDetailDTO -> productInventoryService.updateProductInventory(new ProductInventoryDTO(orderDetailDTO.getProduct(), -orderDetailDTO.getQuantity()))
        );

        List<OrderDetailDTO> orderDetailDTOs = orderDetailService.getOrderDetailByOrderId(order.getId());
        OrderDTO dto = orderConverter.toDto(order);
        dto.setDetails(orderDetailDTOs);

        return dto;
    }

    @Override
    public List<OrderDTO> getOrdersByOrderDate(int year, int month, int dayOfMonth) {
        List<Order> orders = orderRepository.findAllByOrderDate_YearAndOrderDate_MonthAndOrderDate_DayOfMonth(year, month, dayOfMonth);
        return orderConverter.toDtos(orders);
    }

    @Override
    public Long getTotalOrder() {
        return orderRepository.count();
    }

    @Override
    public Double getTotalRevenueInADay(int dayOfMonth, Month month, int year) {
        try {
            return orderRepository.totalRevenueInDay(dayOfMonth, month.getValue(), year);
        } catch (Exception e) {
            return 0.0;
        }
    }

    @Override
    public Double getTotalRevenueInAMonth(Month month, int year) {
        try {
            return orderRepository.totalRevenueInMonth(month.getValue(), year);
        } catch (Exception e) {
            return 0.0;
        }
    }
}
