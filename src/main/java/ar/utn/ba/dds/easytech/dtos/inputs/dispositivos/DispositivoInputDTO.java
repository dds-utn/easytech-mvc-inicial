package ar.utn.ba.dds.easytech.dtos.inputs.dispositivos;

import lombok.Data;

@Data
public class DispositivoInputDTO {
    private String marca;
    private String modelo;
    private Long categoriaId;
    private Double pesoEnKgs;
    private Double precioAlquiler;
}
