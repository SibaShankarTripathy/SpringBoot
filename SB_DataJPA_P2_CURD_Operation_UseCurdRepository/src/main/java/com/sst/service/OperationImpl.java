package com.sst.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Step-4
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.entity.StaffDetails;
import com.sst.repository.OperationRepo;

@Service
public class OperationImpl implements Operation {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Autowired
	OperationRepo operationRepo;

	@Override
	public void operation() {
		int maxLoop = 1;
		while (maxLoop <= 24) {
			System.out.println("Select your choice: \n1-Insert single records" + "\n2-Find all records"
					+ "\n3-Check record exist or not" + "\n4-Get number of records" + "\n5-Get record by ID"
					+ "\n6-Get multiple records by IDs" + "\n7-Insert multiple records" + "\n8-Delete single records"
					+ "\n9-Delete single record using delete()" + "\n10-Delete multiple record using Ids"
					+ "\n11-Delete all record from table..." + "\n12-Delete records by Ids" + "\n0-Exit");
			try {
				Integer num = Integer.parseInt(reader.readLine());
				if (num >= 0 && num <= 12) {
					switch (num) {
					case 0: {
						System.out.println("All Operation Stopped");
						System.exit(0);
					}
					case 1: {
						System.out.println("You selected to insert record");
						insertRecords();
						break;
					}
					case 2: {
						System.out.println("You selected to find all records");
						findAllRecords();
						break;
					}
					case 3: {
						System.out.println("You selected to record exist or not");
						System.out.println("Enter Staff id:");
						int id = Integer.parseInt(reader.readLine());
						existById(id);
						break;
					}
					case 4: {
						System.out.println("You selected to get total number of record");
						count();
						break;
					}
					case 5: {
						System.out.println("You selected to find records by Id");
						findRecordsById();
						break;
					}
					case 6: {
						System.out.println("You selected to find multiple Records By Ids");
						findAllRecordsByID();
						break;
					}

					case 7: {
						System.out.println("Selected to insert multiple records");
						saveMultipleRecords();
						break;
					}
					case 8: {
						System.out.println("Selected to delete single using deleteById() records");
						deleteById();
						break;
					}
					case 9: {
						System.out.println("Selected to delete single using delete() records");
						delete();
						break;
					}
					case 10: {
						System.out.println("Selected to delete record using deleteAllById()");
						deleteAllById();
						break;
					}
					case 11: {
						System.out.println("Selected to delete all records of table");
						deleteAll();
						break;
					}
					case 12: {
						System.out.println("Selected to delete using Ids");
						deleteAllRecords();
						break;
					}

					default:
						throw new IllegalArgumentException("Enter Valid Number 1 to 12 not this: " + num);
					}
				} else {
					System.err.println("Enter valid number");
				}
			} catch (Exception e) {
				System.err.println("Do not enter anything otherthen integer number");
				System.err.println("Enter a valid number 0 - 12");
				System.out.println(e.getMessage());
			}
			maxLoop++;
		}
		System.err.println("You reached maximum loop value re-run application");
	}

	/* Use of save() */
	@Override
	public void insertRecords() {
		/* .save() method return type is same entity type */
		System.out.println("=======Use of save(S entity)=======");
		System.out.println("=======Return_Type: the saved entity; will never be null=======");
		try {
			StaffDetails insertDetails = new StaffDetails();
			/* Taking value from user */
			System.out.println("Enter Staff Id: ");
			Integer sId = Integer.parseInt(reader.readLine());
			System.out.println("Enter Staff Name: ");
			String sName = reader.readLine();
			System.out.println("Enter Staff Desgination: ");
			String sDesg = reader.readLine();
			System.out.println("Enter Staff Salary: ");
			Float sSal = Float.parseFloat(reader.readLine());

			/* setting values in bean */
			insertDetails.setSId(sId);
			insertDetails.setSName(sName);
			insertDetails.setSDesg(sDesg);
			insertDetails.setSSalary(sSal);
			int sid = 0;
			StaffDetails save = operationRepo.save(insertDetails);
			sid = save.getSId();
			System.out.println("Record inserted successfully having Id is: " + sid);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of existsById() */
	@Override
	public void existById(int sid) {
		System.out.println("=======Use of existsById(ID id)=======");
		System.out.println("=======Return_Type: true if an entity with the given id exists, otherwise false.=======");
		try {
			boolean val = operationRepo.existsById(sid);
			System.out.println((val == true ? "Record exist" : "Record not exist.."));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of count() */
	@Override
	public void count() {
		System.out.println("=======Use of count()=======");
		System.out.println("=======Return_Type: Returns the number of entities available.=======");
		try {
			long count = operationRepo.count();
			System.out.println("Total number of records: " + count);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/* Use of findAll() */
	@Override
	public void findAllRecords() {
		System.out.println("=======Use of findAll()=======");
		System.out.println("=======Return_Type: Returns all instances of the type.=======");
		try {
			/* Approach_1 */
			Iterable<StaffDetails> findAll = operationRepo.findAll();
			for (StaffDetails objRef : findAll) {
				System.out.println(objRef);
			}
			System.out.println("........................");
			/* Approach_2 */
			operationRepo.findAll().forEach(obj -> System.out.println(obj));
			System.out.println("........................");
			/* Approach_3 */
			operationRepo.findAll().forEach(System.out::println);
			System.out.println("........................");
			/* Approach_4 */
			Arrays.asList(operationRepo.findAll()).stream().forEach(System.out::println);
			System.out.println("........................");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of findAllById() */
	@Override
	public void findAllRecordsByID() {
		System.out.println("=======Use of findAllById(Iterable<ID> ids)=======");
		System.out.println("=======Return_Type: Returns all instances of the type T with the given IDs.=======");
		try {
			System.out.println("How many record's(in Number) you want to see:  ");
			Integer records = Integer.parseInt(reader.readLine());
			List<Integer> recordIdList = new ArrayList<>();
			for (int i = 1; i <= records; i++) {
				System.out.println("Enter " + i + " records ID: ");
				Integer id = Integer.parseInt(reader.readLine());
				recordIdList.add(id);
			}
			System.out.println("........................");
			Iterable<StaffDetails> allDetailsById = operationRepo.findAllById(recordIdList);
			System.out.println("All Staff details by Ids " + allDetailsById);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of findById() */
	@Override
	public void findRecordsById() {
		System.out.println("=======Use of findById(ID id)=======");
		System.out.println("=======Return_Type: Retrieves an entity by its id.=======");
		try {
			System.out.println("Enter StaffID: ");
			Integer staffId = Integer.parseInt(reader.readLine());
			/* Approach_1 */
			Optional<StaffDetails> findStaffById = operationRepo.findById(staffId);
			System.out.println(findStaffById.isEmpty() ? "No Data found" : findStaffById.get());
			/* Approach_2 */
			System.out.println("........................");
			System.out.println(findStaffById.isPresent() ? findStaffById.get()
					: new IllegalArgumentException("Sorry your record not found....."));
			/* Approach_3 */
			/*
			 * In this approach if record found then give optional object(StaffDetails
			 * Entity) otherwise it will throw new empty Entity
			 */
			System.out.println("........................");
			System.out.println(findStaffById.orElse(new StaffDetails()));
			/* Approach_4 */
			/*
			 * In this approach if record NOT found then return optional class empty()
			 * otherwise will return StaffDetails Entity
			 */
			System.out.println("........................");
			System.out.println(findStaffById.isEmpty() ? Optional.empty() : findStaffById);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/* Use of saveAll() */
	@Override
	public void saveMultipleRecords() {
		System.out.println("=======Use of saveAll(Iterable<S> entities)=======");
		System.out.println("=======Return_Type: Saves all given entities.=======");
		try {
			List<StaffDetails> staffList = new ArrayList<>();
			System.out.println("Enter number of record wish to insert: ");
			Integer totalrec = Integer.parseInt(reader.readLine());

			for (int i = 1; i <= totalrec; i++) {
				/* Taking value from user */
				System.out.println("Enter Staff Id: ");
				Integer sId = Integer.parseInt(reader.readLine());
				System.out.println("Enter Staff Name: ");
				String sName = reader.readLine();
				System.out.println("Enter Staff Desgination: ");
				String sDesg = reader.readLine();
				System.out.println("Enter Staff Salary: ");
				Float sSal = Float.parseFloat(reader.readLine());
				/* Approach_1 */
				staffList.add(new StaffDetails(sId, sName, sDesg, sSal));
				/* Approach_2 */
//				staffList = List.of(new StaffDetails(2001,"ABC","Test1",1000),new StaffDetails(2002,"BCD","Test2",1000),new StaffDetails(2003,"CDE","Test3",1000));
			}
			Iterable<StaffDetails> saveAllRecords = operationRepo.saveAll(staffList);
			saveAllRecords.forEach(val -> System.out.println(val));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of deleteById() */
	@Override
	public void deleteById() {
		System.out.println("=======Use of deleteById(ID id)=======");
		System.out.println("=======Return_Type: Deletes the entity with the given id.=======");
		try {
			System.out.println("Enter record id to delete: ");
			int num = Integer.parseInt(reader.readLine());
			Optional<StaffDetails> details = operationRepo.findById(num);
			if (details.isPresent()) {
				operationRepo.deleteById(num);
				System.out.println("Record deleted successfully having id: " + num);
			} else {
				System.out.println("Id: " + num + " Record NOT found");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of delete() */
	@Override
	public void delete() {
		System.out.println("=======Use of delete(T entity)=======");
		System.out.println("=======Return_Type: Deletes a given entity.=======");
		try {
			System.out.println("Enter record id to delete: ");
			Integer num = Integer.parseInt(reader.readLine());
			StaffDetails details = operationRepo.findById(num)
					.orElseThrow(() -> new IllegalArgumentException("Record not found"));
			operationRepo.delete(details);
			System.out.println("Record deleted sucessfully");
			// ----OR----
			/*
			 * StaffDetails detail = new StaffDetails(); detail.setSId(num);
			 * Optional<StaffDetails> obj = operationRepo.findById(num); if(obj.isPresent())
			 * { operationRepo.delete(detail);
			 * System.out.println("Record deleted successfully"); } else {
			 * System.out.println("Record not found"); }
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Use of deleteAllById() */
	@Override
	public void deleteAllById() {
		System.out.println("=======Use of deleteAllById(Iterable<? extends ID> ids)=======");
		System.out.println("=======Return_Type: Deletes all instances of the type T with the given IDs.=======");
		try {
			System.out.println("Enter numbers of record to be deleted: ");
			Integer num = Integer.parseInt(reader.readLine());
			List<Integer> userNumList = new ArrayList<>();
			List<Integer> numList = new ArrayList<>();
			Integer id = 0;
			for (int i = 1; i <= num; i++) {
				System.out.println("Enter " + i + " staffId: ");
				id = Integer.parseInt(reader.readLine());
				userNumList.add(id);
			}
			for (Integer numId : userNumList) {
				if (operationRepo.existsById(numId)) {
					numList.add(numId);
				} else {
					System.out.println(numId + " Id does not exist....");
				}
			}
			if (numList.size() > 0) {
				operationRepo.deleteAllById(numList);
				System.out.println(numList + " records deleted successfully.......");
			} else {
				System.out.println("No records deleted....");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/* Use of deleteAll() */
	/* This method will delete multiple records using object not by Ids */
	@Override
	public void deleteAllRecords() {
		System.out.println("=======Use of deleteAll(Iterable<? extends T> entities)=======");
		System.out.println("=======Return_Type: Deletes the given entities.=======");
		try {
			System.out.println("Enter numbers of records to be delete: ");
			Integer num = Integer.parseInt(reader.readLine());
			List<Integer> inputIdList = new ArrayList<>();
			List<Integer> idList = new ArrayList<>();
			for (int i = 1; i <= num; i++) {
				System.out.println("Enter " + i + " records Id: ");
				inputIdList.add(Integer.parseInt(reader.readLine()));
			}
			/* To check id exist or not for avoiding exception */
			for (Integer idNum : inputIdList) {
				if (operationRepo.existsById(idNum)) {
					idList.add(idNum);
				} else {
					System.out.println("Id number " + idNum + " does not exist");
				}
			}
			/* Getting all records as object by using Ids */
			Iterable<StaffDetails> deleteIdList = operationRepo.findAllById(idList);
			System.out.println("Are you sure to delete your Ids record (Y/N)");
			String choice = reader.readLine();
			if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
				operationRepo.deleteAll(deleteIdList);
				System.out.println("Your given Id's record deleted successfully");
			} else {
				System.out.println("No records deleted...");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/* Use of deleteAll() */
	@Override
	public void deleteAll() {
		System.out.println("=======Use of deleteAll()=======");
		System.out.println("=======Return_Type: Deletes all entities managed by the repository.=======");
		try {
			System.out.println("This will delete all records of table are sure?");
			System.out.println("Type Y/N");
			String conf = reader.readLine();
			if (conf.equalsIgnoreCase("y") || conf.equalsIgnoreCase("yes")) {
				operationRepo.deleteAll();
				System.out.println("All records deleted successfully....");
			} else {
				System.out.println("No records deleted....");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
