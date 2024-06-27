package com.sst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sst.entity.CustomerDtailsEntity;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDtailsEntity, Long>{
	
	@Query("update CustomerDtailsEntity set cstmrName = ?1 where cstmrId = ?2")
	public Integer changeCustomerName(String customerName, Long customerId);
	
	@Query("from CustomerDtailsEntity order by cstmrName asc")
	public List<CustomerDtailsEntity> getAllCustomerdetails(); 

	@Query("delete from CustomerDtailsEntity where cstmrId = :customerId")
	public Integer deleteCustomerRecordById(Long customerId);
}
