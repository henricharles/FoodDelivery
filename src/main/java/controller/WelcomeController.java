package controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
  
@Controller
public class WelcomeController {
	
 	@RequestMapping({"/welcome"})
	public String welcome(Model model, Principal user) {
 		if (user!=null) {
 			//System.out.println(user.getName());
 			//user
 			
 			
 		}
		model.addAttribute("greeting", "Welcome to Food Delivery!!");
		model.addAttribute("tagline", "The one and only place to get the food and enjoy!!");
		
		return "welcome";
	}
 
}
