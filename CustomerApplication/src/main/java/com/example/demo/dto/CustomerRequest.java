package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

	private Long customerId;
	private String customerName;
	private String customerPassword;
	private String customerConfirmPassword;
	private String customerAge;
	private String customerMobilenumber;
	private String customerEmail;
	private String customerGender;
		
}
