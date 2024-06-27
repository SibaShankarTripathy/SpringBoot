package com.sst.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.entity.CustomerDtailsEntity;
import com.sst.repository.CustomerDetailsRepo;
import com.sst.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Autowired
	CustomerDetailsRepo customerDetailsRepo;

	@Override
	public void insertNewCustomerdetails() {
		try {
			CustomerDtailsEntity customerDtailsEntity = new CustomerDtailsEntity();
			System.out.println("Enter Customer ID: ");
			Long id = Long.parseLong(reader.readLine());
			customerDtailsEntity.setCstmrId(id);
			System.out.println("Enter Customer Name: ");
			customerDtailsEntity.setCstmrName(reader.readLine());
			System.out.println("Enter Customer DOB: ");
			String dob = reader.readLine();
			SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
			customerDtailsEntity.setCstmrDob((Date) sdf.parse(dob));
			System.out.println("Enter Customer Phone Number: ");
			customerDtailsEntity.setCstmrPhn(Long.parseLong(reader.readLine()));
			customerDtailsEntity.setCstmrAddrss(reader.readLine());
			customerDetailsRepo.save(customerDtailsEntity);
			if (customerDetailsRepo.existsById(id))
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("Record NOT inserted successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void changeCustomerName() {
		try {
			System.out.println("Enter Customer ID: ");
			Long customerId = Long.parseLong(reader.readLine());
			System.out.println("Enter New Name");
			String customerName = reader.readLine();
			if (customerDetailsRepo.existsById(customerId)) {
				Integer cstmrName = customerDetailsRepo.changeCustomerName(customerName, customerId);
				System.out.println(cstmrName > 0 ? "Name Updated Successfully" : "Name not updated successfully");
			} else {
				System.out.println("This Id not exist in database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void getAllCustomerdetails() {
		List<CustomerDtailsEntity> allCustomerdetails = customerDetailsRepo.getAllCustomerdetails();
		if (allCustomerdetails != null && !allCustomerdetails.isEmpty()) {
			allCustomerdetails.forEach(detail -> {
				System.out.println(detail + " ");
			});
		}
	}

	@Override
	public void deleteCustomerRecordById() {
		try {
			System.out.println("Enter Customer ID to delete:  ");
			Long customerId = Long.parseLong(reader.readLine());
			if (customerDetailsRepo.existsById(customerId)) {
				Integer cstmrName = customerDetailsRepo.deleteCustomerRecordById(customerId);
				System.out.println(cstmrName > 0 ? "Record deleted Successfully" : "Record NOT deleted successfully");
			} else {
				System.out.println("This Id not exist in database");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
