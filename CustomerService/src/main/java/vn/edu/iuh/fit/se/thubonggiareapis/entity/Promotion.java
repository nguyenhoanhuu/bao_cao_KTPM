package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Promotion implements Serializable {

	private long id;
	private double deducted;
	private LocalDateTime expiredDate;
	private int limit;
	private String promotionCode; // note
	private int createdBy;





}
