package vn.sapo.service.impl;

import org.springframework.stereotype.Service;
import vn.sapo.domain.Contact;
import vn.sapo.repository.ContactRepository;
import vn.sapo.service.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }

    @Override
    public List<Contact> findByNameLike(String name) {
        return contactRepository.findByNameLike(name);
    }

}
