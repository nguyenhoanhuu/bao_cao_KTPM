package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductInventory implements Serializable {

	private long id;

	private int quantity;

	private double cost;

	private LocalDateTime createdAt;
	private long product;

}
