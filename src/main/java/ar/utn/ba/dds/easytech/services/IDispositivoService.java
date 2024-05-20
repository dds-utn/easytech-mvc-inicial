package ar.utn.ba.dds.easytech.services;

import ar.utn.ba.dds.easytech.dtos.inputs.dispositivos.DispositivoInputDTO;
import ar.utn.ba.dds.easytech.dtos.outputs.dispositivos.DispositivoOutputDTO;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;

public interface IDispositivoService {
    DispositivoOutputDTO crear(DispositivoInputDTO dispositivoInputDTO, Usuario usuario);
    DispositivoOutputDTO modificar(Long id, DispositivoInputDTO dispositivoInputDTO, Usuario usuario);
    void eliminar(Long id, Usuario usuario);
}
