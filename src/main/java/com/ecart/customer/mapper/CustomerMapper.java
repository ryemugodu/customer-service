package com.ecart.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ecart.customer.repository.CustomerEntity;
import com.ecart.customer.request.CustomerDTO;

@Mapper
public interface CustomerMapper {
	
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDTO getPersonDTO(CustomerEntity person);
	
	CustomerEntity getCustomerFromDTO(CustomerDTO dto);

}
