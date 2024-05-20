package ar.utn.ba.dds.easytech.models.entities.alquileres.ordenes;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EstadoOrdenAlquiler {
    private LocalDateTime fechaHora;
    private PosibleEstadoOrdenAlquiler estadoReal;
}
