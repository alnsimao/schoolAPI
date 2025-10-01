package umc.schoolAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umc.schoolAPI.model.Notas;
import umc.schoolAPI.repository.NotasRepository;

@Service
public class NotasService {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private NotasRepository notasRepository;

    public Notas salvarNota(Long alunoId, Notas notas){
        return notasRepository.save(notas);
    }
}
