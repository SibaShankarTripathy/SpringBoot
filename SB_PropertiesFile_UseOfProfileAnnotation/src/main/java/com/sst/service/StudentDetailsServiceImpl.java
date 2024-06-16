package com.sst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.common.StudentBean;
import com.sst.repository.StudentDetailsRepositoryImpl;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService{
	
	@Autowired
	public StudentDetailsRepositoryImpl studentDetailsRepositoryImpl;
	
	public List<StudentBean> retrieveStudentDetails(){
		return studentDetailsRepositoryImpl.retrieveStudentDetails();
	}

}
