package com.sst.entity;

//Step-2
import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity(name = "HospDetails")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDetails implements Serializable{
	
	@Id
	@NotNull
	@Column(name = "staff_Id")
	private Integer sId;
	
	@NotNull
	@Column(name = "staff_Name", length = 20)
	private String sName;
	
	@NotNull
	@Column(name = "staff_Desg", length = 20)
	private String sDesg;
	
	@NotNull
	@Column(name = "staff_Salary")
	private float sSalary;
	
}
/*After Completion Step-1 and Step-2 just Run it will create a table in DB*/
