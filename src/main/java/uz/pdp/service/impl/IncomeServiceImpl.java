package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.entity.Card;
import uz.pdp.helpers.Utils;
import uz.pdp.repository.CardRepo;
import uz.pdp.repository.IncomeRepo;
import uz.pdp.service.IncomeService;
import uz.pdp.service.OutcomeService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepo incomeRepo;

    private final CardRepo cardRepo;

    @Override
    public ResponseEntity<?> get(Long id, HttpServletRequest request) {
        String username = Utils.getUsername(request);
        Optional<Card> optionalCard = cardRepo.findByUsernameAndIdAndActiveTrue(username, id);
        if (optionalCard.isEmpty())
            return ResponseEntity.status(404).body("Card not found");
        return ResponseEntity.ok(incomeRepo.findAllByFromCardId(id));
    }
}
