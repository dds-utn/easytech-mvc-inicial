package ar.utn.ba.dds.easytech.services.imp;

import ar.utn.ba.dds.easytech.dtos.inputs.dispositivos.CategoriaDispositivoInputDTO;
import ar.utn.ba.dds.easytech.dtos.outputs.dispositivos.CategoriaDispositivoOutputDTO;
import ar.utn.ba.dds.easytech.models.entities.dispositivos.CategoriaDispositivo;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;
import ar.utn.ba.dds.easytech.repositories.ICategoriasRepository;
import ar.utn.ba.dds.easytech.services.ICategoriasService;
import ar.utn.ba.dds.easytech.services.exceptions.CategoriaDispositivoNoEncontradaException;
import ar.utn.ba.dds.easytech.utils.permisos.VerificadorDePermisos;

import java.util.Optional;

public class CategoriasService implements ICategoriasService  {
    private ICategoriasRepository categoriasRepository;
    private VerificadorDePermisos verificadorDePermisos;

    public CategoriasService(
            ICategoriasRepository categoriasRepository,
            VerificadorDePermisos verificadorDePermisos
    ) {
        this.categoriasRepository = categoriasRepository;
        this.verificadorDePermisos = verificadorDePermisos;
    }

    @Override
    public CategoriaDispositivoOutputDTO crear(
            CategoriaDispositivoInputDTO categoriaDispositivoInputDTO,
            Usuario usuario
    ) {
        //Verificamos si el usuario que está ejecutando el Caso de Uso tiene los permisos necesarios
        verificadorDePermisos.verificarSiUsuarioPuede("CREAR_CATEGORIAS_DISPOSITIVOS", usuario);

        //Creamos y configuramos la nueva categoría
        CategoriaDispositivo nuevaCategoria = new CategoriaDispositivo();
        nuevaCategoria.setNombre(categoriaDispositivoInputDTO.getNombre());

        //Guardamos la nueva categoría
        this.categoriasRepository.guardar(nuevaCategoria);

        //Generamos y configuramos el DTO de salida
        CategoriaDispositivoOutputDTO output = new CategoriaDispositivoOutputDTO();
        output.setNombre(nuevaCategoria.getNombre());
        output.setId(nuevaCategoria.getId());

        return output;
    }

    @Override
    public CategoriaDispositivoOutputDTO modificar(Long id, CategoriaDispositivoInputDTO categoriaDispositivoInputDTO, Usuario usuario) {
        //Verificamos si el usuario que está ejecutando el Caso de Uso tiene los permisos necesarios
        verificadorDePermisos.verificarSiUsuarioPuede("MODIFICAR_CATEGORIAS_DISPOSITIVOS", usuario);

        //Buscamos la instancia a modificar en el repositorio según el ID entrante
        Optional<CategoriaDispositivo> posibleCategoria = this.categoriasRepository.buscar(id);

        //Si no existe una categoría asociada con ese id lanzamos exception
        if(posibleCategoria.isEmpty()) {
            throw new CategoriaDispositivoNoEncontradaException();
        }

        CategoriaDispositivo categoriaAModificar = posibleCategoria.get();

        //Modificamos la categoría en base a los datos de entrada
        categoriaAModificar.setNombre(categoriaDispositivoInputDTO.getNombre());

        //Impactamos los cambios
        this.categoriasRepository.actualizar(categoriaAModificar);

        //Generamos y configuramos el DTO de salida
        CategoriaDispositivoOutputDTO output = new CategoriaDispositivoOutputDTO();
        output.setNombre(categoriaAModificar.getNombre());
        output.setId(categoriaAModificar.getId());
        return output;
    }

    @Override
    public void eliminar(Long id, Usuario usuario) {
        //Verificamos si el usuario que está ejecutando el Caso de Uso tiene los permisos necesarios
        verificadorDePermisos.verificarSiUsuarioPuede("ELIMINAR_CATEGORIAS_DISPOSITIVOS", usuario);

        //Buscamos la instancia a modificar en el repositorio según el ID entrante
        Optional<CategoriaDispositivo> posibleCategoria = this.categoriasRepository.buscar(id);

        //Si no existe una categoría asociada con ese id lanzamos exception
        if(posibleCategoria.isEmpty()) {
            throw new CategoriaDispositivoNoEncontradaException();
        }

        CategoriaDispositivo categoriaAEliminar = posibleCategoria.get();

        //Impactamos la eliminación
        this.categoriasRepository.eliminar(categoriaAEliminar);
    }
}
