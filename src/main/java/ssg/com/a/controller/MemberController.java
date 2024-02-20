package ssg.com.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ssg.com.a.dto.MemberDto;
import ssg.com.a.service.MemberService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("idcheck")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck " + new Date());

		
		boolean isS = service.idcheck(id);

		if(isS) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping("login")
	public MemberDto login(MemberDto mem) {
		System.out.println("MemberController login " + new Date());
		
		return service.login(mem);
	}	
	
	@PostMapping("addMember")
	public String addMember(MemberDto mem) {
		System.out.println("MemberController addMember " + new Date());
		
		boolean isS = service.addMember(mem);

		String regiMsg = "ADD_YES";
		if(!isS) {
			regiMsg = "ADD_NO";
		}
		
		return regiMsg;
	}
	
	
}








