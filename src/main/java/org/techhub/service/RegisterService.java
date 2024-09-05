package org.techhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.techhub.entity.Register;
import org.techhub.repository.RegisterRepo;

@Service("regService")
public class RegisterService {
	@Autowired 
	RegisterRepo registerRepo;
	//List<Register> list;
	public boolean isRegister(Register register)
	{ 
	   Register r=registerRepo.save(register);//save method actually in crudRepository override in JPARepository 
	                                         //and jpa Repository ovreeide in RegisterRepo and save method save one object as a one row in table
	    if(r!=null)
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
		//return registerRepo.save(register)!=null?true:false;
	}

	 public Register getRegisterById(Integer id) {
		
		Optional<Register> o=registerRepo.findById(id);
		if(o.isPresent())
		{
			return o.get();
		}
		else
		{
			return null;
		}
		//return o.isPresent()?o.get():null;
	}

	public String  isDeleteById(Integer id) {
		Optional<Register> o=registerRepo.findById(id);
		if(o.isPresent())
		{
			registerRepo.deleteById(id);
			return "Record delete";
		}
		else
		{
			return "some proble";
			
		}
	}

	public List<Register> getAllRecord() {
	List<Register> list=registerRepo.findAll();
	return list;
	}

	public Register searchByName(String name) {
		Register r=registerRepo.findByName(name);
		return r;
	}

	public Register searchByEmail(String email) {
	Register r=registerRepo.findByEmail(email);	
	return r;
	}
    public Register FindByContact(String contact) {
		Register r=registerRepo.findByContact(contact);
		return r;
	}
	public Register searchNameAndEmail(String name, String email) {
		Register r=registerRepo.findByNameAndEmail(name,email);
		return r;
				
		
	}
/*
	public Register FindByNameUsingLikeOperator(String name) {
		Register r=registerRepo.FindByNameStartingWith(name);
		return r;
	}
*/

	public List<Register> getAllRecorUsingHQl() {
		
		return registerRepo.getDataUsingHQl();
	}

	public List<Register> getAllDataHQL(String name) {
		return registerRepo.getAllDataUsingHQL(name);
	}

	

	public int changeName(String name, String email) {
		int value=registerRepo.ChangeName(name,email);
		return value;
	}
	public int deleteRecord(String name)
	{	int value=registerRepo.deleteRecord(name);
		return value;
	}
	

	

	
}
