package com.example.av2final.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.av2final.domain.entity.MicroEmpresa;

public interface MicroEmpresaRepository extends MongoRepository<MicroEmpresa, String> {

}
