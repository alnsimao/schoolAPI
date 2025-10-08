package umc.schoolAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public  Notas buscarNotaId(Long id) {
    	return notasRepository.findById(id)
    			.orElseThrow();
    }
    public void deleteNotasByIdParticipanteService(Long participanteId){
        notasRepository.deleteByParticipanteId(participanteId);
    }
    
    public Notas editarNota(Long id,Notas notaNova) {
    	Notas notasSalva = buscarNotaId(id);
    	notasSalva.setNota1(notaNova.getNota1());
    	notasSalva.setNota2(notaNova.getNota2());
    	return notasRepository.save(notasSalva);
    	
    	
    }

    public List<Notas> listarTodasAsNotas(){
        return notasRepository.findAll();
    }

}
