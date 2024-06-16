package com.sst.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sst.entity.DoctorDetails;
import com.sst.serviceImpl.DoctorDetailsServiceImpl;

@Component
public class RunnerClass implements CommandLineRunner {

	@Autowired
	DoctorDetailsServiceImpl doctorDetailsServiceImpl;

	@Override
	public void run(String... args) throws Exception {
		Iterable<DoctorDetails> sortSingleRecords = doctorDetailsServiceImpl.sortRecordsBySingleProperties();
		sortSingleRecords.forEach(records -> System.out.println(records));

		Iterable<DoctorDetails> sortMultiRecords = doctorDetailsServiceImpl.sortRecordsByMultiProperties();
		sortMultiRecords.forEach(records -> System.out.println(records));

		Iterable<DoctorDetails> sortRecordsDir = doctorDetailsServiceImpl.sortRecordByDirection();
		sortRecordsDir.forEach(records -> System.out.println(records));

		Iterable<DoctorDetails> sortRecords = doctorDetailsServiceImpl.sortRecords();
		sortRecords.forEach(records -> System.out.println(records));
		
		doctorDetailsServiceImpl.findPageable();

	}

}
