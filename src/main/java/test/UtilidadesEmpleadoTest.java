package test;

import modelos.Empleado;
import modelos.TipoEmpleado;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesEmpleado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class UtilidadesEmpleadoTest {

    @Test
    public void getCordinadoresConRestricciones_returnsOnlyCoordinatorsWithSalaryAbove1000AndDniEndsWithVowel() {
        // Given
        Empleado emp1 = new Empleado(TipoEmpleado.COORDINADOR, 1500, "12345678A");
        Empleado emp2 = new Empleado(TipoEmpleado.COORDINADOR, 900, "12345678E");
        Empleado emp3 = new Empleado(TipoEmpleado.ASALARIADO, 1500, "12345678I");
        Empleado emp4 = new Empleado(TipoEmpleado.COORDINADOR, 1500, "12345678B");
        List<Empleado> empleados = Arrays.asList(emp1, emp2, emp3, emp4);

        // When
        List<Empleado> result = new UtilidadesEmpleado().getCordinadoresConRestricciones(empleados);

        // Then
        assertEquals(1, result.size());
        assertEquals(emp1, result.get(0));
    }

    @Test
    public void getCordinadoresConRestricciones_returnsEmptyListWhenNoCoordinatorsMeetCriteria() {
        // Given
        Empleado emp1 = new Empleado(TipoEmpleado.ASALARIADO, 1500, "12345678A");
        Empleado emp2 = new Empleado(TipoEmpleado.COORDINADOR, 900, "12345678E");
        Empleado emp3 = new Empleado(TipoEmpleado.COORDINADOR, 1500, "12345678B");
        List<Empleado> empleados = Arrays.asList(emp1, emp2, emp3);

        // When
        List<Empleado> result = new UtilidadesEmpleado().getCordinadoresConRestricciones(empleados);

        // Then
        assertEquals(0, result.size());
    }
}