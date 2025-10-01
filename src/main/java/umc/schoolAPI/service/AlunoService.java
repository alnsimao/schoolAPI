package umc.schoolAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import umc.schoolAPI.model.Aluno;
import umc.schoolAPI.repository.AlunoRepository;

import java.util.NoSuchElementException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
    public Aluno buscarAlunoId(long id){
        return alunoRepo.findById(id).orElseThrow(()-> new NoSuchElementException("aluno não encontrado"));
    }
}
