package com.example.futbolcanchas.repository;

import com.example.futbolcanchas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
