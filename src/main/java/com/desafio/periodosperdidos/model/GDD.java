package com.desafio.periodosperdidos.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * It contains the dates in type LocalDate and is
 * the one sent in response to the request
 */
public class GDD {

    private Long id;
    private LocalDate fechaCreacion;
    private LocalDate fechaFin;
    private List<LocalDate> fechas;
    private List<LocalDate> fechasFaltantes;

    public GDD () {
        this.fechas = new ArrayList<>();
        this.fechasFaltantes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public List<LocalDate> getFechas() {
        return fechas;
    }

    public void setFechas(List<LocalDate> fechas) {
        this.fechas = fechas;
    }

    public List<LocalDate> getFechasFaltantes() {
        return fechasFaltantes;
    }

    public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
        this.fechasFaltantes = fechasFaltantes;
    }
    public void addFecha (LocalDate fecha) {
        this.fechas.add(fecha);
    }

    public void addFechaFaltante (LocalDate fecha) {
        if (this.fechasFaltantes == null)
            this.fechasFaltantes = new ArrayList<>();
        this.fechasFaltantes.add(fecha);
    }
}
