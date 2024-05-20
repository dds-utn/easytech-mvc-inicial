package ar.utn.ba.dds.easytech.repositories;

import ar.utn.ba.dds.easytech.models.entities.usuarios.Permiso;

import java.util.Optional;

public interface IPermisosRepository {
    Optional<Permiso> buscar(Long id);
    Optional<Permiso> buscarPorNombre(String nombre);
}
