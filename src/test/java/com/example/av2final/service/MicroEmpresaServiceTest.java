package com.example.av2final.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.av2final.domain.entity.MicroEmpresa;
import com.example.av2final.domain.repository.MicroEmpresaRepository;
import com.example.av2final.exception.NotFoundException;


@ExtendWith(MockitoExtension.class)
class MicroEmpresaServiceTest {

	@Mock
	private MicroEmpresaRepository microEmpresaRepository;
	private MicroEmpresaService unit;
	
	@BeforeEach
	public void setup() {
		unit = new MicroEmpresaService(microEmpresaRepository);
	}
	@Test
	void test_getById_withMicroEmpresa_shouldReturnObj() {
		// given:
		var microEmpresa = new MicroEmpresa();
		microEmpresa.setId("microEmpresa2");
		
		// mock definitions: 
		Mockito.when(microEmpresaRepository.findById("microEmpresa2"))
			.thenReturn(Optional.of(microEmpresa));
		
		// test:
		var result = unit.get("microEmpresa2");
		
		// assert:
		Assertions.assertEquals(result, microEmpresa);
		
		// verify: 
		Mockito.verify(microEmpresaRepository).findById("microEmpresa2");
	}
	
	@Test
	void test_getById_withNoMicroEmpresa_shouldThrowException() {
		// given:
		var id = "MicroEmpresa01";
		
		// mock definitions
		Mockito.when(microEmpresaRepository.findById(id))
		.thenReturn(Optional.empty());

		// test:
		try {
			unit.get(id);
			fail("Expected NotFoundException");
		} catch (NotFoundException ex) {
			// assert:
			Assertions.assertEquals(ex.getMessage(), "Revista with ID " + id + " not found");
		}
		
		// verify: 
		Mockito.verify(microEmpresaRepository).findById(id);		
	}

}
