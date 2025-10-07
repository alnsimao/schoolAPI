package umc.schoolAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umc.schoolAPI.model.Participante;
import umc.schoolAPI.repository.ParticipanteRepository;

import java.util.NoSuchElementException;

@Service
public class ParticipanteService {
	
	@Autowired
	private ParticipanteRepository participanteRepository;
	
	
	public Participante salvar(Participante participante) {
		return participanteRepository.save(participante);
	}
    public Participante buscarParticipanteId(long id){
        return participanteRepository.findById(id).orElseThrow(()-> new NoSuchElementException("participante não encontrado"));
    }


}
