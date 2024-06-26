package com.sst.runner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sst.service.ProductDetailsService;

@Component
public class ProductDetailsRunner implements CommandLineRunner {

	@Autowired
	ProductDetailsService productDetailsService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Progrommer");
		operation();
	}
	public void operation() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int maxLoop = 1;
		while (maxLoop <= 8) {
			System.out.println("Select your choice: \n1-Insert single records" + "\n2-Find all records"
					+ "\n3-Find Records By price range " +"\n4-Update exist record"+ "\n5-Delete records by Ids"+ "\n6-Get record by name"+ "\n7-Get specific column" + "\n0-Exit");
			try {
				Integer num = Integer.parseInt(reader.readLine());
				if (num >= 0 && num <= 8) {
					switch (num) {
					case 0: {
						System.out.println("All Operation Stopped");
						System.exit(0);
					}
					case 1: {
						System.out.println("You selected to insert record");
						productDetailsService.insertProduct();
						break;
					}
					case 2: {
						System.out.println("You selected to find all records");
						productDetailsService.retrieveProduct();
						break;
					}
					case 3: {
						System.out.println("You selected to findByID records");
						productDetailsService.retrieveProductByPriceRange();
						break;
					}
					case 4: {
						System.out.println("You selected to record update");
						productDetailsService.updateProduct();
						break;
					}
					case 5: {
						System.out.println("You selected to get total number of record");
//						count();
						break;
					}
					case 6: {
						System.out.println("You selected to get record by product name");
						productDetailsService.getProductDetailsByProductName();
						break;
					}
					case 7: {
						System.out.println("You selected to get selected column values");
						productDetailsService.getSelectedColumnValue();
						break;
					}
					default:
						throw new IllegalArgumentException("Enter Valid Number 0 to 5 not this: " + num);
					}
				} else {
					System.err.println("Enter valid number");
				}
			} catch (Exception e) {
				System.err.println("Do not enter anything otherthen integer number");
				System.err.println("Enter a valid number 0 - 5");
				System.out.println(e.getMessage());
			}
			maxLoop++;
		}
		System.err.println("You reached maximum loop value re-run application");
	}

}
