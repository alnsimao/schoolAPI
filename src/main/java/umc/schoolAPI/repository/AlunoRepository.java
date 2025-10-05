package umc.schoolAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.schoolAPI.model.Aluno;



public interface AlunoRepository  extends JpaRepository<Aluno, Long>{
  
}
