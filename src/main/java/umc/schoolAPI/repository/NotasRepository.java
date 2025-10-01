package umc.schoolAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.schoolAPI.model.Notas;
import java.util.List;
@Repository

public interface NotasRepository extends JpaRepository<Notas,Long> {
    List<Notas> findByAlunoId(Long alunoId);
}
