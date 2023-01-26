package com.ecart.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecart.customer.repository.Customer;
import com.ecart.customer.repository.CustomerRepository;
import com.ecart.customer.request.CustomerDTO;

@Service
public class PersonsService {
	Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CustomerRepository repository;
	
	public CustomerDTO getCustomer(int id) {
		LOGGER.info("Customer id ::"+id);
		return CustomerDTO.customerObejctToCustomerDTO(repository.getById(id));
	}

	public CustomerDTO save(CustomerDTO dto) {
		Customer customer = repository.save(CustomerDTO.customerDTOToCustomer(dto));
		LOGGER.info("person ::"+customer);
		return CustomerDTO.customerObejctToCustomerDTO(customer);
	}

}
