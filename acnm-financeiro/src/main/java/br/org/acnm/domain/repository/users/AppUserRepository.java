package br.org.acnm.domain.repository.users;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

import br.org.acnm.domain.entity.users.AppUser;

@ApplicationScoped
public class AppUserRepository implements PanacheRepository<AppUser> {

    public Optional<AppUser> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public Optional<AppUser> findByUsername(String username) {
        return find("username", username).firstResultOptional();
    }

    public boolean existsByEmail(String email) {
        return count("email", email) > 0;
    }

    public boolean existsByUsername(String username) {
        return count("username", username) > 0;
    }
}