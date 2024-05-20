package ar.utn.ba.dds.easytech.utils.permisos;

import ar.utn.ba.dds.easytech.models.entities.usuarios.Permiso;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;
import ar.utn.ba.dds.easytech.repositories.IPermisosRepository;

import java.util.Optional;

public class VerificadorDePermisos {
    private IPermisosRepository permisosRepository;

    public VerificadorDePermisos(IPermisosRepository permisosRepository) {
        this.permisosRepository = permisosRepository;
    }

    public void verificarSiUsuarioPuede(String accion, Usuario usuario) {
        Optional<Permiso> permisoBuscado = this.permisosRepository.buscarPorNombre(accion);

        if(permisoBuscado.isEmpty())
            throw new RuntimeException("No existe un permiso con el nombre " + accion);

        Permiso permiso = permisoBuscado.get();

        if(!usuario.getRol().tenesPermiso(permiso))
            throw new SinPermisoSuficienteException("Usted no tiene permiso: " + accion);
    }
}
