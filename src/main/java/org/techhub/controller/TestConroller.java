package org.techhub.controller;
//Download java setup(https://www.youtube.com/watch?v=xUmSm7YNhQQ)
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.entity.Register;
import org.techhub.service.RegisterService;

@RestController
public class TestConroller {
	@Autowired
	RegisterService regService;
	List <Register> list;
	//save record
	@PostMapping(value="/save")
	public String register(@RequestBody Register reg)
	{
		boolean b=regService.isRegister(reg);
		if(b)
		{
			return "record save success";
			
		}
		else
		{
			return "some problem";
		}
	}
	//search record by using its id
	@GetMapping(value="/searchById/{id}")
	public String searchbyid(@PathVariable("id") Integer id)
	{
		Register r=regService.getRegisterById(id);
				if(r!=null)
				{
					return "Record found"+r.toString();
				}
				else
				{
					return "recor not found";
				}
	}
	
//Delete by id
	@DeleteMapping(value="/deleteById/{id}")
    public String DeleteById(@PathVariable("id") Integer id)
    {
		String msg=regService.isDeleteById(id);
		return msg;
    }
//view All record
	@GetMapping(value="/view")
	public List<Register> getAllRecord()
	{
	List<Register> list=regService.getAllRecord();
		return list;
	}
	//Update record using static value
	//Update record
	@PutMapping(value="/updateById/{id}")
	public Register updateById(@PathVariable("id") Integer id)
	{
		Register r=regService.getRegisterById(id);
		if(r!=null) 
		{
			r.setName("namdev");
			r.setEmail("namdev@gmail.com");
			regService.isRegister(r);
			return r;
		}
		return null;
		
	}
	
	//Update using Dynamic  value(Client side)
	@PutMapping(value="DynamicUpdate/{id}/{name}/{email}")
	public Register updatebyid(@PathVariable("id") Integer id,@PathVariable("name") String name,@PathVariable("email") String email)
	{
		Register r=regService. getRegisterById(id);
		r.setName(name);
		r.setEmail(email);
		regService.isRegister(r);
		
		return r;
		
	}
	
//find record using Name
	@GetMapping(value="/searchByName/{n}")
	public Register findByName(@PathVariable("n") String name)
	{
		Register r=regService.searchByName(name);
		return r;
	}
//find record using Email
	@GetMapping(value="/searchByEmail/{e}")
	public Register findByEmail(@PathVariable("e") String email)
	{
		Register r=regService.searchByEmail(email);
		return r;
	}
//Find record by using name and Email	
	@GetMapping(value="/searchNameAndEmail/{n}/{e}")
	public Register findNameandEmail(@PathVariable("n") String name,@PathVariable("e") String email)
	{
		Register r=regService.searchNameAndEmail(name,email);
		return r;
	}
	//Login Validation
	@GetMapping(value="login/{n}/{e}")
	public String checkLogin(@PathVariable("n") String name,@PathVariable("e") String email)
	{
		
		System.out.println(name+"\t"+email);
		Register r=regService.searchNameAndEmail(name,email);
		if(r!=null)
		{
			return "Login Success";
		}
		else
		{
			return "Login fail";
		}
	}
	@GetMapping(value="/  /{c}")
	public Register findbycontact(@PathVariable("c") String contact)
	{
		Register r=regService.FindByContact(contact);
		return r;
		
	}
//using like operator fetch the particular name wise data
	/*@GetMapping(value="/like/{n}")
    public Register UsingLikeOperator(@PathVariable("n") String name)
    {
		Register r=regService.FindByNameUsingLikeOperator(name);
		return  r;
    }*/
//HQL query usin @Query annotatio you can perform hql query and custome query
	@GetMapping(value="/viewHQL")
	public  List<Register> getAllDataHQL()
	{
		return list=regService.getAllRecorUsingHQl();
		
		
	}
// Pass parameter to HQL Query
	@GetMapping(value="/viewHQL/{name}")
	public List<Register> getAllDataHQL(@PathVariable("name") String name)
	{
	 List<Register> list=regService.getAllDataHQL(name);
	 return list;
	}
	@PutMapping(value="/change/{name}/{email}")
	public String  ChangeName(@PathVariable("name") String name,@PathVariable("email") String email)
	{
		int value=regService.changeName(name,email);
		if(value>0)
		{
			return "Recprd updated";
		}
		else
		{
			return "some problem";
		}
	}
	@DeleteMapping(value="/delete/{name}")
	public String DeleteRecord(@PathVariable("name") String name) 
	{
		int value=regService.deleteRecord(name);
		if(value>0)
		{
			return "Record deleted";
		}
		else
		{
			return "Record Not deleted";
		}
	}
	@GetMapping("/Square/{no}")
	public String getSquare(@PathVariable("no") Integer no)
	{
		
		return "square is"+(no* no);
	}
}