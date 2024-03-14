package utilidades;

import modelos.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesParqueTematico {


    /**
     *
     * Ejercicio 3
     *
     * Devuelve todos los parques cuyas atracciones contienen alguna que sea para niños, es decir que su tipo
     * sea INFANTIL
     *
     * @param parqueTematicos
     * @return
     */
    public static List<ParqueTematico> getParquesConAtraccionesInfantiles(List<ParqueTematico> parqueTematicos){


        return  parqueTematicos.stream().filter(p-> p.getAtracciones().stream().anyMatch(a -> a.getTipo().equals(TipoAtraccion.INFANTIL))).collect(Collectors.toList());
    }





    /**
     *
     * Ejercicio 4
     *
     * Devuelve todos los parques cuya ubicación coincida con el código postal pasado  y en cuyas atracciones contengan
     * alguna para adultos
     *
     * @param parqueTematicos
     * @return
     */

    public static List<ParqueTematico> getParquesPorUbicacionAdultos(List<ParqueTematico> parqueTematicos, Integer codigoPostal){
        return parqueTematicos.stream().filter(p->p.getUbicacion().getCodigoPostal().equals(codigoPostal) && p.getAtracciones().stream().anyMatch(a->a.getTipo().equals(TipoAtraccion.ADULTOS))).collect(Collectors.toList());
    }

    /**
     *
     * Devuelvo los parques temáticos cuya Tarifas teniendo en cuenta los tipo de persona y el número de
     * personas pasado , no supera el presupuesto pasado
     *
     * @param parqueTematicos
     * @param mapa
     * @param presupuesto
     * @return
     */
    public static List<ParqueTematico> getPosibles(List<ParqueTematico> parqueTematicos, Map<TipoPersona, Integer> mapa, Double presupuesto){

        List<ParqueTematico> parques = new ArrayList<>();
        Double dinero = 0.0;

        for (ParqueTematico p:parqueTematicos){
            dinero = presupuesto;

            for (Tarifa t : p.getTarifas()){
                if (mapa.containsKey(t.getTipo())){
                    dinero -= t.getPrecio()*mapa.get(t.getTipo());
                }
            }

            if (dinero>=0.0){
                parques.add(p);
            }

        }

        return parques;
    }




    /**
     *
     * Ejercicio 6
     *
     * Devuelvo el precio total de las entradas para el parque temático pasado, teniendo en cuenta el tipo de persona
     *
     * @param parqueTematico
     * @param numeroPersonas
     * @param tipoPersona
     * @return
     */

    public static Double calcularPrecioParquePorTipoPersona(TipoPersona tipoPersona, Integer numeroPersonas, ParqueTematico parqueTematico){


        return parqueTematico.getTarifas().stream().filter(t->t.getTipo().equals(tipoPersona)).findFirst().get().getPrecio()*numeroPersonas;

    }


}
