package ar.utn.ba.dds.easytech.models.entities.clientes;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private String nombre;
    private String apellido;
    private String cuit;
    private CondicionIVA condicionIVA;
    private List<Contacto> contactos;

    public Cliente() {
        this.contactos = new ArrayList<>();
    }
}
