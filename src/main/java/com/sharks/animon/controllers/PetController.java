package com.sharks.animon.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sharks.animon.models.Pet;
import com.sharks.animon.models.User;
import com.sharks.animon.services.PetService;
import com.sharks.animon.services.UserService;

@Controller
public class PetController {

	@Autowired
	private UserService userServ;
	@Autowired
	private PetService petServ;
	
	
	//create pet form ##############################################
	@GetMapping("/new/pet")
	public String newPet(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("newPet", new Pet());
			return "createpet.jsp";
		}
	}
	
	@PostMapping("/create/pet")
	public String processCreatePet(@Valid @ModelAttribute("newPet") Pet pet,
									BindingResult result, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (result.hasErrors()) {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			return "createpet.jsp";
		}else {
			petServ.createPet(pet);
			return "redirect:/home";
		}
	}
	
	
	//HOME PAGE ###########################################################
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			return "redirect:/";
		}else {
			User thisUser = userServ.findOne(userId);
			List<Pet> allPets = petServ.allPets();
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("allPets", allPets);
			System.out.println("FASDFGASIDHUFHAISDUFHAOISDUFHAIOSUD");
			return "home.jsp";
		}
	}
	

}
