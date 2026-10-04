package com.iim.golf.repository;

import com.iim.golf.model.Terain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerainRepository extends JpaRepository<Terain, Integer> {

}
