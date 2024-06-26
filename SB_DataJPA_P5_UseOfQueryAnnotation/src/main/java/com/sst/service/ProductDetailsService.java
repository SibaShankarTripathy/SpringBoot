package com.sst.service;

import java.util.List;

import com.sst.entity.ProductDetailsEntity;

public interface ProductDetailsService {
	public void insertProduct();

	public void updateProduct();

	public void deleteProduct(Long pId);

	public void retrieveProduct();

	public void retrieveProductByPriceRange();
	
	public void getProductDetailsByProductName();
	
	public void getSelectedColumnValue();

}
