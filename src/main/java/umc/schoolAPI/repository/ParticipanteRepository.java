package umc.schoolAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import umc.schoolAPI.model.Participante;


public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
  
}
