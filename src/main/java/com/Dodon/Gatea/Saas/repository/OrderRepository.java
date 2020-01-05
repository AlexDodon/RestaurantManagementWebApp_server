package com.Dodon.Gatea.Saas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dodon.Gatea.Saas.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

}