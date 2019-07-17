package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest produtos")
@CrossOrigin(origins = "*")
public class ProdutosResouces {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Find All produtos")
	public List<Produtos> findAll() {
		return produtoRepository.findAll();
	}
	
	@ApiOperation(value = "Find by id produtos")
	@GetMapping("/produtos/{id}")
	public Optional<Produtos> findById(@PathVariable(value = "id")Long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value = "Save post produtos")
	public Produtos create(@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza produtos")
	public Produtos update(@RequestBody Produtos produtos) {
		return produtoRepository.save(produtos);
	}
	
	@DeleteMapping("/produtos")
	@ApiOperation(value = "Exclui produtos")
	public void delete(@RequestBody Produtos produtos) {
		produtoRepository.delete(produtos);
	}

}
