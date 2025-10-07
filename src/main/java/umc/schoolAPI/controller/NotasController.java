package umc.schoolAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.schoolAPI.model.Notas;
import umc.schoolAPI.repository.NotasRepository;
import umc.schoolAPI.service.NotasService;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private NotasService notasService;
    @Autowired
    private NotasRepository notasRepository;
    @PostMapping("/{participanteId}")
    @ResponseStatus (HttpStatus.CREATED)
    public Notas addNota(@PathVariable Long participanteId, @RequestBody Notas notas){
        return notasService.salvarNota(participanteId, notas);
    }

    @DeleteMapping("/delete/{participanteId}")
    public ResponseEntity<Notas> deletarNotasDoParticipante(@PathVariable Long participanteId) {
        notasService.deleteNotasByIdParticipanteService(participanteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Notas> listarTodasAsNotas(){
        return notasService.listarTodasAsNotas();
    }
}
