package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IOrderDetailService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IOrderService;
import vn.edu.iuh.fit.se.thubonggiareapis.util.HashMapConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping(value = "/{id}", name = "Get order by id")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = {"", "/"}, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    }, name = "Add an order")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @GetMapping(value = {
            "", "/"
    })
    public ResponseEntity<List<HashMap<String, Object>>> getOrders(
            @RequestParam(name = "date", required = false) Optional<String> date
    ) {
        List<OrderDTO> orderDTOList;
        List<HashMap<String, Object>> result;
        try {
            if (date.isPresent()) {
                LocalDate localDate = LocalDate.parse(date.get());
                orderDTOList = orderService.getOrdersByOrderDate(localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth());
                result = HashMapConverter.toListOf(orderDTOList);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }

            orderDTOList = orderService.getAllOrders();
            result = HashMapConverter.toListOf(orderDTOList);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = {
            "/stats", "/stats/"
    })
    public ResponseEntity<HashMap<String, Object>> getStats() {
        HashMap<String, Object> response = new HashMap<>();
        try {
            LocalDateTime now = LocalDateTime.now();
            response.put("totalOrder", orderService.getTotalOrder());
            response.put("totalProductSoldInAMonth", orderDetailService.getTotalProductInMonth(LocalDate.now().getMonth()));
            response.put("totalRevenueInADay", orderService.getTotalRevenueInADay(now.getDayOfMonth(), now.getMonth(), now.getYear()));
            response.put("totalRevenueInAMonth", orderService.getTotalRevenueInAMonth(now.getMonth(), now.getYear()));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
