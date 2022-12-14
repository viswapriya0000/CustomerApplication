package com.example.demo.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Component

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@Column(name="CUSTOMERID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@NotBlank(message="Id should not be blank")
	private long customerId;
	
	@Column(name="CUSTOMERNAME")
	@NotBlank(message="customername should not be blank")
	private String customerName;
	
	@Column(name="CUSTOMERPASSWORD")
	@NotBlank(message="password should not be blank")
	@Size(min=8,message="Password should contains atleast 8 characters")
	//@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_])",message="Password should contains atleast one uppercase, one lowercase, one spl character, one numeric")
	//.{8,20}$
	private String customerPassword;
	
	@Column(name="CUSTOMERCONFIRMPASSWORD")
	@NotBlank(message="confirm password should not be blank")
	@Size(min=8,message="Confirm Password should contains atleast 8 characters")
	//@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])",message="Password should contains atleast one uppercase, one lowercase, one spl character, one numeric")
	private String customerConfirmPassword;
	
	@Column(name="CUSTOMERAGE")
	@NotBlank(message="age should not be blank")
	@Size(min=1,max=3,message="not blank")
	//@Pattern(regexp="(^$|[0-9])",message="Age should be numeric")
	//@NotNull(message="not null")
	//@Digits(fraction=0,integer=10,message="add digits")
	private String customerAge;
	
	@Column(name="CUSTOMERMOBILENUMBER")
	@NotBlank(message="mobile number should not be blank")
	@Pattern(regexp="(^$|[0-9]{10})", message="mobileNo must have 10 digits as well as only digits")
	private String customerMobilenumber;
	
	@Column(name="CUSTOMEREMAIL")
	@NotBlank(message="Email should not be blank")
	@Email(message="not mail")
	private String customerEmail;
	
	@Column(name="CUSTOMERGENDER")
	@NotBlank(message="gender should not be blank")
	@Pattern(regexp="^(MALE|FEMALE)$",message="Please enter MALE or FEMALE")
	private String customerGender;

}
