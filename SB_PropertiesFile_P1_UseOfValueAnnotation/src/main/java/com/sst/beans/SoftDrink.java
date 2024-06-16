package com.sst.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("softdrink")
@Data
public class SoftDrink {

	//Hard code value inject
	@Value("Siva")
	private String name;
	
	//Hard code value inject
	@Value("10")
	private int roll;
	
	//Properties file value inject
	@Value("${sts.name}")
	private String softDrinkName;
	
	//Properties file value inject
	@Value("${sts.price}")
	private float price;
	
	//Environment Properties(fixed name)
	@Value("${os.name}")
	private String osname;
	
	//Environment Variable (fixed name)
	@Value("${path}")
	private String path;
	
//	@Autowired
//	private Cakes cakes;
	
	//Instead of using Autowired annotation I used here spring SPEL(Spring Expression Language) to get bean object value
	@Value("#{cake}")
	private Cakes cake;
}
