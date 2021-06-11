package com.desafio.periodosperdidos.model;

import java.time.LocalDate;
import java.util.List;

/**
 * This POJO directly receives through Jackson the JSON object generated
 * by the external service
 */
public class ParseGDD {

    private Long id;
    private String fechaCreacion;
    private String fechaFin;
    private List<String> fechas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<String> getFechas() {
        return fechas;
    }

    public void setFechas(List<String> fechas) {
        this.fechas = fechas;
    }
}
