package com.company.work.repos;

import com.company.work.domain.Usr;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepo extends CrudRepository<Usr, Integer> {
}