package ar.utn.ba.dds.easytech.services;

import ar.utn.ba.dds.easytech.dtos.inputs.alquileres.CategoriaDispositivoInputDTO;
import ar.utn.ba.dds.easytech.dtos.outputs.alquileres.CategoriaDispositivoOutputDTO;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;

public interface ICategoriasService {
    CategoriaDispositivoOutputDTO crear(CategoriaDispositivoInputDTO categoriaDispositivoInputDTO, Usuario usuario);
    CategoriaDispositivoOutputDTO modificar(Long id, CategoriaDispositivoInputDTO categoriaDispositivoInputDTO, Usuario usuario);
    void eliminar(Long id, Usuario usuario);
}
