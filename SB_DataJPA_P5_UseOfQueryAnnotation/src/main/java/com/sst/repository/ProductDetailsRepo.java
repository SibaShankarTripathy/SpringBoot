package com.sst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sst.entity.ProductDetailsEntity;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetailsEntity, Long> {

//	When you are retrieving all column information then it is optional to mention SELECT *.
	@Query("from ProductDetailsEntity")
	public List<ProductDetailsEntity> getAllPrdDetails();

	
//	@Query("from ProductDetailsEntity where pId>=:min and pId<=:max")//Way 1
//	@Query("from ProductDetailsEntity as a where a.pId>=:min and a.pId<=:max")//Way 2 as a/ a also optional.
//	@Query("from ProductDetailsEntity as a where a.pId>=?1 and a.pId<=?2")//Way 3:- Here ? is ordinal positional param, 1 denote First position of method parameter and 2 is second position of method parameter 
//	public List<ProductDetailsEntity> getAllPrdDetailsByIds(Long min,Long max);
//									OR
//	@Query("from ProductDetailsEntity where pId>=?1 and pId<=?2")
//	public List<ProductDetailsEntity> getAllPrdDetailsByIds(@Param("min")Long parm1, @Param("max")Long param2);
	
//	@Query("from ProductDetailsEntity where pId in(?1, ?2)") //Way-1
	@Query("from ProductDetailsEntity where pId in(:min, :max)")//Way-2
	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(Long min,Long max);
	
	
}
