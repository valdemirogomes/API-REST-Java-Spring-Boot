package com.ordem.deservico.domain.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.ordem.deservico.domain.model.Cliente;
import com.ordem.deservico.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public List<Cliente> listarTodos(){
		return  clienteRepository.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);		
	}
	public ResponseEntity<Cliente> buscar(Long id){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cliente.get());
			}
		}
	
	public ResponseEntity <Void> excluir (Long id) {
		if(clienteRepository.existsById(id)) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
			}else {
				return ResponseEntity.notFound().build();
			}
		}	
	
	public ResponseEntity<Cliente> atualizar(Cliente cliente, Long id){
		if(clienteRepository.existsById(id)) {
			cliente.setId(id);
			cliente =  clienteRepository.save(cliente);
			return ResponseEntity.ok(cliente);
		}else {
			return ResponseEntity.notFound().build();
			}
		}
	}
