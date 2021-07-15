package com.example.kkcbackend.dao;

import com.example.kkcbackend.model.Contact;
import com.example.kkcbackend.model.Ulb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ContactDao extends JpaRepository<Contact,Long> {
    @Query(value = "SELECT c FROM Contact c WHERE c.ulb.ulbName = :ulbname")
    List<Contact> getContactsByUlbname(String ulbname);

    @Query(value = "SELECT c FROM Contact c WHERE c.personMobile = :mobile")
    List<Contact> checkPersonExistsByMobile(Long mobile);

    @Query(value = "SELECT c FROM Contact c WHERE c.id = :id")
    List<Contact> checkPersonExistsById(Long id);

    @Modifying
    @Query(value = "UPDATE Contact c SET c.personName = :name, c.personMobile = :mobile, " +
            "c.address = :address, c.ulb = :ulb " +
            "WHERE c.id = :id")
    void updatePerson(Long id,String name, Long mobile, String address, Ulb ulb);

    @Modifying
    @Query(value = "DELETE FROM Contact c WHERE c.personMobile = :mobile")
    void deletePerson(Long mobile);

}
