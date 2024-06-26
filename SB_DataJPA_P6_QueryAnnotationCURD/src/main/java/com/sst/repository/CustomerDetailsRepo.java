package com.sst.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sst.entity.CustomerDtailsEntity;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDtailsEntity, Long>{

}
