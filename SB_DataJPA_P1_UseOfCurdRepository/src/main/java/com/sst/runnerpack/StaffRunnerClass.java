package com.sst.runnerpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sst.service.StaffDetailsServiceImpl;

@Component
public class StaffRunnerClass implements CommandLineRunner {

	@Autowired
	StaffDetailsServiceImpl staffDetailsServiceImpl;
	
	@Override
	public void run(String... args) throws Exception {
		Integer resId;
		resId = staffDetailsServiceImpl.staffRegister();
		System.out.println("Data Register with Id number is : "+resId);

	}
}

