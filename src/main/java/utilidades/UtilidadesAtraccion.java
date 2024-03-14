package utilidades;

import modelos.Atraccion;
import modelos.ParqueTematico;
import modelos.TipoAtraccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesAtraccion {


    /**
     * Ejercicio 1
     *
     * Devuelve todas las atracciones cuyo Tipo coincide con alguno de los tipos de la lista que se le pasa.
     *
     * @param atraccions
     * @param tipos
     * @return
     */
    public static List<Atraccion> getAtraccionesConTipo(List<Atraccion> atraccions , List<TipoAtraccion> tipos){

        return atraccions.stream().filter(a-> tipos.contains(a.getTipo())).collect(Collectors.toList());
    }

    /**
     * Ejercicio 1
     *
     * Devuelve todas las atracciones que tienen en comun dos parques tematicos
     *
     * @param parqueTematico1
     * @param parqueTematico2
     * @return
     */

    public static List<Atraccion> getAtraccionesComunes(ParqueTematico parqueTematico1, ParqueTematico parqueTematico2){
        return parqueTematico1.getAtracciones().stream().filter(a->parqueTematico2.getAtracciones().contains(a)).collect(Collectors.toList());
    }


    /**
     * Ejercicio 2
     *
     * Devuelve un mapa con las atracciones agrupadas por su Tipo
     *
     * @param atracciones
     * @return
     */
    public static Map<TipoAtraccion, List<Atraccion>> getAtraccionesPorTipo(List<Atraccion> atracciones){
        return atracciones.stream().collect(Collectors.groupingBy(Atraccion::getTipo));
    }


    /**
     * Ejercicio 3
     *
     * Que devuelve las atracciones que son exclusivas del
     * parqueTemático1
     *
     * @param parqueTematico1
     * @param parqueTematico2
     * @return
     */
    public static List<Atraccion> getAtraccionesExclusivasParque1(ParqueTematico parqueTematico1, ParqueTematico parqueTematico2){
        return parqueTematico1.getAtracciones().stream().filter(a->!parqueTematico2.getAtracciones().contains(a)).collect(Collectors.toList());
    }

    /**
     * Ejercicio 3
     *
     * Que devuelve todas las atracciones del parque cuya altura mínima
     * se encuentra entre 1.2 y 1.6 y no son del tipo INFANTIL.
     *
     * @param atracciones
     *
     * @return
     */
    public static List<Atraccion> getAtraccionesConRestricciones(List<Atraccion> atracciones){
        return atracciones.stream().filter(a->a.getAlturaMinima()>1.2 && a.getAlturaMinima()<1.6 && !a.getTipo().equals(TipoAtraccion.INFANTIL)).collect(Collectors.toList());
    }









}
