package com.sst.runner;

//Step-5
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sst.service.OperationImpl;

@Component
public class RunnerClass implements CommandLineRunner{

	@Autowired
	OperationImpl operationImpl;
	
	@Override
	public void run(String... args) throws Exception {
		operationImpl.operation();
	}
	

}
