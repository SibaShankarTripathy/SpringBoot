package com.sst.service;

public interface Operation {
	public void operation();
	public void insertRecords();
	public void existById(int sid);
	public void count();
	public void findAllRecords();
	public void findAllRecordsByID();
	public void findRecordsById();
	public void saveMultipleRecords();
	public void deleteById();
	public void delete();
	public void deleteAllById();
	public void deleteAllRecords();
	public void deleteAll();
}
