package com.sst.store;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component("generalStore")
@ConfigurationProperties(prefix = "gen.store")
public class GeneralStore {
/*
 We can inject value from properties file using ConfigurationProperties annotation into 
 1. Normal variable
 2. Array type variable
 3. Collection type variable
 4. HAS-A type reference variable
 in this class we will see this.
 */

//Normal variable
private String snacks;
private String softDrink;

//Array type
private String[] stringArrayType;

//List type
private List<String> listType;

//Set Type
private Set<String> setType;

//Map Type
private Map<String, Object> mapType;

//HAS-A type
private MegaStore megaStore;

}
