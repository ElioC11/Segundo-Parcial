package com.example.practicaparcial.controllers;

import com.example.practicaparcial.models.Orden;
import com.example.practicaparcial.repositories.OrdenRepository;
import com.example.practicaparcial.request.RequestDTO;
import com.example.practicaparcial.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OrdenController {
    @Autowired
    private OrdenRepository ordenRepository;
    OrdenService ordenService;

    @GetMapping("/ordenes/{id}")
    public ResponseEntity<Orden> getOrden(@PathVariable("id") Integer id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        return ResponseEntity.ok(orden.get());
    }

    @GetMapping("/ordenes")
    public ArrayList<Orden> getAllOrdenes() {
        return ordenService.obtenerOrden();// se estaba llamando al repositorio y no al servicio
    }

    @PostMapping("/ordenes")
    public ResponseEntity<String> createOrden(@RequestBody RequestDTO requestDTO) { //en vez de llamar al request se estaba llamando al modelo orden
        ordenService.guardarOrden(requestDTO);// se estaba llamando al repositorio y no al servicio
        return ResponseEntity.status(HttpStatus.CREATED).body("Orden creada correctamente");
    }

    @PutMapping("/ordenes/{id}")
    public ResponseEntity<String> updateOrden(@PathVariable Long id, @RequestBody Orden orden) {
        Orden orden1 = ordenRepository.findById(Math.toIntExact(id)).orElse(null);
        if (orden1 == null) {
            return ResponseEntity.notFound().build();
        }
        orden1.setNombreCliente(orden.getNombreCliente());
        orden1.setTotal(orden.getTotal());
        Orden orden2 = ordenService.guardarOrden(orden1);
        return ResponseEntity.ok("Orden actualizada correctamente");
    }

    @DeleteMapping("/ordenes/{id}")
    public ResponseEntity<String> deleteOrden(@PathVariable Integer id) {//el tipo de id debe ser integer
        ordenRepository.deleteById(id);
        return ResponseEntity.ok("Orden eliminada correctamente");
    }
}
