package umc.schoolAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import umc.schoolAPI.model.Notas;
import umc.schoolAPI.service.NotasService;
import umc.schoolAPI.service.ParticipanteService;

@Controller
@RequestMapping("/notas")
public class NotasViewController {

    private final NotasService notasService;
    private final ParticipanteService participanteService;

    public NotasViewController(NotasService notasService, ParticipanteService participanteService) {
        this.notasService = notasService;
        this.participanteService = participanteService;
    }


    @GetMapping
    public String listarNotas(Model model) {
        model.addAttribute("notas", notasService.listarTodasAsNotas());
        return "listanotas"; 
    }


    @GetMapping("/novo")
    public String novoNotaForm(Model model) {
      
        model.addAttribute("nota", new Notas()); 
  
        model.addAttribute("participantes", participanteService.listarTodos());
        return "notas"; // 
    }

  
    @GetMapping("/editar/{id}")
    public String editarNotaForm(@PathVariable Long id, Model model) {
       
        model.addAttribute("nota", notasService.buscarNotaId(id));
    
        model.addAttribute("participantes", participanteService.listarTodos());
        return "notas"; 
    }


    @PostMapping("/salvar")
    public String salvarNota(@ModelAttribute("nota") Notas nota) {
        notasService.salvarNota(nota);
        return "redirect:/notas";
    }

    
    @PostMapping("/deletar/{id}")
    public String deletarNota(@PathVariable Long id) {
        notasService.deletarPorId(id);
        return "redirect:/notas";
    }
}