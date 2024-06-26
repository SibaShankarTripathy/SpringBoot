package com.sst.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class CustomerDtailsEntity implements Serializable {
	

}
/*org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Entity 'com.sst.entity.CustomerDtailsEntity' has no identifier (every '@Entity' class must declare or inherit at least one '@Id' or '@EmbeddedId' property)*/
