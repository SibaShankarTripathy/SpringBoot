package com.sst.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sst.entity.DoctorDetails;
import com.sst.repository.DoctorDetailsRepository;
import com.sst.service.DoctorDetailsService;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
	DoctorDetailsRepository doctorDetailsRepo;

	/* use of Sort, Direction */
	@Override
	public Iterable<DoctorDetails> sortRecordsBySingleProperties() {
		/* Properties is column name of table */
		System.err.println("==Sort by single properties==");
		Sort srt = Sort.by("dName");
		Iterable<DoctorDetails> findAll = doctorDetailsRepo.findAll(srt);
		return findAll;
	}

	@Override
	public Iterable<DoctorDetails> sortRecordsByMultiProperties() {
		/* For multiple properties we need a String Array */
		System.err.println("==Sort by multiple properties==");
		String[] properties = { "dName", "dSalary" };
		Sort srt = Sort.by(properties);
		Iterable<DoctorDetails> findAll = doctorDetailsRepo.findAll(srt);
		return findAll;
	}

	@Override
	public Iterable<DoctorDetails> sortRecordByDirection() {
		/* SortingRecords using Direction and single properties */
		System.err.println("==Sort by single properties and use Direction ASC order==");
		Sort srt = Sort.by(Direction.ASC, "dSalary");
		Iterable<DoctorDetails> findAll = doctorDetailsRepo.findAll(srt);
		return findAll;
	}

	@Override
	public Iterable<DoctorDetails> sortRecords() {
		System.err.println("==Sort by Multiproperties and Direction==");
		String[] properties = { "dName", "dId" };
		Sort srt = Sort.by(Direction.DESC, properties);
		Iterable<DoctorDetails> findAll = doctorDetailsRepo.findAll(srt);
		return findAll;
	}
	public void findPageable() {
		/* Create Pageable object means make record into pages*/
		System.err.println("========Pageable======");
		Pageable page = PageRequest.of(1, 3, Direction.ASC, "dId");
		Page<DoctorDetails> pageDetails = doctorDetailsRepo.findAll(page);
		List<DoctorDetails> content = pageDetails.getContent();
		for(DoctorDetails ds:content) {
			System.out.println(ds);
		}
		System.err.println(pageDetails.get());
		
	}
}
