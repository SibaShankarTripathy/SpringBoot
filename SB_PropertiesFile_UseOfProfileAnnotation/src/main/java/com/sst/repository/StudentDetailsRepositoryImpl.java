package com.sst.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.sst.common.StudentBean;

@Repository
@Profile({"dev","qa","uat","prod"})
//This above profile names should same as properties file spring.profiles.active name 
public class StudentDetailsRepositoryImpl {
	// Getting data source object
	@Autowired
	private DataSource ds;

	// Query for retrieving data
	private final static String GET_STUDENTS = "SELECT ID,NAME,STD,ADDRESS,SCORE FROM STUDENT";

	public List<StudentBean> retrieveStudentDetails() {
		List<StudentBean> studentList = null;
		try {
			studentList = new ArrayList<StudentBean>();
			// Establishing connection
			Connection con = ds.getConnection();
			System.out.println(ds.getConnection());
			// Set query in method for execution
			PreparedStatement statement = con.prepareStatement(GET_STUDENTS);
			System.out.println("Before Result set");
			// Executing query and store value in ResultSet
			ResultSet resultSet = statement.executeQuery();
			System.out.println("After Result set");
			// Getting value from ResultSet
			while (resultSet.next()) {
				StudentBean bean = new StudentBean();
				bean.setId(resultSet.getString(1));
				bean.setName(resultSet.getString(2));
				bean.setStd(resultSet.getString(3));
				bean.setAddress(resultSet.getString(4));
				bean.setScore(resultSet.getFloat(5));
				studentList.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}
}
