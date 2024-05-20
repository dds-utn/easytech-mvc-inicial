package ar.utn.ba.dds.easytech.models.entities.alquileres;

import ar.utn.ba.dds.easytech.models.entities.dispositivos.CategoriaDispositivo;
import lombok.Data;

@Data
public class ItemAlquiler {
    private CategoriaDispositivo categoriaDispositivo;
    private Integer cantidad;
}
