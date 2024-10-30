package com.revature.daos;

import com.revature.models.Reimb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbDAO extends JpaRepository<Reimb, Integer> {
}
