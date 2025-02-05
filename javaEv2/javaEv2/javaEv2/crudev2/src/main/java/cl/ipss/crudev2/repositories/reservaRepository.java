package cl.ipss.crudev2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.ipss.crudev2.models.reserva;

public interface reservaRepository extends JpaRepository<reserva, Long>{
    @Query("SELECT r FROM reserva r JOIN FETCH r.mesa")
    List<reserva> findAllWithMesa();

}
