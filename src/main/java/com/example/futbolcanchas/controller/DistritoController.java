package com.example.futbolcanchas.controller;

import com.example.futbolcanchas.dto.DistritoDTO;
import com.example.futbolcanchas.service.DistritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/distritos")
public class DistritoController {

    private final DistritoService service;

    public DistritoController(DistritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DistritoDTO> getAllDistritos() {
        return service.getAllDistritos();
    }

    @PostMapping
    public DistritoDTO saveDistrito(@RequestBody DistritoDTO distritoDTO) {
        return service.saveDistrito(distritoDTO);
    }

    @GetMapping("/{nombre}")
    public DistritoDTO getDistritoByNombre(@PathVariable String nombre) {
        return service.getDistritoByNombre(nombre);
    }
}
