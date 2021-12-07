package com.example.av2final.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.av2final.domain.entity.MicroEmpresa;
import com.example.av2final.domain.repository.MicroEmpresaRepository;
import com.example.av2final.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MicroEmpresaService {
	private final MicroEmpresaRepository microEmpresaRepository;
	
	public MicroEmpresa update(String id, MicroEmpresa m) {
		var existing = get(id);

		existing.setNome(m.getNome());
		existing.setCnpj(m.getCnpj());
		existing.setEmail(m.getEmail());
		existing.setDatahora(m.getDatahora());
		existing.setStatus(m.getStatus());
		
		return existing; 
	}
	
	public MicroEmpresa get(String id) {
		var microEmpresa = microEmpresaRepository.findById(id);
		
		if (microEmpresa.isEmpty()) {
			throw new NotFoundException("MicroEmpresa with ID " + id + " not found");
		}
		
		return microEmpresa.get();
	}
	
	public List<MicroEmpresa> getAll() {
		return microEmpresaRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		microEmpresaRepository.deleteById(id);
	}
}