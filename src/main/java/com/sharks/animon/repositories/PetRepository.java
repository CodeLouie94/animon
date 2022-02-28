package com.sharks.animon.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sharks.animon.models.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	List<Pet> findAll();
}
