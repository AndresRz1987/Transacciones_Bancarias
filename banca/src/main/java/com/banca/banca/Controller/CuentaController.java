package com.banca.banca.Controller;

import com.banca.banca.Models.Cuenta;
import com.banca.banca.Dao.CuentaDao;
import com.banca.banca.Service.CuentaService;

import java.util.List;

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
@RequestMapping("/cuenta")
public class CuentaController {

    @Autowired
    private CuentaDao cuentaDao;

    @Autowired
    private CuentaService cuentaService;

    @PostMapping(value = "/")
    public ResponseEntity<Cuenta> agregar(@RequestBody Cuenta cuenta) {
        Cuenta obj = cuentaService.save(cuentaDao);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Cuenta> eliminar(@PathVariable String id) {
        Cuenta obj = cuentaService.findById(id);
        if (obj != null)
            cuentaService.delete(id);
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Cuenta> editar(@RequestBody Cuenta cuenta) {
        Cuenta obj = cuentaService.findById(cuenta.getId_cuenta());
        if (obj != null) {

            obj.setSaldo_cuenta(cuenta.getSaldo_cuenta());

            cuentaService.save((CuentaDao) obj);
        } else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Cuenta> consultarTodo() {
        return cuentaService.findByAll();
    }

    @GetMapping("/list/{id}")
    public Cuenta consultaPorId(@PathVariable String id) {
        return cuentaService.findById(id);
    }
}