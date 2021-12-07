package com.example.av2final.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.av2final.api.MicroEmpresaDto;
import com.example.av2final.domain.entity.MicroEmpresa;
import com.example.av2final.service.MicroEmpresaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

public class MicroEmpresaController {

private final MicroEmpresaService microEmpresaService;
	
	@GetMapping("/microEmpresa/{id}")
	public MicroEmpresaDto getById(@PathVariable String id) {
		var microEmpresa = microEmpresaService.get(id);
		
		return new MicroEmpresaDto(microEmpresa);
	}
	
	
	@GetMapping("/microEmpresa")
	public List<MicroEmpresaDto> getAll() {
		var microEmpresas = microEmpresaService.getAll();
		
		var microEmpresaDtos = new ArrayList<MicroEmpresaDto>();
		
		for (var microEmpresa: microEmpresas) {
			microEmpresaDtos.add(new MicroEmpresaDto(microEmpresa));
		}
		
		return microEmpresaDtos;
	}
	
	@PutMapping("/microEmpresa/{id}")
	public MicroEmpresaDto create(@PathVariable String id, @RequestBody MicroEmpresaDto microEmpresaDto) {
		var microEmpresa = new MicroEmpresa(microEmpresaDto);
		
		microEmpresa = microEmpresaService.update(id, microEmpresa);
		
		return new MicroEmpresaDto(microEmpresa);
	}
	
	@DeleteMapping("/microEmpresa/{id}") 
	public ResponseEntity<Void> delete(@PathVariable String id) {
		microEmpresaService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
