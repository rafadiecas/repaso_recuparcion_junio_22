package modelos;

import java.util.Objects;

public class Entrada {

    private Integer id;

    private Tarifa tarifa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return Objects.equals(id, entrada.id) && Objects.equals(tarifa, entrada.tarifa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tarifa);
    }

    public Entrada(Integer id, Tarifa tarifa) {
        this.id = id;
        this.tarifa = tarifa;
    }

    public Entrada() {
    }
}
