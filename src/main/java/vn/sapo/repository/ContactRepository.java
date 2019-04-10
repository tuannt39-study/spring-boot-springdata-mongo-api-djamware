package vn.sapo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import vn.sapo.domain.Contact;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

    @Query("{ 'name': ?0}")
    List<Contact> findByName(String name);

    List<Contact> findByNameLike(String name);

}
