package com.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

	@ModelAttribute
	public void common(Model model) {
		
		model.addAttribute("title","Infoware");
		
	}
	
	@RequestMapping("/")
	public String dashboard() {
		
		return "dashboard";
		
	}
	
	@RequestMapping("/add")
	public String add() {
		
		return "add";
		
	}
	
	@RequestMapping("/list")
	public String list() {
		
		return "list";
		
	}
	
	@RequestMapping("/update")
	public String update() {
		
		return "update";
		
	}
	
	@RequestMapping("/delete")
	public String delete() {
		
		return "delete";
		
	}
	
}
