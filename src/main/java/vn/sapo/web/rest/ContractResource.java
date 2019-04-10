package vn.sapo.web.rest;

import org.springframework.web.bind.annotation.*;
import vn.sapo.domain.Contact;
import vn.sapo.repository.ContactRepository;
import vn.sapo.service.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContractResource {

    private final ContactService contactService;

    private final ContactRepository contactRepository;

    public ContractResource(ContactService contactService, ContactRepository contactRepository) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contacts")
    public List<Contact> contact() {
        return contactRepository.findAll();
    }

    @PostMapping("/contacts")
    public Contact save(@RequestBody Contact contact) {
        contactRepository.save(contact);
        return contact;
    }

    @GetMapping("/contacts/{id}")
    public Optional<Contact> show(@PathVariable String id) {
        return contactRepository.findById(id);
    }

    @PutMapping("/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Optional<Contact> optcontact = contactRepository.findById(id);
        Contact c = optcontact.get();
        if (contact.getName() != null)
            c.setName(contact.getName());
        if (contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if (contact.getCity() != null)
            c.setCity(contact.getCity());
        if (contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if (contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactRepository.save(c);
        return c;
    }

    @DeleteMapping("/contacts/{id}")
    public String delete(@PathVariable String id) {
        Optional<Contact> optcontact = contactRepository.findById(id);
        Contact contact = optcontact.get();
        contactRepository.delete(contact);
        return "";
    }

}
