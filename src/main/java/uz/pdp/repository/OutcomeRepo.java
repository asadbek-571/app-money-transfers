package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Card;
import uz.pdp.entity.Outcome;

import java.util.List;

public interface OutcomeRepo extends JpaRepository<Outcome,Long> {
    List<Outcome> findAllByFromCardId(Long fromCard_id);
}
