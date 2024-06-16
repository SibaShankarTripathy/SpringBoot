package com.sst.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.sst.entity.DoctorDetails;

@Repository
public interface DoctorDetailsRepository extends PagingAndSortingRepository<DoctorDetails, Integer> {

}
