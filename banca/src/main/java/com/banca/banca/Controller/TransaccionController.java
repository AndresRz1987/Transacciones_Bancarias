package com.banca.banca.Controller;

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

import com.banca.banca.Models.Transaccion;
import com.banca.banca.Service.TransaccionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/transaccion")
public class TransaccionController {
    
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping(value = "/")
    public ResponseEntity<Transaccion> agregar(@RequestBody Transaccion transaccion){
        Transaccion obj = transaccionService.save(transaccion);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}") 
    public ResponseEntity<Transaccion> eliminar(@PathVariable String id){ 
        Transaccion obj = transaccionService.findById(id);
        if(obj!=null) 
            transaccionService.delete(id); 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @PutMapping(value="/") 
    public ResponseEntity<Transaccion> editar(@RequestBody Transaccion transaccion){ 
        Transaccion obj = transaccionService.findById(transaccion.getId_transaccion()); 
        if(obj!=null) {       
            transaccionService.save(transaccion);
        } 
        else 
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR); 
        return new ResponseEntity<>(obj, HttpStatus.OK); 
    }
    
    @GetMapping("/list")
    public List<Transaccion> consultarTodo(){
        return transaccionService.findByAll(); 
    }
    
    @GetMapping("/list/{id}") 
    public Transaccion consultaPorId(@PathVariable String id){ 
        return transaccionService.findById(id); 
    }
    
}