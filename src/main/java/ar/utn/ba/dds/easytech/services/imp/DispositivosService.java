package ar.utn.ba.dds.easytech.services.imp;

import ar.utn.ba.dds.easytech.dtos.inputs.dispositivos.DispositivoInputDTO;
import ar.utn.ba.dds.easytech.dtos.outputs.dispositivos.DispositivoOutputDTO;
import ar.utn.ba.dds.easytech.models.entities.dispositivos.CategoriaDispositivo;
import ar.utn.ba.dds.easytech.models.entities.dispositivos.Dispositivo;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;
import ar.utn.ba.dds.easytech.repositories.ICategoriasRepository;
import ar.utn.ba.dds.easytech.repositories.IDispositivosRepository;
import ar.utn.ba.dds.easytech.services.IDispositivoService;
import ar.utn.ba.dds.easytech.services.exceptions.CategoriaDispositivoNoEncontradaException;
import ar.utn.ba.dds.easytech.services.exceptions.DispositivoNoEncontradoException;
import ar.utn.ba.dds.easytech.utils.permisos.VerificadorDePermisos;

import java.util.Optional;

public class DispositivosService implements IDispositivoService {
    private IDispositivosRepository dispositivosRepository;
    private ICategoriasRepository categoriasRepository;
    private VerificadorDePermisos verificadorDePermisos;

    public DispositivosService(
            IDispositivosRepository dispositivosRepository,
            ICategoriasRepository categoriasRepository,
            VerificadorDePermisos verificadorDePermisos
    ) {
        this.dispositivosRepository = dispositivosRepository;
        this.categoriasRepository = categoriasRepository;
        this.verificadorDePermisos = verificadorDePermisos;
    }

    @Override
    public DispositivoOutputDTO crear(DispositivoInputDTO dispositivoInputDTO, Usuario usuario) {
        //Verificamos si el usuario que está ejecutando el Caso de Uso tiene los permisos necesarios
        verificadorDePermisos.verificarSiUsuarioPuede("CREAR_DISPOSITIVOS", usuario);

        //Primero buscamos la categoría
        Optional<CategoriaDispositivo> posibleCategoria = this.categoriasRepository
                .buscar(dispositivoInputDTO.getCategoriaId());

        //Si no existe una categoría asociada con ese id lanzamos exception
        if(posibleCategoria.isEmpty())
            throw new CategoriaDispositivoNoEncontradaException();

        //Creamos el Dispositivo y lo configuramos
        Dispositivo nuevoDispositivo = new Dispositivo();
        nuevoDispositivo.setCategoria(posibleCategoria.get());
        nuevoDispositivo.setMarca(dispositivoInputDTO.getMarca());
        nuevoDispositivo.setModelo(dispositivoInputDTO.getModelo());
        nuevoDispositivo.setPesoEnKgs(dispositivoInputDTO.getPesoEnKgs());
        nuevoDispositivo.setPrecioAlquiler(dispositivoInputDTO.getPrecioAlquiler());

        //Guardamos el nuevo dispositivo
        this.dispositivosRepository.guardar(nuevoDispositivo);

        //Generamos y configuramos el DTO de salida
        DispositivoOutputDTO output = new DispositivoOutputDTO();
        output.setId(nuevoDispositivo.getId());
        output.setModelo(nuevoDispositivo.getModelo());
        output.setMarca(nuevoDispositivo.getMarca());
        output.setPesoEnKgs(nuevoDispositivo.getPesoEnKgs());
        output.setPrecioAlquiler(nuevoDispositivo.getPrecioAlquiler());
        output.setCategoriaId(nuevoDispositivo.getCategoria().getId());

        return output;
    }

    @Override
    public DispositivoOutputDTO modificar(Long id, DispositivoInputDTO dispositivoInputDTO, Usuario usuario) {
        //TODO
        return null;
    }

    @Override
    public void eliminar(Long id, Usuario usuario) {
        //Verificamos si el usuario que está ejecutando el Caso de Uso tiene los permisos necesarios
        verificadorDePermisos.verificarSiUsuarioPuede("CREAR_DISPOSITIVOS", usuario);

        //Buscamos la instancia a modificar en el repositorio según el ID entrante
        Optional<Dispositivo> posibleDispositivo = this.dispositivosRepository.buscar(id);

        //Si no existe una categoría asociada con ese id lanzamos exception
        if(posibleDispositivo.isEmpty())
            throw new DispositivoNoEncontradoException();

        Dispositivo dispositivo = posibleDispositivo.get();
        //Impactamos la eliminación
        this.dispositivosRepository.eliminar(dispositivo);
    }
}
