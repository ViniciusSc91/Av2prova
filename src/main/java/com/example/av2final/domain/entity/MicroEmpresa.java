package com.example.av2final.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.example.av2final.api.MicroEmpresaDto;
import com.example.av2final.domain.enums.MicroEmpresaStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor

public class MicroEmpresa {

	@Id
	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDateTime datahora;
	private MicroEmpresaStatus status;
	
	public MicroEmpresa(MicroEmpresaDto m) {
		this.id = getId();
		this.nome = getNome();
		this.cnpj = getCnpj();
		this.email = getEmail();
		this.datahora = getDatahora();
		this.status = getStatus();
	}
}
