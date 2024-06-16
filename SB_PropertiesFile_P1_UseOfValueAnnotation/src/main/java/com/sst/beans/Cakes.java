package com.sst.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("cake")
@Data
public class Cakes {
	
	//property values
	@Value("${ck.weight}")
	private float weight;
	
	//property values
	@Value("${ck.price}")
	private float price;
	
	//property values
	@Value("${ck.qty}")
	private int quantity;
	
}

