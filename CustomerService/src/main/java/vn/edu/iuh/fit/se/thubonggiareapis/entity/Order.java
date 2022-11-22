package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor

public class Order extends OrderDetail implements Serializable {

	private long id;

	private LocalDateTime orderDate;

	private double total;

	private double discount;

	private double shippingCost;

	private String promotionCode;

	private double subTotal;

	private String shippingAddress;

	private String shippingNote;

	private int customer;

	public Order(int order, int product, int quantity, double cost, double totalLine, long id, LocalDateTime orderDate,
			double total, double discount, double shippingCost, String promotionCode, double subTotal,
			String shippingAddress, String shippingNote, int customer) {
		super(order, product, quantity, cost, totalLine);
		this.id = id;
		this.orderDate = orderDate;
		this.total = total;
		this.discount = discount;
		this.shippingCost = shippingCost;
		this.promotionCode = promotionCode;
		this.subTotal = subTotal;
		this.shippingAddress = shippingAddress;
		this.shippingNote = shippingNote;
		this.customer = customer;

	}

}
