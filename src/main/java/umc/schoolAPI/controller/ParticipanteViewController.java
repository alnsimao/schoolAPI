package umc.schoolAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import umc.schoolAPI.service.ParticipanteService;

@Controller
public class ParticipanteViewController {
		private final ParticipanteService participanteService;
		
		public ParticipanteViewController(ParticipanteService participanteService) {
			this.participanteService = participanteService;
		}
		
		@GetMapping("/alunos")
	    public String listarAlunos(Model model) {
	        model.addAttribute("participantes", participanteService.listarTodos());
	        return "participantes"; 
	    }
}
