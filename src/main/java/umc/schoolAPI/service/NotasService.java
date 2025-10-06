package umc.schoolAPI.service;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import umc.schoolAPI.model.Aluno;
import umc.schoolAPI.model.Notas;
import umc.schoolAPI.repository.NotasRepository;

import java.util.List;

@Service
public class NotasService {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private NotasRepository notasRepository;

    public Notas salvarNota(Long alunoId, Notas notas){
    	Aluno aluno = alunoService.buscarAlunoId(alunoId);
    	notas.setAluno(aluno);
        return notasRepository.save(notas);
    }

    @Transactional
    public void deleteNotasByAlunoIdService(Long alunoId){
        notasRepository.deleteByAlunoId(alunoId);
    }

    public List<Notas> listarTodasAsNotas(){
        return notasRepository.findAll();
    }

}
