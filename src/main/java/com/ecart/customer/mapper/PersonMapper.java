package com.ecart.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ecart.customer.repository.Customer;
import com.ecart.customer.request.CustomerDTO;

@Mapper
public interface PersonMapper {
	
	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	CustomerDTO getPersonDTO(Customer person);
	
	Customer getCustomerFromDTO(CustomerDTO dto);

}
