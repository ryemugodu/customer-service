package com.ecart.customer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPagingAndSortingRepository extends PagingAndSortingRepository<CustomerEntity, Integer> {

}
