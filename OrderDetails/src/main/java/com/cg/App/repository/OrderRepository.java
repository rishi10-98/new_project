package com.cg.App.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.App.model.Order;



public interface OrderRepository extends JpaRepository<Order,Long> {

}







