package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.EmailModel;
import com.app.util.EmailUtil;

@Controller
public class AppController {
	@Autowired
	private EmailUtil util;

	@RequestMapping("/showPage")	
	public String getsendPage(ModelMap map) {
		map.addAttribute("emailModel",new EmailModel());
		return "email-send";
	} 
	
	@RequestMapping(value="/send",method = RequestMethod.POST)
	public String sendMail(@Valid @ModelAttribute EmailModel emailModel,@RequestParam MultipartFile fileOb,BindingResult result,
			Model map
			){
		
			if(result.hasErrors()) {
				System.out.println("If error is executed");
				return  "email-send";
			}
			else {
				System.out.println("else is executed");
			boolean flag=util.send(emailModel, fileOb);
			if(flag)
				map.addAttribute("msg", "your Mail Sent Sucessfully!!");
			else {
				map.addAttribute("msg", "mail not sent please try again");
			}
		return "email-confirm";
			}
	}	
}
