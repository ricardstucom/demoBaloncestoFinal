package com.example.repository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 46989075Y on 21/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findByLocalidad(String localidad);
    @Query("select  jugador.equipo from  Jugador jugador group by jugador.posicion")
    List<Object[]> findAvgOfnumcananumasisnumrebByPosition ();
}
