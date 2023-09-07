package org.zan.tranferservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zan.tranferservice.model.Order;

/**
 * Repository interface for managing {@link Order} entities.
 * This repository provides CRUD (Create, Read, Update, Delete) operations for orders.
 *
 * @author :Muhammad Fauzan
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
