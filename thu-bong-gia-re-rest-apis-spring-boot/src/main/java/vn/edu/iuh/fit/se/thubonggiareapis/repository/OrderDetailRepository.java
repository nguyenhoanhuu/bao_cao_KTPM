package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.OrderDetail;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findAllByOrder(Long orderId);

    List<OrderDetail> findOrderDetailByOrder_Id(@Param("order_id") Long orderId);

    @Query(value = "select sum(quantity) from order_details od join orders o on od.order_id = o.id where month(o.order_date) = ?1", nativeQuery = true)
    Long countTotalProductSoldInMonth(int month);
}
