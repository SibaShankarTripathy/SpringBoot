package com.sst.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="Doctor_Details")
@Data
public class DoctorDetails implements Serializable{
	@Id
	Integer dId;
	
	@Column(name = "dName",length = 20)
	String dName;
	
	@Column(name = "dAddress",length = 30)
	String dAddress;

	@Column(name = "dSalary")
	Float dSalary;
	
}
