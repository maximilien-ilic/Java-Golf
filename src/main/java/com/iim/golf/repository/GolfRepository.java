package com.iim.golf.repository;
import com.iim.golf.model.Golfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GolfRepository extends JpaRepository<Golfer, Integer> {

}
