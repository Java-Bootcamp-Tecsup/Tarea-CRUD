package com.codigo.api_bd.service;
import java.util.List;
import java.util.UUID;

import com.codigo.api_bd.dto.AlumnoCreateRequest;
import com.codigo.api_bd.dto.AlumnoResponse;
import com.codigo.api_bd.model.Alumno;
import com.codigo.api_bd.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoService {
    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AlumnoResponse crear(AlumnoCreateRequest request){
        Alumno a = new Alumno(request.nombre(),request.edad());
        Alumno saved = repository.save(a);

        return new AlumnoResponse(saved.getId(),saved.getNombre(),saved.getEdad());
    }

    public List<AlumnoResponse> listar() {
        return repository.findAll()
                .stream()
                .map(a -> new AlumnoResponse(
                        a.getId(),
                        a.getNombre(),
                        a.getEdad()
                ))
                .toList();
    }


    @Transactional
    public AlumnoResponse actualizar(UUID id, AlumnoCreateRequest request) {
        Alumno alumno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumno.setNombre(request.nombre());
        alumno.setEdad(request.edad());

        Alumno actualizado = repository.save(alumno);

        return new AlumnoResponse(
                actualizado.getId(),
                actualizado.getNombre(),
                actualizado.getEdad()
        );
    }

    @Transactional
    public void eliminar(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Alumno no encontrado");
        }
        repository.deleteById(id);
    }

}