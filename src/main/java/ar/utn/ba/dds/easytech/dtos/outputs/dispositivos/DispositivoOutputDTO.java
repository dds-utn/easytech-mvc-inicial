package ar.utn.ba.dds.easytech.dtos.outputs.dispositivos;

import lombok.Data;

@Data
public class DispositivoOutputDTO {
    private Long id;
    private String marca;
    private String modelo;
    private Long categoriaId;
    private Double pesoEnKgs;
    private Double precioAlquiler;
}
