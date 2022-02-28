package com.sharks.animon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharks.animon.models.Pet;
import com.sharks.animon.repositories.PetRepository;

@Service
public class PetService {
	@Autowired
	private PetRepository petRepo;
	
	public List<Pet> allPets() {
		return petRepo.findAll();
	}
	
	public Pet createPet(Pet p) {
		return petRepo.save(p);
	}
	
	
	public Pet findPet(Long id) {
		Optional<Pet> optionalPet = petRepo.findById(id);
		if(optionalPet.isPresent()) {
			return optionalPet.get();
		}else {
			return null;
		}
	}
	
	public Pet updatePet(Pet p) {
		return petRepo.save(p);
	}
	
	public void deletePet(Long id) {
		petRepo.deleteById(id);
	}
	
	
}
