package com.sharks.animon.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sharks.animon.models.LoginUser;
import com.sharks.animon.models.User;
import com.sharks.animon.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId != null) {
			return "redirect:/home";
		} else {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

	}

}
