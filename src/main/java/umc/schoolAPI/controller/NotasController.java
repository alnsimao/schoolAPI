package umc.schoolAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import umc.schoolAPI.model.Notas;
import umc.schoolAPI.service.NotasService;

@RestController
@RequestMapping("/alunos")
public class NotasController {

    @Autowired
    private NotasService notasService;
    @PostMapping("/{alunoId}/notas")
    @ResponseStatus (HttpStatus.CREATED)
    public Notas addNota(@PathVariable Long alunoId, @RequestBody Notas notas){
        return notasService.salvarNota(alunoId, notas);
    }
}
