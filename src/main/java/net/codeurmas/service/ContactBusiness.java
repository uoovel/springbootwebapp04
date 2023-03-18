package net.codeurmas.service;

import java.util.ArrayList;
import java.util.List;

import net.codeurmas.model.Contact;

public class ContactBusiness {
	public List<Contact> getContactList(){
		List<Contact> listContact = new ArrayList<>();
		
		listContact.add(new Contact("Jack"));
		return listContact;		
	}

}
