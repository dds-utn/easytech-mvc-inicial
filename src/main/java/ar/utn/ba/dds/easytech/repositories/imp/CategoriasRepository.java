package ar.utn.ba.dds.easytech.repositories.imp;

import ar.utn.ba.dds.easytech.models.entities.dispositivos.CategoriaDispositivo;
import ar.utn.ba.dds.easytech.repositories.ICategoriasRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *  Este repositorio trabaja con persistencia en memoria
 */
public class CategoriasRepository implements ICategoriasRepository {
    private List<CategoriaDispositivo> categorias;

    public CategoriasRepository() {
        this.categorias = new ArrayList<>();
    }

    @Override
    public Optional<CategoriaDispositivo> buscar(Long id) {
        return this.categorias
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<CategoriaDispositivo> buscarTodos() {
        return this.categorias;
    }

    @Override
    public void guardar(CategoriaDispositivo categoria) {
        categoria.setId((long) (this.categorias.size() + 1));
        this.categorias.add(categoria);
    }

    @Override
    public void actualizar(CategoriaDispositivo categoria) {
        //DO NOTHING
    }

    @Override
    public void eliminar(CategoriaDispositivo categoria) {
        this.categorias.remove(categoria);
    }
}
