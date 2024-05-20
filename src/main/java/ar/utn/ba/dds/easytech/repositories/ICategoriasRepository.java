package ar.utn.ba.dds.easytech.repositories;

import ar.utn.ba.dds.easytech.models.entities.dispositivos.CategoriaDispositivo;

import java.util.List;
import java.util.Optional;

public interface ICategoriasRepository {
    Optional<CategoriaDispositivo> buscar(Long id);
    List<CategoriaDispositivo> buscarTodos();
    void guardar(CategoriaDispositivo categoria);
    void actualizar(CategoriaDispositivo categoria);
    void eliminar(CategoriaDispositivo categoria);
}
