package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer implements Serializable {

	private long id;

	private String name;

	private String email;

	private String phoneNumber;

}
