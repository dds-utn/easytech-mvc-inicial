package ar.utn.ba.dds.easytech.dtos.outputs.dispositivos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDispositivoOutputDTO {
    private Long id;
    private String nombre;
}
