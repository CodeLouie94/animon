package com.sharks.animon.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sharks.animon.models.LoginUser;
import com.sharks.animon.models.User;
import com.sharks.animon.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userServ;
	
	
	// Login Landing Page
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
	
	// Register New User
	@PostMapping ("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult result,
							Model model,
							HttpSession sesh) {
		userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {
			sesh.setAttribute("user_id", newUser.getId());
			return "redirect:/new/pet";
		}
		
	}

	// LOGIN##############################################################
		@PostMapping("/login")
		public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
				HttpSession session) {
			User user = userServ.login(newLogin, result);

			if (result.hasErrors()) {
				model.addAttribute("newUser", new User());
				return "index.jsp";
			} else {
				session.setAttribute("user_id", user.getId());
				if(user.getPets().size() == 0) {
					return "redirect:/new/pet";
				}else {
					return "redirect:/home";
				}
				
			}

		}

		
		
		
		
		
		
		
		
		
		

}
