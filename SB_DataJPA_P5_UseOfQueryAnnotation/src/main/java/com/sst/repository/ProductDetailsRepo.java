package com.sst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sst.entity.ProductDetailsEntity;

@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetailsEntity, Long> {
/*
 * Entity Query Concept: Retrieve all column value for one or more records
 */

//	When you are retrieving all column information then it is optional to mention SELECT *.

//	Without condition
	@Query("from ProductDetailsEntity")
	public List<ProductDetailsEntity> getAllPrdDetails();
	
/*	With one parameter condition */
	
//	@Query("from ProductDetailsEntity where pName = :prdName") //Type-1
//	public ProductDetailsEntity getProductDetailsByProductName(String prdName);

	@Query("from ProductDetailsEntity where pName = ?1") //Type-2  Here ? is ordinal positional of 1 param(Always starts with 1 not 0) denote position of method parameter
	public ProductDetailsEntity getProductDetailsByProductName(String prdName); //(If change position of ? symbol then you will get java.lang.IllegalArgumentException: JDBC style parameters (?) are not supported for JPA queries)

/*	With two parameter condition */
	
//	@Query("from ProductDetailsEntity where pPrice>= ?1 and pPrice<= ?2") //Type-1 (pId must be similar with entity variable not @Column variable otherwise will get mapping exception)
//	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(Float startVal,Float endVal);
	
//	@Query("from ProductDetailsEntity where pPrice>=:startVal and pPrice<=:endVal") //Type-2 
//	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(Float startVal,Float endVal);
	
//	@Query("from ProductDetailsEntity where pPrice in(:startVal, :endVal)")//Type-3 (Here we are using IN operator so you need to give exact price values present in database)
//	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(Float startVal,Float endVal);
	
	@Query("from ProductDetailsEntity as a where a.pPrice>=:startVal and a.pPrice<=:endVal order by a.pName asc")//Type-4 as a/a also optional.
	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(Float startVal,Float endVal);

//	@Query("from ProductDetailsEntity where pPrice in(:startVal, :endVal)")//Type-5
//	public List<ProductDetailsEntity> getSelectedPrdDetailsByIds(@Param("startVal")Float parm1, @Param("endVal")Float param2); //When your entity variable and parameter variable is different we need @Param annotation for mapping
	
/*
 * Scalar Query Concept: Retrieve selected multiple column value for one or more records
 */	

	@Query("select pName, pId, pPrice from ProductDetailsEntity")//Type-3 (For Scalar query concept we must need SELECT keyword and it's return type is Object[] otherwise will get "Failed to convert from type [java.lang.Object[]] to type [@org.springframework.data.jpa.repository.Query com.sst.entity.ProductDetailsEntity] for value [{...}]" exception)
	public List<Object[]> getSelectedColumnOfRecords();
	
	
}
