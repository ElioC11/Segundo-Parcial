package com.example.practicaparcial.services;

import com.example.practicaparcial.models.Orden;
import com.example.practicaparcial.repositories.OrdenRepository;
import com.example.practicaparcial.request.RequestDTO;
import com.example.practicaparcial.response.OrdenResponse;
import com.example.practicaparcial.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;
    public ArrayList<Orden> obtenerOrden(){ return (ArrayList<Orden>) ordenRepository.findAll();}
    public ResponseEntity<ResponseDTO> guardarOrden(RequestDTO requestDTO){
        Orden orden=ordenRepository.save(requestDTO.getRequest().getOrden());
        OrdenResponse ordenResponse = new OrdenResponse();
        ordenResponse.setNombreCliente(orden.getNombreCliente());
        ordenResponse.setTotal(orden.getTotal());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Orden creada");
        responseDTO.setOrden(ordenResponse);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
