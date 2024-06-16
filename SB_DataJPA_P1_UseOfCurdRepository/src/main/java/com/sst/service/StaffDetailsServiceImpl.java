package com.sst.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.entity.StaffEntity;
import com.sst.repository.StaffRepository;

@Service("serviceClass")
public class StaffDetailsServiceImpl {

	@Autowired
	public StaffRepository staffRepository;

	Logger logger = Logger.getLogger(getClass().getName());

	public Integer staffRegister() {
		Integer resId = 0;
		StaffEntity entity = new StaffEntity();
		entity.setSId(1001);
		entity.setSName("Suresh");
		entity.setSDept("Science");
		entity.setSSubject("Physics");
		entity.setSSalary(1500.36f);
		try {
			StaffEntity resEntity = staffRepository.save(entity);
			resId = resEntity.getSId();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		return resId;
	}
}
