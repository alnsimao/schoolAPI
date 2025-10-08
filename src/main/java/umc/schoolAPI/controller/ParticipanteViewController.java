package umc.schoolAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import umc.schoolAPI.model.Participante;
import umc.schoolAPI.service.ParticipanteService;

@Controller
public class ParticipanteViewController {
    private final ParticipanteService participanteService;
    
    public ParticipanteViewController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }
    
    
    @GetMapping("/participantes")
    public String listarParticipantes(Model model) {
        model.addAttribute("participantes", participanteService.listarTodos());
        
        return "lista"; 
    }
    
   
    @GetMapping("/participantes/novo")
    public String novoParticipante(Model model) {
       
        model.addAttribute("participante", new Participante());
        return "formulario"; 
    }
    
   
    @GetMapping("/participantes/editar/{id}")
    public String editarParticipante(@PathVariable Long id, Model model) {
        
        model.addAttribute("participante", participanteService.buscarParticipanteId(id));
        return "formulario"; 
    }

  
    @PostMapping("/participantes/salvar")
    public String salvarParticipante(@ModelAttribute("participante") Participante participante) {
        participanteService.salvar(participante);
        return "redirect:/participantes";
    }


    @PostMapping("/participantes/deletar/{id}")
    public String deletarParticipante(@PathVariable Long id) {
        participanteService.deletarPorId(id);
        return "redirect:/participantes";
    }
}