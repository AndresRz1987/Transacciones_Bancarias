package com.banca.banca.Dao;
import com.banca.banca.Models.Administrador;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorDao extends CrudRepository< Administrador, String>  {

    Administrador save(AdministradorDao obj);
    

};