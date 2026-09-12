package com.mycom.springjdbcapidemo1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycom.springjdbcapidemo1.model.CustOrder;
import com.mycom.springjdbcapidemo1.repository.CustOrderRepository;

public class CustOrderController {

	private final CustOrderRepository custOrderRepository;

	public CustOrderController(CustOrderRepository custOrderRepository) {
		this.custOrderRepository = custOrderRepository;
	}

	@GetMapping("/custorder")
	public ResponseEntity<List<CustOrder>> getAllCustOrders() {
		List<CustOrder> custOrders = custOrderRepository.findAll();
		return ResponseEntity.ok(custOrders);
	}

	@GetMapping("/custorder/id/{orderId}")
	public ResponseEntity<CustOrder> getCustOrderByOrderId(@PathVariable Integer orderId) {
		return custOrderRepository.findById(orderId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/custorder/{customerName}")
	public ResponseEntity<CustOrder> getCustOrderByCustomerName(@PathVariable String customerName) {
		return custOrderRepository.findByCustomerName(customerName)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	//	@PostMapping("/custorder-find-by-customer-name")
	//	public ResponseEntity<CustOrder> getCustOrderByCustomerNameByPost(@RequestBody CustomerNameDto customerNameDto) {
	//		return custOrderRepository.findByCustomerName(customerNameDto.customerName())
	//				.map(ResponseEntity::ok)
	//				.orElse(ResponseEntity.notFound().build());
	//	}

	//	@PostMapping("/custorder")
	//	public CustOrder getCustOrderByCustomerNameByPost(@RequestBody CustOrder custOrder) {
	//		return custOrderRepository.save(custOrder);
	//	}

	@PostMapping("/custorder")
	public ResponseEntity<CustOrder> createCustOrder(@RequestBody CustOrder custOrder) {
		custOrderRepository.insert(custOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body(custOrder);// 201 Created status code
	}
}
