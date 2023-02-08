package com.ecart.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecart.customer.request.CustomerDTO;
import com.ecart.customer.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Operation(summary = "Get a person by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the person",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid person id",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Person not found",
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
			content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> findPersonById(@Parameter(description = "id of person to be searched")
	@PathVariable int id){
		CustomerDTO person = CustomerDTO.builder().id(id).build();
		person = service.getCustomer(id);		
		return ResponseEntity.ok(person);		
	}
	

	@Operation(summary = "finaAllCustomerWithPaging")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "finaAllCustomerWithPaging",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid person id",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Person not found",
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
			content = @Content)
	})
	@GetMapping("/paging")
	public ResponseEntity<List<CustomerDTO>> finaAllCustomerWithPaging(){
		List<CustomerDTO> person = service.finaAllCustomerWithPaging();		
		return ResponseEntity.ok(person);		
	}
	

	@Operation(summary = "finaAllCustomerWithPaging")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "finaAllCustomerWithPaging",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid person id",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Person not found",
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
			content = @Content)
	})
	@GetMapping("/paging/{pageNumber}")
	public ResponseEntity<List<CustomerDTO>> finaAllCustomerWithPaging(@PathVariable String pageNumber){
		List<CustomerDTO> person = service.finaAllCustomerWithPaging(Integer.parseInt(pageNumber));		
		return ResponseEntity.ok(person);		
	}
	

	@Operation(summary = "findAllCustomerListSortByName")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "findAllCustomerListSortByName",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid person id",
					content = @Content),
			@ApiResponse(responseCode = "404", description = "Person not found",
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
			content = @Content)
	})
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> findAllCustomerListSortByName(){
		List<CustomerDTO> person = service.findAllCustomerListSortByName();		
		return ResponseEntity.ok(person);	
	}
	
	
	
	@Operation(summary = "Save person")
	@ApiResponses( value = {
			@ApiResponse(responseCode = "200", description = "Save person successful",
					content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerDTO.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid person data",
			content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal server error",
			content = @Content)
	})
	@PostMapping
	public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO dto){
		dto = service.save(dto);
		return ResponseEntity.ok(dto);
	}

}
