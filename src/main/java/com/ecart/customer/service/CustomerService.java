package com.ecart.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ecart.customer.repository.CustomerEntity;
import com.ecart.customer.repository.CustomerListPagingAndSortingRepository;
import com.ecart.customer.repository.CustomerPagingAndSortingRepository;
import com.ecart.customer.repository.CustomerRepository;
import com.ecart.customer.request.CustomerDTO;

@Service
public class CustomerService {
	Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	CustomerRepository repository;

	public CustomerDTO getCustomer(int id) {
		LOGGER.info("Customer id ::" + id);
		LOGGER.info("Customers exists in the database for the given id, {}, {}", id, repository.existsById(id));
		CustomerEntity entity = repository.findById(id).get();
		LOGGER.info("Total customers exists in the database, {}", repository.count());
		return CustomerDTO.customerObejctToCustomerDTO(entity);
	}

	public CustomerDTO save(CustomerDTO dto) {
		CustomerEntity customer = repository.save(CustomerDTO.customerDTOToCustomer(dto));
		LOGGER.info("person :: {}", customer);
		return CustomerDTO.customerObejctToCustomerDTO(customer);
	}

	public List<CustomerDTO> findAll() {
		return repository.findAll().stream().map(entity -> CustomerDTO.customerObejctToCustomerDTO(entity))
				.peek(c -> LOGGER.info("Customer :: {}",c))
				.collect(Collectors.toList());
	}

	public List<CustomerDTO> findAllById(List<Integer> ids) {
		return repository.findAllById(ids).stream().map(entity -> CustomerDTO.customerObejctToCustomerDTO(entity))
				.peek(c -> LOGGER.info("Customer :: {}",c))
				.collect(Collectors.toList());
	}

	public String deleteById(int id) {
		repository.deleteById(id);
		Optional<CustomerEntity> optional = repository.findById(id);
		if (optional.isEmpty()) {
			return "Deleted successfully";
		}
		return "Failed to delete customer for the id ::" + id;
	}

	public String deleteCustomer(CustomerEntity customer) {
		repository.delete(customer);
		Optional<CustomerEntity> optional = repository.findById(customer.getId());
		if (optional.isEmpty()) {
			return "Deleted successfully";
		}
		return "Failed to delete customer for the id ::" + customer.getId();
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void deleteAllCustomer(List<CustomerEntity> custList) {
		repository.deleteAll(custList);
	}

	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	public void deleteAllInBatch(List<CustomerEntity> custList) {
		repository.deleteAllInBatch(custList);
	}

	@Autowired
	CustomerPagingAndSortingRepository pagingRepository;

	public List<CustomerDTO> findAllCustomerSortedByName() {
		ArrayList<CustomerDTO> customerList = new ArrayList<>();
		pagingRepository.findAll(Sort.by(Order.by("first_name"),Order.by("last_name")))
				.forEach(e -> {
					customerList.add(CustomerDTO.customerObejctToCustomerDTO(e));
					LOGGER.info("Customer :: {}", e);					
				});
		return customerList;
	}
	
	public List<CustomerDTO> findAllCustomerSortByNameDescOrder(){
		ArrayList<CustomerDTO> customerList = new ArrayList<>();
		pagingRepository.findAll(Sort.by(Order.desc("first_name")))
		.forEach(e -> {
			customerList.add(CustomerDTO.customerObejctToCustomerDTO(e));
			LOGGER.info("Customer :: {}", e);
		});
		return customerList;
	}
	
	
	@Autowired
	CustomerListPagingAndSortingRepository listPagingRepository;

	public List<CustomerDTO> findAllCustomerListSortByName(){
		
		 listPagingRepository
				.findAll(Sort.by(Order.by("first_name").with(Direction.DESC)))
				.stream()
				.map(e-> CustomerDTO.customerObejctToCustomerDTO(e))
				.peek(e->LOGGER.info("Customer :: {}", e))
				.toList();
		 
		 listPagingRepository.findAll(Sort.by(Order.by("first_name"), Order.by("last_name")).descending());
		 
		 return List.of();
	}
	

	public List<CustomerDTO> finaAllCustomerWithPaging(){
		return 
			listPagingRepository.findAll(Pageable.ofSize(2))
				.stream()
				.map(c -> CustomerDTO.customerObejctToCustomerDTO(c))
				.toList();
	}
	
	public List<CustomerDTO> finaAllCustomerWithPaging(int pageNumber){
		return 
			listPagingRepository.findAll(Pageable.ofSize(2).withPage(pageNumber))
				.stream()
				.map(c -> CustomerDTO.customerObejctToCustomerDTO(c))
				.toList();
	}
	
}
