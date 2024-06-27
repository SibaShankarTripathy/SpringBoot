package com.sst.entity;

import java.io.Serializable;
import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CustomerDtails")
@Data
public class CustomerDtailsEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_prod_seq")
	@SequenceGenerator(name = "gen_prod_seq", sequenceName = "gen_prod_seq", allocationSize = 1)
	@Column(name = "CUSTOMER_ID")
	private Long cstmrId;
	
	@Column(name = "CUSTOMER_NAME", length = 20)
	@NonNull
	private String cstmrName;

	@Column(name = "CUSTOMER_DOB")
	private Date cstmrDob;

	@Column(name = "CUSTOMER_ADDRESS", length = 50)
	private String cstmrAddrss;
	
	@Column(name = "CUSTOMER_PHONE")
	@NonNull
	private Long cstmrPhn;
	
	@Column(name = "CUSTOMER_MAIL", length = 40)
	private String cstmrMail;
}
/*org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Entity 'com.sst.entity.CustomerDtailsEntity' has no identifier (every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)*/
