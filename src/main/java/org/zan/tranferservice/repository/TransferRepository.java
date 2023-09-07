package org.zan.tranferservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zan.tranferservice.model.Transfer;

/**
 * Repository interface for managing {@link Transfer} entities.
 * This repository provides CRUD (Create, Read, Update, Delete) operations for transfers.
 * @author :Muhammad Fauzan
 */
public interface TransferRepository extends JpaRepository<Transfer,Integer> {
}
