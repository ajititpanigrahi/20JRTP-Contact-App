package com.ashokit.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactRepository;
import com.ashokit.service.ContactService;

@Service
public class ContactServiceimpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepo;
	
	public String upsert (Contact contact) {
		Contact save = contactRepo.save(contact);
		return "Record Saved successfully";
	}
	
	public List<Contact> getAllContacts(){
		
		List<Contact> findAll = contactRepo.findAll();
		
		return findAll;
	}
	
	public Optional<Contact> getContact(int cid) {
		
		Optional<Contact> findById = contactRepo.findById(cid);
		
		if(findById!=null) {
			return findById;
		}
		return findById;
		
	}
	
	public String deleteContact(int cid) {
		
		Optional<Contact> findById = contactRepo.findById(cid);
		
		if(findById.isPresent()) {
			Contact contact = findById.get();
			//contact.setActiveSw("N");
			//contactRepo.save(contact);
			contactRepo.delete(contact);
		}
		
		//contactRepo.deleteById(cid);
		return "Record deleted successfully";
	}
	
	/*public String edit (Contact contact) {
		
		upsert(contact);
		
		return "Record Edited successfully ...";
		
	}*/
	
	

}
