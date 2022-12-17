package com.banca.banca.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banca.banca.Models.Transaccion;

@Repository
public interface TransaccionDao extends CrudRepository<Transaccion, String> {
    
}