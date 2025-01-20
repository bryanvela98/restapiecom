package com.example.futbolcanchas.controller;

import com.example.futbolcanchas.dto.CanchaRequest;
import com.example.futbolcanchas.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comprobante")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<String> procesarSolicitud(@RequestBody CanchaRequest request) {
        String resultado = comprobanteService.procesarSolicitud(request);
        return ResponseEntity.ok(resultado);
    }
}
