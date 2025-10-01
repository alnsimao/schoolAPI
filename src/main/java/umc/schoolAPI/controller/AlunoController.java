package umc.schoolAPI.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import umc.schoolAPI.model.Aluno;
import umc.schoolAPI.repository.AlunoRepository;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepo;
	
	
	@PostMapping("/alunos")
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		Aluno alunoSalvo = alunoRepo.save(aluno);
		return  alunoSalvo;
		
	}
}
