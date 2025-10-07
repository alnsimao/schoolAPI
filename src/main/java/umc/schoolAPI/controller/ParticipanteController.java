package umc.schoolAPI.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import umc.schoolAPI.model.Participante;
import umc.schoolAPI.repository.ParticipanteRepository;
import umc.schoolAPI.service.ParticipanteService;

@RestController
public class ParticipanteController {

	@Autowired
    ParticipanteRepository participanteRepository;
	@Autowired
    ParticipanteService participanteService;
	
	
	@PostMapping("/participante")
	@ResponseStatus(HttpStatus.CREATED)
	public Participante cadastrarParticipante(@RequestBody Participante participante) {
		Participante participanteSalvo = participanteRepository.save(participante);
		return participanteSalvo;
	}
	@PutMapping("/participante/{id}/editar")
	public Participante editarParticipante(@PathVariable Long id, @RequestBody Participante participanteAtualizado){
		Participante participanteSalvo = participanteService.buscarParticipanteId(id);
		participanteSalvo.setNome(participanteAtualizado.getNome());
		participanteSalvo.setSobrenome(participanteAtualizado.getSobrenome());
		participanteSalvo.setDataNascimento(participanteAtualizado.getDataNascimento());
		participanteSalvo.setMatricula(participanteAtualizado.getMatricula());
		participanteSalvo.setCpf(participanteAtualizado.getCpf());
		participanteSalvo.setEmail(participanteAtualizado.getEmail());
		participanteSalvo.setTelefone(participanteAtualizado.getTelefone());
		participanteSalvo.setEndereco(participanteAtualizado.getEndereco());
		participanteSalvo.setTurma(participanteAtualizado.getTurma());
		return participanteService.salvar(participanteSalvo);
	}
	@GetMapping("/participante/{id}")
	public Participante buscarPorId(@PathVariable Long id)	{
		return participanteService.buscarParticipanteId(id);
	}
	@DeleteMapping("/participante/{id}/delete")
	public void deletarPorId(@PathVariable Long id) {
            participanteRepository.deleteById(id);
	}
		
	}
