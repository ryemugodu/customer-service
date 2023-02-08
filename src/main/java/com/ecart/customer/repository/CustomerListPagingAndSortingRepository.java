package com.ecart.customer.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface CustomerListPagingAndSortingRepository
		extends ListPagingAndSortingRepository<CustomerEntity, Integer> {

}
