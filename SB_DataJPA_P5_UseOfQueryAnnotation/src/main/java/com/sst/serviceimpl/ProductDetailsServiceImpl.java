package com.sst.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sst.entity.ProductDetailsEntity;
import com.sst.repository.ProductDetailsRepo;
import com.sst.service.ProductDetailsService;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Autowired
	ProductDetailsRepo productDetailsRepo;

	@Override
	public void insertProduct() {
		ProductDetailsEntity prdDetails = new ProductDetailsEntity();
		try {
			System.out.println("=======Insert Product Details======");
			System.out.println("Enter Product Id: ");
			prdDetails.setPId(Long.parseLong(reader.readLine()));
			System.out.println("Enter Product Name: ");
			prdDetails.setPName(reader.readLine());
			System.out.println("Enter Product Description: ");
			prdDetails.setPDesc(reader.readLine());
			System.out.println("Enter Product Price: ");
			prdDetails.setPPrice(Float.parseFloat(reader.readLine()));
			System.out.println("Enter Product Exp Date(dd/MM/yyyy): ");
			String pExpDate = reader.readLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			prdDetails.setPExpDate((Date) sdf.parse(pExpDate)); // import util.Date NOT sql.date
			productDetailsRepo.save(prdDetails);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void updateProduct() {
		ProductDetailsEntity prdDetails = new ProductDetailsEntity();
		try {
			System.out.println("=======Update Product Details======");
			System.out.println("Enter Product Id: ");
			prdDetails.setPId(Long.parseLong(reader.readLine()));
			Boolean prdAvl = productDetailsRepo.existsById(prdDetails.getPId());
			if (prdAvl) {
				System.out.println("Enter Product Name: ");
				prdDetails.setPName(reader.readLine());
				System.out.println("Enter Product Description: ");
				prdDetails.setPDesc(reader.readLine());
				System.out.println("Enter Product Price: ");
				prdDetails.setPPrice(Float.parseFloat(reader.readLine()));
				System.out.println("Enter Product Exp Date(dd/MM/yyyy): ");
				String pExpDate = reader.readLine();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				prdDetails.setPExpDate((Date) sdf.parse(pExpDate)); // import util.Date NOT sql.date
				productDetailsRepo.save(prdDetails);
			} else {
				System.out.println("Product NOT found with this Id");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public List<ProductDetailsEntity> retrieveProduct() {
		List<ProductDetailsEntity> allPrdDetails = productDetailsRepo.getAllPrdDetails();
		System.out.println(allPrdDetails);
		return allPrdDetails;
	}
	
	@Override
	public List<ProductDetailsEntity> retrieveProductById(){
		List<ProductDetailsEntity> allPrdDetailsByIds = null;
		try {
			System.out.println("Enter MIN range:");
			Long min = Long.parseLong(reader.readLine());
			System.out.println("Enter MAX range:");
			Long max = Long.parseLong(reader.readLine());
			allPrdDetailsByIds = productDetailsRepo.getSelectedPrdDetailsByIds(min, max);
			System.out.println("Product Details");
			allPrdDetailsByIds.forEach(data->System.out.println(data));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return allPrdDetailsByIds;
	}
	@Override
	public void deleteProduct(Long pId) {
		if(productDetailsRepo.existsById(pId)) {
			productDetailsRepo.deleteById(pId);
		}
		else {
			System.err.println("Record NOT found");
		}
	}
}
