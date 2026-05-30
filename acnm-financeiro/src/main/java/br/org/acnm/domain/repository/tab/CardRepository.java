package br.org.acnm.domain.repository.tab;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

import br.org.acnm.domain.entity.tab.Card;

@ApplicationScoped
public class CardRepository implements PanacheRepository<Card> {

    public Optional<Card> findByIdOptional(Long id) {
        return find("id", id).firstResultOptional();
    }

    public Optional<Card> findByCardNumber(Integer cardNumber) {
        return find("cardNumber", cardNumber).firstResultOptional();
    }

    public Optional<Card> findByAccessToken(String accessToken) {
        return find("accessToken", accessToken).firstResultOptional();
    }

    public boolean existsByCardNumber(Integer cardNumber) {
        return count("cardNumber", cardNumber) > 0;
    }
}
