package com.sst;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sst.common.StudentBean;
import com.sst.controller.StdentDetailsCotroller;

@SpringBootApplication
public class SB_PropertiesFile_UseOfProfileAnnotation {

    @Bean("c3p0DS")
    @Profile("uat")
    ComboPooledDataSource createc3p0DataSource() {
    	//To achieve this we need c3p0 dependency
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("org.postgresql.Driver");
			cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
			cpds.setUser("postgres");
			cpds.setPassword("Shankar1234");
			System.out.println("Bean executed for postgre sql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpds;
	}

	public static void main(String[] args) {
		// Creating container
		ApplicationContext ctx = SpringApplication.run(SB_PropertiesFile_UseOfProfileAnnotation.class, args);
		// getting Bean object.
		StdentDetailsCotroller controller = ctx.getBean("controlerClass", StdentDetailsCotroller.class);
		// Store bean object value in array list
		List<StudentBean> list = controller.retrieveStudentDetails();
		for (StudentBean bean : list) {
			System.out.println("Student ID: " + bean.getId());
			System.out.println("Student Name: " + bean.getName());
			System.out.println("Student Standard: " + bean.getStd());
			System.out.println("Student Address: " + bean.getAddress());
			System.out.println("Student Score: " + bean.getScore());
			System.out.println("================");

		}
	}

}
