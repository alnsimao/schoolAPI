package umc.schoolAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import umc.schoolAPI.model.Notas;
import java.util.List;
@Repository

public interface NotasRepository extends JpaRepository<Notas,Long> {
    @Modifying
    @Query("DELETE FROM Notas n WHERE n.participante.id = :participanteId")
    void deleteByParticipanteId(@Param("participanteId") Long participanteId);

    List<Notas> findByParticipanteId(Long participanteId);
}
