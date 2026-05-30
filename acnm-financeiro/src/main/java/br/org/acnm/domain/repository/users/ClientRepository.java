package br.org.acnm.domain.repository.users;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

import br.org.acnm.domain.entity.users.Person;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Person> {

    public Optional<Person> findByUserId(UUID userId) {
        return find("appUser.id", userId).firstResultOptional();
    }
}
