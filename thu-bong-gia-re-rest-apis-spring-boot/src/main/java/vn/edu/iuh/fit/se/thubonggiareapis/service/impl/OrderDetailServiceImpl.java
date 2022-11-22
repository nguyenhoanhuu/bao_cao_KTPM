package vn.edu.iuh.fit.se.thubonggiareapis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.OrderDetailConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.converter.ProductConverter;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.repository.OrderDetailRepository;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IOrderDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IProductService;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderDetailConverter orderDetailConverter;

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public Double addOrderDetail(Order order, List<OrderDetailDTO> detailDTO) {
        double totalPrice = 0.0;
        // Create a list of Order detail entity
        List<OrderDetail> orderDetails = new ArrayList<>();

        // For each order detail from payload
        for (OrderDetailDTO orderDetailDTO : detailDTO) {
            // Convert to Order Detail entity
            OrderDetail detail = orderDetailConverter.toEntity(orderDetailDTO);

            // set to detail element
            detail.setOrder(order);

            // find a product by id and convert itself to entity
            detail.setProduct(productConverter.toEntity(
                    productService.getProductById(orderDetailDTO.getProduct())
            ));

            System.out.println(detail);


            detail.setCost(detail.getProduct().getCost());
            detail.setTotalLine(detail.getQuantity() * detail.getCost());

            orderDetailRepository.save(detail);

            totalPrice += detail.getTotalLine();

        }
        // finally save all order details to database
        return totalPrice;
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailByOrderId(Long orderId) {
        List<OrderDetail> orderDetails = orderDetailRepository.findOrderDetailByOrder_Id(orderId);
        return orderDetailConverter.toDtos(orderDetails);
    }

    @Override
    public Long getTotalProductInMonth(Month month) {
        return orderDetailRepository.countTotalProductSoldInMonth(month.getValue());
    }
}
