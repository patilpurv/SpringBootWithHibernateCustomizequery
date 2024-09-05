package org.techhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.techhub.entity.Register;

import jakarta.transaction.Transactional;
@Repository("registerRepo")
public interface RegisterRepo extends JpaRepository<Register,Integer>{
    //find by name
	public Register findByName(String name);

	//find by email
	public Register findByEmail(String email);
	
	//find by contact
	public Register findByContact(String contact);
		
	

	//find by Name And Email
	public Register findByNameAndEmail(String name, String email);
	
    //find by name using like operator
	//public Register FindByNameStartingWith(String name);
	
	//hql query fetch all record
	@Query("select r from Register r")
	public List<Register> getDataUsingHQl();
	
	//Pass parameter to hql query 
	@Query("select r from Register r where r.name=:n")
	public List<Register> getAllDataUsingHQL(@Param("n") String name);
   
	//Update record in name using email
	@Modifying
	@Transactional
	@Query("update Register r set r.name=:name where r.email=:email")
	public int ChangeName(@Param("name") String name,@Param("email") String email);
	
	//delete record in table
	@Modifying
	@Transactional
	@Query("delete from Register r where r.name=:name")
	public int deleteRecord(@Param("name") String name);

	
}
/*

CrudRepository---save() object as row in database table
     |
    JPARepository
     |
    RegisterRepo  
*/