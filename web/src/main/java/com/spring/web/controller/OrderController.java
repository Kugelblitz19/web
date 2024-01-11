package com.spring.web.controller;

import com.spring.web.dto.OrderRequest;
import com.spring.web.dto.OrderResponse;
import com.spring.web.entity.Customer;
import com.spring.web.repository.CustomerRepository;
import com.spring.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
      return  customerRepository.save(orderRequest.getCustomer());
    }
    @GetMapping("/findAllOrders")
    public List<Customer>findAllOrders(){
        return customerRepository.findAll();
    }
    @GetMapping("/getInfo")
    public List<OrderResponse>getJoinInformation(){
        return customerRepository.getJoinInformation();
    }
}
