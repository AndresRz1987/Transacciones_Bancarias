package com.banca.banca.Dao;
import com.banca.banca.Models.Cuenta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaDao  extends CrudRepository<Cuenta, String> {
    
}
