package ar.utn.ba.dds.easytech.models.entities.alquileres;

import ar.utn.ba.dds.easytech.models.entities.alquileres.entregas.Direccion;
import ar.utn.ba.dds.easytech.models.entities.alquileres.entregas.FormaDeEntrega;
import ar.utn.ba.dds.easytech.models.entities.clientes.Cliente;
import ar.utn.ba.dds.easytech.models.entities.exceptions.NoSePuedeEnviarException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SolicitudAlquiler {
    private Cliente cliente;
    private LocalDateTime fechaHoraAlta;
    private List<ItemAlquiler> items;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Direccion lugarDeUso;
    private FormaDeEntrega formaDeEntrega;
    private Direccion direccionDeEntrega;

    public void setDireccionDeEntrega(Direccion direccionDeEntrega) {
        if(!this.formaDeEntrega.equals(FormaDeEntrega.ENVIO))
            throw new NoSePuedeEnviarException(
                    "No se puede configurar dirección de entrega en modalidad distinta a ENVIO"
            );
        this.direccionDeEntrega = direccionDeEntrega;
    }
}
