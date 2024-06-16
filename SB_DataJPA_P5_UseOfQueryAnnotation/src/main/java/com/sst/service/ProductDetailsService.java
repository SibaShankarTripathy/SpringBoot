package com.sst.service;

import java.util.List;

import com.sst.entity.ProductDetailsEntity;

public interface ProductDetailsService {
	public void insertProduct();

	public void updateProduct();

	public void deleteProduct(Long pId);

	public List<ProductDetailsEntity> retrieveProduct();

	public List<ProductDetailsEntity> retrieveProductById();

}
