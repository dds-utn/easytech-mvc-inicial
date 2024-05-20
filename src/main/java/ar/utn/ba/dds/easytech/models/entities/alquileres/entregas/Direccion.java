package ar.utn.ba.dds.easytech.models.entities.alquileres.entregas;

import lombok.Data;

@Data
public class Direccion {
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}
