package vn.edu.iuh.fit.se.thubonggiareapis.converter;

import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDetailDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetailConverter {
    public OrderDetailDTO toDto(OrderDetail orderDetail) {
        return new OrderDetailDTO(
                orderDetail.getOrder().getId(),
                orderDetail.getProduct().getId(),
                orderDetail.getQuantity(),
                orderDetail.getCost(),
                orderDetail.getTotalLine()
        );
    }

    public OrderDetail toEntity(OrderDetailDTO orderDetailDTO) {
        return new OrderDetail(
                new Order(orderDetailDTO.getOrder()),
                new Product(orderDetailDTO.getProduct()),
                orderDetailDTO.getQuantity(),
                0,
                orderDetailDTO.getQuantity() * orderDetailDTO.getCost()
        );
    }

    public List<OrderDetailDTO> toDtos(List<OrderDetail> orderDetails) {
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        orderDetails.forEach(
                orderDetail -> {
                    orderDetailDTOS.add(toDto(orderDetail));
                }
        );
        return orderDetailDTOS;
    }
}
