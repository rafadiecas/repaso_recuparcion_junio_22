package test;
import modelos.Atraccion;
import modelos.ParqueTematico;
import modelos.TipoAtraccion;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesAtraccion;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UtilidadesAtraccionTest {

    @Test
    public void getAtraccionesConTipo_returnsAtraccionesWithGivenTypes() {
        // Given
        Atraccion atraccion1 = new Atraccion(TipoAtraccion.INFANTIL);
        Atraccion atraccion2 = new Atraccion(TipoAtraccion.ADULTOS);
        List<Atraccion> atracciones = Arrays.asList(atraccion1, atraccion2);
        List<TipoAtraccion> tipos = Arrays.asList(TipoAtraccion.INFANTIL);

        // When
        List<Atraccion> result = UtilidadesAtraccion.getAtraccionesConTipo(atracciones, tipos);

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(atraccion1));
    }

    @Test
    public void getAtraccionesComunes_returnsCommonAtraccionesBetweenTwoParques() {
        // Given
        Atraccion atraccion1 = new Atraccion(TipoAtraccion.INFANTIL);
        Atraccion atraccion2 = new Atraccion(TipoAtraccion.ADULTOS);
        ParqueTematico parque1 = new ParqueTematico();
        parque1.setAtracciones(Arrays.asList(atraccion1, atraccion2));
        ParqueTematico parque2 = new ParqueTematico();
        parque2.setAtracciones(Arrays.asList(atraccion1));

        // When
        List<Atraccion> result = UtilidadesAtraccion.getAtraccionesComunes(parque1, parque2);

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(atraccion1));
    }

    @Test
    public void getAtraccionesPorTipo_returnsAtraccionesGroupedByTipo() {
        // Given
        Atraccion atraccion1 = new Atraccion(TipoAtraccion.INFANTIL);
        Atraccion atraccion2 = new Atraccion(TipoAtraccion.ADULTOS);
        List<Atraccion> atracciones = Arrays.asList(atraccion1, atraccion2);

        // When
        Map<TipoAtraccion, List<Atraccion>> result = UtilidadesAtraccion.getAtraccionesPorTipo(atracciones);

        // Then
        assertEquals(2, result.size());
        assertTrue(result.get(TipoAtraccion.INFANTIL).contains(atraccion1));
        assertTrue(result.get(TipoAtraccion.ADULTOS).contains(atraccion2));
    }

    @Test
    public void getAtraccionesExclusivasParque1_returnsAtraccionesExclusiveToParque1() {
        // Given
        Atraccion atraccion1 = new Atraccion(TipoAtraccion.INFANTIL);
        Atraccion atraccion2 = new Atraccion(TipoAtraccion.ADULTOS);
        ParqueTematico parque1 = new ParqueTematico();
        parque1.setAtracciones(Arrays.asList(atraccion1, atraccion2));
        ParqueTematico parque2 = new ParqueTematico();
        parque2.setAtracciones(Arrays.asList(atraccion1));

        // When
        List<Atraccion> result = UtilidadesAtraccion.getAtraccionesExclusivasParque1(parque1, parque2);

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(atraccion2));
    }

    @Test
    public void getAtraccionesConRestricciones_returnsAtraccionesWithHeightRestrictionsAndNotInfantil() {
        // Given
        Atraccion atraccion1 = new Atraccion(TipoAtraccion.INFANTIL, 1.3);
        Atraccion atraccion2 = new Atraccion(TipoAtraccion.ADULTOS, 1.5);
        List<Atraccion> atracciones = Arrays.asList(atraccion1, atraccion2);

        // When
        List<Atraccion> result = UtilidadesAtraccion.getAtraccionesConRestricciones(atracciones);

        // Then
        assertEquals(1, result.size());
        assertTrue(result.contains(atraccion2));
    }
}