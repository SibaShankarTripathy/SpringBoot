package com.sst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sst.store.GeneralStore;

@SpringBootApplication
public class SB_PropertiesFile_P4_UseOfConfigurationPropertiesInObject {

	public static void main(String[] args) {
		//Getting Container
		ApplicationContext ctx = SpringApplication.run(SB_PropertiesFile_P4_UseOfConfigurationPropertiesInObject.class, args);
		//Get bean object of class
		GeneralStore generalStore = ctx.getBean("generalStore",GeneralStore.class);
		System.out.println(generalStore);
	}

}
