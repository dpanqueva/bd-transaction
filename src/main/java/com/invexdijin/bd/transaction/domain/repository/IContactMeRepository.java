package com.invexdijin.bd.transaction.domain.repository;

import com.invexdijin.bd.transaction.domain.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactMeRepository extends JpaRepository<ContactEntity, Long> {
}
