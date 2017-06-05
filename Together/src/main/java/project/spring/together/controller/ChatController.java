package project.spring.together.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.spring.together.domain.TeamVO;
import project.spring.together.service.TeamService;

@Controller
@RequestMapping(value = {"/chat"})
public class ChatController {
	
	@Autowired
	private TeamService teamService;
	
   @RequestMapping(value ={"/chat_main"})
   public void goChatMain() {
      
   }
   
   @RequestMapping(value ={"/chat_newChat"}, method=RequestMethod.GET)
   public void createChat(String company_name, Model model) {
	   List<TeamVO> teamList = teamService.read(company_name);
	   model.addAttribute("teamList", teamList);	   
   }
   
   @RequestMapping(value ={"/chat_newChat"}, method=RequestMethod.POST)
   public void readTeam(String company_name, String team_name, Model model) {
	   String teamMember = teamService.readTeamMember(company_name, team_name); 
	   model.addAttribute("teamMember", teamMember);   
   }
   
   
//   @RequestMapping(value={"/chat_newchat?company_name=${company_name}"}, method=RequestMethod.POST)
//   public void readTeam(@PathVariable("company_name") String company_name, String team_name, Model model) {
//	   String teamMember = teamService.readTeamMember(company_name, team_name); 
//	   model.addAttribute("teamMember", teamMember);
//   }
   
//	@RequestMapping(value = "/chat_newChat?company_name={company_name}", method = RequestMethod.POST)
//	public ResponseEntity<String> readTeamMember(@PathVariable("company_name") String company_name, String team_name) {
//		
//		String resultMember = teamService.readTeamMember(company_name, team_name);
//		ResponseEntity<String> entity = new ResponseEntity<>(resultMember, HttpStatus.OK);
//		return entity;
//	}
   
}