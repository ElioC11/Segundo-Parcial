package com.example.practicaparcial.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdenResponse {
    @JsonProperty("idord")
    private Integer idord;
    @JsonProperty("nombreCliente")
    private String nombreCliente;
    @JsonProperty("total")
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
