package modelos;

import java.time.LocalDate;
import java.util.Map;

public class InformeDiarioParque {
    private Integer id;
    private LocalDate fecha;
    private Map<TipoPersona, Integer> numeroPersonasPorTipo;
    private Double totalDineroIngresado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Map<TipoPersona, Integer> getNumeroPersonasPorTipo() {
        return numeroPersonasPorTipo;
    }

    public void setNumeroPersonasPorTipo(Map<TipoPersona, Integer> numeroPersonasPorTipo) {
        this.numeroPersonasPorTipo = numeroPersonasPorTipo;
    }

    public Double getTotalDineroIngresado() {
        return totalDineroIngresado;
    }

    public void setTotalDineroIngresado(Double totalDineroIngresado) {
        this.totalDineroIngresado = totalDineroIngresado;
    }

    public InformeDiarioParque(Integer id, LocalDate fecha, Map<TipoPersona, Integer> numeroPersonasPorTipo, Double totalDineroIngresado) {
        this.id = id;
        this.fecha = fecha;
        this.numeroPersonasPorTipo = numeroPersonasPorTipo;
        this.totalDineroIngresado = totalDineroIngresado;
    }

    public InformeDiarioParque() {
    }
}
