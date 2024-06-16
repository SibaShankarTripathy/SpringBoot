package com.sst.repository;

//Step-3
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sst.entity.StaffDetails;

@Repository
public interface OperationRepo extends CrudRepository<StaffDetails, Integer> {

}
