package umc.schoolAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.schoolAPI.model.Aluno;

import java.util.Optional;

public interface AlunoRepository  extends JpaRepository<Aluno, Long>{
    @Override
    Optional<Aluno> findById(Long Long);
}
