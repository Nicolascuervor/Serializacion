package org.arle.interfaces;

import org.arle.domain.Cita;
import java.util.List;

public interface CitaRepository {
    void save(Cita cita);

    Cita findByIdCita(int idCita);

    List<Cita> findAll();

    void delete(int idCita);


}
