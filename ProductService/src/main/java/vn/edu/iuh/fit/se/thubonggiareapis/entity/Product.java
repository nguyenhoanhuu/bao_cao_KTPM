package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {

	private long id;
	private String name;
	private double cost;
	private String description;
	private String origin;
	private String brand;
	private int rate;
	private String category;
	private String material;
	private double weight;
	private double height;
	private double width;
	private String image;

}
