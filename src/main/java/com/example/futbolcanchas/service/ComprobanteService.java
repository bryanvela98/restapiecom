package com.example.futbolcanchas.service;

import com.example.futbolcanchas.dto.CanchaRequest;
import com.example.futbolcanchas.model.Cancha;
import com.example.futbolcanchas.model.Cliente;
import com.example.futbolcanchas.repository.CanchaRepository;
import com.example.futbolcanchas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@Service
public class ComprobanteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CanchaRepository canchaRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String procesarSolicitud(CanchaRequest request) {
        // Validar cliente existente
        Optional<Cliente> clienteOpt = clienteRepository.findById(request.getCliente().getClienteid());
        if (clienteOpt.isEmpty()) {
            throw new IllegalArgumentException("El cliente no existe.");
        }

        // Validar lineas
        for (CanchaRequest.LineaRequest linea : request.getLineas()) {
            Optional<Cancha> canchaOpt = canchaRepository.findById(linea.getCancha().getCanchaId());
            if (canchaOpt.isEmpty()) {
                throw new IllegalArgumentException("La cancha con ID " + linea.getCancha().getCanchaId() + " no existe.");
            }

            Cancha cancha = canchaOpt.get();

            // Validar horario
            LocalTime horaSolicitada = linea.getCancha().getHoraSolicitada();
            if (horaSolicitada.isBefore(LocalTime.of(8, 0)) || horaSolicitada.isAfter(LocalTime.of(22, 0))) {
                throw new IllegalArgumentException("La hora solicitada no es válida. Debe estar entre las 08:00 y las 22:00.");
            }

            // Cambiar estado de disponibilidad
            if (!cancha.isDisponible()) {
                throw new IllegalArgumentException("La cancha no está disponible.");
            }
            cancha.setDisponible(false);
            canchaRepository.save(cancha);
        }

        // Obtener fecha actual del servicio REST
        String fecha = obtenerFechaActual();

        return "Solicitud procesada con éxito en la fecha: " + fecha;
    }

    private String obtenerFechaActual() {
        String url = "http://worldclockapi.com/api/json/utc/now";
        var response = restTemplate.getForObject(url, Map.class);
        return response != null ? (String) response.get("currentDateTime") : "Fecha no disponible";
    }
}
