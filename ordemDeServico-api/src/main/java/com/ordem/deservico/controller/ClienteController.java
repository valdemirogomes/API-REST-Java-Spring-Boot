package com.ordem.deservico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ordem.deservico.domain.model.Cliente;
import com.ordem.deservico.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
		
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteService.listarTodos();
		}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		return clienteService.buscar(id);
		}
		
	@PostMapping
		public Cliente cadastrar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Long id){
		return clienteService.atualizar(cliente, id);
	}

	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id){
			clienteService.excluir(id);
		}
	}
