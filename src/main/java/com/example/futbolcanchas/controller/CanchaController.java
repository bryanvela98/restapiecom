package com.example.futbolcanchas.controller;

import com.example.futbolcanchas.dto.CanchaDTO;
import com.example.futbolcanchas.service.CanchaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/canchas")
public class CanchaController {

    private final CanchaService service;

    public CanchaController(CanchaService service) {
        this.service = service;
    }

    @GetMapping("/{distrito}")
    public List<CanchaDTO> getCanchasByDistrito(@PathVariable String distrito) {
        return service.getCanchasByDistrito(distrito);
    }

    @PostMapping
    public CanchaDTO saveCancha(@RequestBody CanchaDTO canchaDTO) {
        return service.saveCancha(canchaDTO);
    }
}
