package com.Darkinho11.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Darkinho11.Farmacia.Model.Categoria;
import com.Darkinho11.Farmacia.Repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaRepository catrepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(catrepository.findAll());
	}
	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return catrepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(catrepository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria nome){
		return ResponseEntity.status(HttpStatus.CREATED)
		.body(catrepository.save(nome));
	}
	
	@PutMapping
	public ResponseEntity <Categoria> put(@RequestBody Categoria nome){
		return ResponseEntity.ok(catrepository.save(nome));
	}
	
	@DeleteMapping("/{id_categoria}")
	public void delete(@PathVariable long id_categoria) {
		catrepository.deleteById(id_categoria);
	}
	
	
}
