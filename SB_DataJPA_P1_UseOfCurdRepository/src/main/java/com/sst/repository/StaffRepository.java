package com.sst.repository;
import org.springframework.data.repository.CrudRepository;

import com.sst.entity.StaffEntity;


public interface StaffRepository extends CrudRepository<StaffEntity,Integer>{
	
}
//This above interface extends CrudRepository so during runtime it dynamically use PROXY class to execute
//CURD operation that class provide necessary methods in runtime.