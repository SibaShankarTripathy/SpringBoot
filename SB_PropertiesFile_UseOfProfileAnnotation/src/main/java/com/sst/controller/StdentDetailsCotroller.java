package com.sst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sst.common.StudentBean;
import com.sst.service.StudentDetailsServiceImpl;

@Component("controlerClass")
public class StdentDetailsCotroller {
	@Autowired
	StudentDetailsServiceImpl studentDetailsServiceImpl;

	public List<StudentBean> retrieveStudentDetails() {
		return studentDetailsServiceImpl.retrieveStudentDetails();
	}

}
