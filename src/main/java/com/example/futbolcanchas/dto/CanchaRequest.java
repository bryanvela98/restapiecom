package com.example.futbolcanchas.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class CanchaRequest {
    private ClienteRequest cliente;
    private List<LineaRequest> lineas;

    @Data
    public static class ClienteRequest {
        private Long clienteid;
    }

    @Data
    public static class LineaRequest {
        private String distrito;
        private CanchaRequestBody cancha;

        @Data
        public static class CanchaRequestBody {
            private Long canchaId;
            private LocalTime horaSolicitada;
        }
    }
}
