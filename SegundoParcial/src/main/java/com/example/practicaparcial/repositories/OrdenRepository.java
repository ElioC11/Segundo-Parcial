package com.example.practicaparcial.repositories;

import com.example.practicaparcial.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrdenRepository extends JpaRepository<Orden, Integer> {
}
