package vn.sapo.service;

import vn.sapo.domain.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findByName (String name);

    List<Contact> findByNameLike (String name);

}
