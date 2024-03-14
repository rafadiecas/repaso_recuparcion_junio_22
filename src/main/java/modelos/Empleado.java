package modelos;

import java.util.Objects;

public class Empleado {

    private Double salario;
    private String dni;
    private TipoEmpleado tipoEmpleado;

    public Empleado(TipoEmpleado tipoEmpleado, int i, String s) {

    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(salario, empleado.salario) && Objects.equals(dni, empleado.dni) && tipoEmpleado == empleado.tipoEmpleado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salario, dni, tipoEmpleado);
    }

    public Empleado(Double salario, String dni, TipoEmpleado tipoEmpleado) {
        this.salario = salario;
        this.dni = dni;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado() {
    }
}
