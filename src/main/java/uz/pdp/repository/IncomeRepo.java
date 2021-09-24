package uz.pdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Income;

import java.util.List;

public interface IncomeRepo extends JpaRepository<Income,Long> {

    List<Income> findAllByFromCardId(Long fromCard_id);
}
