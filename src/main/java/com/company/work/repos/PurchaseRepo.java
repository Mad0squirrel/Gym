package com.company.work.repos;

import com.company.work.domain.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends CrudRepository<Purchase, Integer> {
}
