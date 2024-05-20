package ar.utn.ba.dds.easytech.models.entities.usuarios;

import lombok.Data;

@Data
public class Usuario {
    private String nombreDeUsuario;
    private String contrasenia;
    private Rol rol;
}
