package com.sst.service;

import com.sst.entity.DoctorDetails;

public interface DoctorDetailsService {
	public Iterable<DoctorDetails> sortRecordsBySingleProperties();

	public Iterable<DoctorDetails> sortRecordsByMultiProperties();

	public Iterable<DoctorDetails> sortRecordByDirection();

	public Iterable<DoctorDetails> sortRecords();

}
