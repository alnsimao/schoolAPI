package umc.schoolAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import umc.schoolAPI.model.Participante;
import umc.schoolAPI.model.Notas;
import umc.schoolAPI.repository.NotasRepository;

import java.util.List;

@Service
public class NotasService {
    @Autowired
    private ParticipanteService participanteService;
    @Autowired
    private NotasRepository notasRepository;

    public Notas salvarNota(Long participanteId, Notas notas){
    	Participante participante = participanteService.buscarParticipanteId(participanteId);
    	notas.setParticipante(participante);
        return notasRepository.save(notas);
    }

    @Transactional
    public void deleteNotasByIdParticipanteService(Long participanteId){
        notasRepository.deleteByParticipanteId(participanteId);
    }

    public List<Notas> listarTodasAsNotas(){
        return notasRepository.findAll();
    }

}
