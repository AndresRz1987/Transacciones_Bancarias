package com.banca.banca.Service;
import com.banca.banca.Models.Administrador;
import com.banca.banca.Dao.AdministradorDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorDao administradorDao;

    @Transactional(readOnly=false)
    public Administrador save(AdministradorDao obj) {
        return administradorDao.save(obj);
    }

    @Transactional(readOnly=false)
    public void delete(String id) {
        administradorDao.deleteById(id);
    }

    @Transactional(readOnly=true)
    public Administrador findById(String id) {
        return administradorDao.findById(id).orElse(null);
    }

    @Transactional(readOnly=true)
    public List<Administrador> findAll() {
        return (List<Administrador>) administradorDao.findAll();
    }

}