package ar.utn.ba.dds.easytech.models.repositories;

import ar.utn.ba.dds.easytech.models.entities.dispositivos.Dispositivo;

import java.util.List;
import java.util.Optional;

public interface IDispositivosRepository {
    Optional<Dispositivo> buscar(Long id);
    List<Dispositivo> buscarTodos();
    void guardar(Dispositivo dispositivo);
    void actualizar(Dispositivo dispositivo);
    void eliminar(Dispositivo dispositivo);
}
