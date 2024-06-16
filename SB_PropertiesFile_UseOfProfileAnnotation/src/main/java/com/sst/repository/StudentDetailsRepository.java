package com.sst.repository;

import java.util.List;

import com.sst.common.StudentBean;

public interface StudentDetailsRepository {
	public List<StudentBean> retrieveStudentDetails();
}
