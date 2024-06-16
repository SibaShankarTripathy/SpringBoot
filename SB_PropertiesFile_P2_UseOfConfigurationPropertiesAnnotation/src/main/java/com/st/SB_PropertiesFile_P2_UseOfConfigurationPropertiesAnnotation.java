package com.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.st.bean.EmployeeDetails;

@SpringBootApplication
public class SB_PropertiesFile_P2_UseOfConfigurationPropertiesAnnotation {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SB_PropertiesFile_P2_UseOfConfigurationPropertiesAnnotation.class, args);
		EmployeeDetails emp = ctx.getBean("EmpClass", EmployeeDetails.class);
		System.out.println(emp);
	}

}
