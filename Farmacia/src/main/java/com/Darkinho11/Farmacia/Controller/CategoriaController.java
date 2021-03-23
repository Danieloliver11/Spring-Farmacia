package com.Darkinho11.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Darkinho11.Farmacia.Model.Categoria;
import com.Darkinho11.Farmacia.Repository.CategoriaRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository catrepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(catrepository.findAll());
	}
}
