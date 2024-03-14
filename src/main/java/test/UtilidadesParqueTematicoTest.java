package test;

import modelos.*;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesParqueTematico;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesParqueTematicoTest {

    @Test
    public void getParquesConAtraccionesInfantiles_returnsParquesWithInfantilAtracciones() {
        // Given
        ParqueTematico parque1 = new ParqueTematico();
        parque1.setAtracciones(Arrays.asList(new Atraccion(TipoAtraccion.INFANTIL)));
        ParqueTematico parque2 = new ParqueTematico();
        parque2.setAtracciones(Arrays.asList(new Atraccion(TipoAtraccion.ADULTOS)));
        List<ParqueTematico> parques = Arrays.asList(parque1, parque2);

        // When
        List<ParqueTematico> result = UtilidadesParqueTematico.getParquesConAtraccionesInfantiles(parques);

        // Then
        assertEquals(1, result.size());
        assertEquals(parque1, result.get(0));
    }


    @Test
    public void getParquesPorUbicacionAdultos_returnsParquesInGivenPostalCodeWithAdultAtracciones() {
        // Given
        ParqueTematico parque1 = new ParqueTematico();
        Ubicacion ubicacion1 = new Ubicacion();
        ubicacion1.setCodigoPostal(12345);
        parque1.setUbicacion(ubicacion1);
        parque1.setAtracciones(Arrays.asList(new Atraccion(TipoAtraccion.ADULTOS)));

        ParqueTematico parque2 = new ParqueTematico();
        Ubicacion ubicacion2 = new Ubicacion();
        ubicacion2.setCodigoPostal(67890);
        parque2.setUbicacion(ubicacion2);
        parque2.setAtracciones(Arrays.asList(new Atraccion(TipoAtraccion.ADULTOS)));

        List<ParqueTematico> parques = Arrays.asList(parque1, parque2);

        // When
        List<ParqueTematico> result = UtilidadesParqueTematico.getParquesPorUbicacionAdultos(parques, 12345);

        // Then
        assertEquals(1, result.size());
        assertEquals(parque1, result.get(0));
    }

    @Test
    public void getPosibles_returnsParquesWithinBudget() {
        // Given
        ParqueTematico parque1 = new ParqueTematico();
        parque1.setTarifas(Arrays.asList(new Tarifa(TipoPersona.ADULTO, 10.0), new Tarifa(TipoPersona.MENOR_12, 20.0), new Tarifa(TipoPersona.MENOR_18, 30.0)));
        ParqueTematico parque2 = new ParqueTematico();
        parque2.setTarifas(Arrays.asList(new Tarifa(TipoPersona.ADULTO, 40.0), new Tarifa(TipoPersona.MENOR_12, 50.0), new Tarifa(TipoPersona.MENOR_18, 60.0)));
        List<ParqueTematico> parques = Arrays.asList(parque1, parque2);
        Map<TipoPersona, Integer> mapa = new HashMap<>();
        mapa.put(TipoPersona.ADULTO, 1);
        mapa.put(TipoPersona.MENOR_12, 1);
        mapa.put(TipoPersona.MENOR_18, 1);

        // When
        List<ParqueTematico> result = UtilidadesParqueTematico.getPosibles(parques, mapa, 100.0);

        // Then
        assertEquals(1, result.size());
        assertEquals(parque1, result.get(0));
    }

    @Test
    public void calcularPrecioParquePorTipoPersona_returnsCorrectPrice() {
        // Given
        ParqueTematico parque = new ParqueTematico();
        parque.setTarifas(Arrays.asList(new Tarifa(TipoPersona.ADULTO, 10.0), new Tarifa(TipoPersona.MENOR_12, 20.0), new Tarifa(TipoPersona.MENOR_18, 30.0)));

        // When
        Double result = UtilidadesParqueTematico.calcularPrecioParquePorTipoPersona(TipoPersona.ADULTO, 2, parque);

        // Then
        assertEquals(20.0, result);
    }
}