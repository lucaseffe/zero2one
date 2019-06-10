package com.zero2one.desafio_2.repository;

import com.zero2one.desafio_2.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository <Request, String> {
}
