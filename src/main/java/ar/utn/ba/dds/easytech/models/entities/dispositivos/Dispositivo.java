package ar.utn.ba.dds.easytech.models.entities.dispositivos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dispositivo {
    private Long id;
    private String marca;
    private String modelo;
    private CategoriaDispositivo categoria;
    private Double pesoEnKgs;
    private Double precioAlquiler;
}
