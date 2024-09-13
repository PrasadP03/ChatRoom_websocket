package com.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/chatroom")
public class ChatController {
	
	@GetMapping("/username")
	public String displayUsernameHtml() {
		return "username";
	}
	
	@GetMapping("/usernamecheck")
	public String userNameCheck(@RequestParam("username")String user,Model model) {
		model.addAttribute("username",user);
		return "chatroom";
	}
	

}
