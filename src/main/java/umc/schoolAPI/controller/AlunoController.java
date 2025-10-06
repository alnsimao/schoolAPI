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

import umc.schoolAPI.model.Aluno;
import umc.schoolAPI.repository.AlunoRepository;
import umc.schoolAPI.service.AlunoService;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepo;
	@Autowired
	AlunoService alunoServi;
	
	
	@PostMapping("/alunos")
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		Aluno alunoSalvo = alunoRepo.save(aluno);
		return  alunoSalvo;
	}
	@PutMapping("/alunos/{id}/editar")
	public Aluno editarAluno(@PathVariable Long id,@RequestBody Aluno alunoAtualizado){
		Aluno alunoSalvo = alunoServi.buscarAlunoId(id);
		alunoSalvo.setNome(alunoAtualizado.getNome());
		alunoSalvo.setSobrenome(alunoAtualizado.getSobrenome());
		alunoSalvo.setDataNascimento(alunoAtualizado.getDataNascimento());
		alunoSalvo.setMatricula(alunoAtualizado.getMatricula());
		alunoSalvo.setCpf(alunoAtualizado.getCpf());
		alunoSalvo.setEmail(alunoAtualizado.getEmail());
		alunoSalvo.setTelefone(alunoAtualizado.getTelefone());
		alunoSalvo.setEndereco(alunoAtualizado.getEndereco());
		alunoSalvo.setTurma(alunoAtualizado.getTurma());
		return alunoServi.salvar(alunoSalvo);
	}
	@GetMapping("/alunos/{id}")
	public Aluno buscarPorId(@PathVariable Long id)	{
		return alunoServi.buscarAlunoId(id);
	}
	@DeleteMapping("/alunos/{id}/delete")
	public void deletarPorId(@PathVariable Long id) {
		 alunoRepo.deleteById(id);
	}
		
	}
