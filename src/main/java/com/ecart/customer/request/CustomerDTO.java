package com.ecart.customer.request;

import com.ecart.customer.repository.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CustomerDTO {	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	public static CustomerDTO customerObejctToCustomerDTO(CustomerEntity p) {
		CustomerDTO dto = CustomerDTO.builder().id(p.getId())
				.firstName(p.getFirstName())
				.lastName(p.getLastName())
				.email(p.getEmail())
				.phone(p.getPhone())
				.build();
		return dto;
	}
	
	public static CustomerEntity customerDTOToCustomer(CustomerDTO p) {
		CustomerEntity person = CustomerEntity.builder().id(p.getId())
				.firstName(p.getFirstName())
				.lastName(p.getLastName())
				.email(p.getEmail())
				.phone(p.getPhone())
				.build();
		return person;
	}
}
