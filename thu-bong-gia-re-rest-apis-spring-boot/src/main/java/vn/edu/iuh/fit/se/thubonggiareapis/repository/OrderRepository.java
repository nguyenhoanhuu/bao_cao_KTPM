package vn.edu.iuh.fit.se.thubonggiareapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.se.thubonggiareapis.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders where YEAR(order_date) = ?1 and MONTH(order_date) = ?2 and DAY(order_date) = ?3", nativeQuery = true)
    List<Order> findAllByOrderDate_YearAndOrderDate_MonthAndOrderDate_DayOfMonth(int year, int month, int dateOfMonth);

    @Query(value = "select sum(total) from orders where month(order_date) = ?1 and year(order_date) = ?2;", nativeQuery = true)
    Double totalRevenueInMonth(int month, int year) throws Exception;

    @Query(value = "select sum(total) from orders where day(order_date) = ?1 and month(order_date) = ?2 and year(order_date) = ?3;", nativeQuery = true)
    Double totalRevenueInDay(int day, int month, int year) throws Exception;
}
