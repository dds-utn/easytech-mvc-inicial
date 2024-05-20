package ar.utn.ba.dds.easytech.controllers;

import ar.utn.ba.dds.easytech.dtos.inputs.dispositivos.CategoriaDispositivoInputDTO;
import ar.utn.ba.dds.easytech.models.entities.usuarios.Usuario;
import ar.utn.ba.dds.easytech.services.ICategoriasService;

public class CategoriasController {
    private ICategoriasService categoriasService;

    public CategoriasController(ICategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    public Object crear(Object solicitud) {
        //En la sigueinte línea se debería hacer el mapeo real entre el verdadero input y el DTO
        CategoriaDispositivoInputDTO dto = (CategoriaDispositivoInputDTO) solicitud;

        //En la siguiente línea se debería obtener el usuario logueado que está ejecutando el método desde el contexto actual
        //Por fines prácticos, se le asigna null
        Usuario usuarioActual = null;

        return this.categoriasService.crear(dto, usuarioActual);
    }
}
