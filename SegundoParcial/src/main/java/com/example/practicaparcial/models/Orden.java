package com.example.practicaparcial.models;
import jakarta.persistence.*;

@Entity
@Table(name="orden")
public class Orden {
    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idord;
    @Column(name="nombreCliente")
    private String nombreCliente;
    @Column(name="total")
    private Double total;

    public Integer getIdord() {
        return idord;
    }

    public void setIdord(Integer idord) {
        this.idord = idord;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
