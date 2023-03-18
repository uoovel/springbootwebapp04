package net.codeurmas.SpringBootWebApp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codeurmas.model.Contact;
import net.codeurmas.service.ContactBusiness;

@Controller
public class AppController {
	 @RequestMapping("/list_contact")
	    public String listContact(Model model) {
	         
	        ContactBusiness business = new ContactBusiness();
	        List<Contact> contactList = business.getContactList();
	         
	        model.addAttribute("contacts", contactList);       
	         
	        return "contact";
	    }
}
