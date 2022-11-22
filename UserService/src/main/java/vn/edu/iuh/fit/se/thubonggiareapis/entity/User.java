package vn.edu.iuh.fit.se.thubonggiareapis.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable{

    private long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String password;

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
    




}
