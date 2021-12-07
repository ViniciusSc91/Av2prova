package com.example.av2final.api;

import java.time.LocalDateTime;

import com.example.av2final.domain.entity.MicroEmpresa;
import com.example.av2final.domain.enums.MicroEmpresaStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MicroEmpresaDto {

	private String id;
	private String nome;
	private String cnpj;
	private String email;
	private LocalDateTime datahora;
	private MicroEmpresaStatus status;
	
	public MicroEmpresaDto(MicroEmpresa m) {
		this.setId(m.getId());
		this.setNome(m.getNome());
		this.setCnpj(m.getCnpj());
		this.setEmail(m.getEmail());
		this.setDatahora(m.getDatahora());
		this.setStatus(m.getStatus());
	}
}
