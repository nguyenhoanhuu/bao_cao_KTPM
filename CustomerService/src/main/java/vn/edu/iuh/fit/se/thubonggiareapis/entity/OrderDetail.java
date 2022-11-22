package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {

	private int order;

	private int product;

	private int quantity;

	private double cost;

	private double totalLine;

}
