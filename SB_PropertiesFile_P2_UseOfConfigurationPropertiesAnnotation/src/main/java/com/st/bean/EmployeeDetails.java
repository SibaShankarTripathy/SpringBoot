package com.st.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("EmpClass")
@ConfigurationProperties(prefix = "emp.detail")
@Data
public class EmployeeDetails {
	private String name;
	private String id;
	private String role;
	private String address;
/*When we are using @Data then no need to override toString() method
If We use @Setter then we need to override toString() method in this class.
If we will not override then in main method if we try to print bean object then it will print hash code not value
*/
	
/*By the using of @ConfigurationProperties(Using setter injection by calling method) no need to keep @Value for each individual variable value injection.
 * If we will still keep @Value along with @ConfigurationProperties then at final @ConfigurationProperties value only display because
 @Value is using at field level injection which is done before setter injection*/
	
}
