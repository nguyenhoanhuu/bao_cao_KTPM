package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Customer;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderConverter {

    @Autowired
    private OrderDetailConverter orderDetailConverter;

    public Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();

        if (order.getId() != 0) {
            order.setId(orderDTO.getId());
        }

        order.setOrderDate(LocalDateTime.now());
        order.setTotal(0);
        order.setDiscount(0);
        order.setShippingCost(0);
        order.setSubTotal(0);
        order.setShippingAddress(orderDTO.getShippingAddress());
        order.setShippingNote(Objects.isNull(orderDTO.getShippingNote()) || orderDTO.getShippingNote().isBlank() ? null : orderDTO.getShippingNote());
        order.setCustomer(new Customer(orderDTO.getCustomer()));
        order.setOrderDetails(new ArrayList<>());

        return order;
    }

    public OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setDiscount(order.getDiscount());
        orderDTO.setShippingCost(order.getShippingCost());
        orderDTO.setSubTotal(order.getSubTotal());
        orderDTO.setPromotionCode(order.getPromotion() != null ? order.getPromotion().getPromotionCode() : null);
        orderDTO.setShippingAddress(order.getShippingAddress());
        orderDTO.setShippingNote(order.getShippingNote() != null ? order.getShippingNote() : null);
        orderDTO.setCustomer(order.getCustomer().getId());

        List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            orderDetailDTOs.add(orderDetailConverter.toDto(orderDetail));
        }
        orderDTO.setDetails(orderDetailDTOs);

        return orderDTO;
    }

    public List<OrderDTO> toDtos(List<Order> orders) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orders.forEach(order -> {
            orderDTOList.add(toDto(order));
        });
        return orderDTOList;
    }
}
