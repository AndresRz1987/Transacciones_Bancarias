package com.banca.banca.Models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable {

    @Id
    @Column(name="id_transaccion")
    private String id_transaccion;

    @Column(name="fecha_transaccion")
    private Date fecha_transaccion;

    @Column(name="valor_transaccion")
    private double valor_transaccion;

    @Column(name="tipo_transaccion")
    private String tipo_transaccion;
    
/*
    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta cuenta;
    @Override
    public String toString() {
        return "Transacción [idTransaccion=" + id_transaccion + ", Fecha Transacción=" + fecha_transaccion + ", Valor Transacción="
                + valor_transaccion + ", Tipo Transacción=" + tipo_transaccion + "]";
    }
*/  

}