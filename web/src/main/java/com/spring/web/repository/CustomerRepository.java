package com.spring.web.repository;

import com.spring.web.dto.OrderResponse;
import com.spring.web.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
    @Query("Select new com.spring.web.dto.OrderResponse(c.name,p.productName) from Customer c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
