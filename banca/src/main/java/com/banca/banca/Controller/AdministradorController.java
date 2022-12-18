package com.banca.banca.Controller;

import com.banca.banca.Models.Administrador;
//import com.banca.banca.Security.Hash;
import com.banca.banca.Dao.AdministradorDao;
import com.banca.banca.Service.AdministradorService;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    private AdministradorDao administradorDao;
    @Autowired
    private AdministradorService administradorService;

    @PostMapping(value = "/")
    public ResponseEntity<Administrador> agregar(@RequestBody Administrador administrador) {
        Administrador obj = administradorService.save(administradorDao);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Administrador> eliminar(@PathVariable String id) {
        Administrador obj = administradorService.findById(id);
        if (obj != null)
            administradorService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Administrador> editar(@RequestBody Administrador administrador) {
        Administrador obj = administradorService.findById(administrador.getId_administrador());
        if (obj != null) {
            obj.setNombre_administrador(administrador.getNombre_administrador());
            obj.setClave_administrador(administrador.getClave_administrador());
            administradorService.save((AdministradorDao) obj);
        } else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Administrador> consultarTodo() {
        return administradorService.findAll();
    }

    @GetMapping("/list/{id}")
    public Administrador consultaPorId(@PathVariable String id) {
        return administradorService.findById(id);
    }
}