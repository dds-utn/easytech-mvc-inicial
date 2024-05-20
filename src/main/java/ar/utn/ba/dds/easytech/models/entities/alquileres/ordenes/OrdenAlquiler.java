package ar.utn.ba.dds.easytech.models.entities.alquileres.ordenes;

import ar.utn.ba.dds.easytech.models.entities.alquileres.SolicitudAlquiler;
import ar.utn.ba.dds.easytech.models.entities.dispositivos.DispositivoConcreto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrdenAlquiler {
    private SolicitudAlquiler solicitud;
    private List<DispositivoConcreto> dispositivosConcretos;
    private List<EstadoOrdenAlquiler> estados;

    public OrdenAlquiler() {
        this.dispositivosConcretos = new ArrayList<>();
    }

    public EstadoOrdenAlquiler estadoActual() {
        return this.estados.get(this.estados.size() - 1 );
    }
}
