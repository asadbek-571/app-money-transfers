package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepo extends JpaRepository<Card,Long> {
    List<Card> findAllByUsername(String username);

    Optional<Card> findByUsernameAndIdAndActiveTrue(String username, Long fromCard);

    Optional<Card> findByIdAndActiveTrue(Long toCard);
}
