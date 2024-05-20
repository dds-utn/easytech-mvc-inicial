package ar.utn.ba.dds.easytech.models.entities.dispositivos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class DispositivoConcreto {
    private Dispositivo dispositivo;
    private String nroDeSerie;
    private LocalDate fechaAlta;
    private boolean activo;
}
