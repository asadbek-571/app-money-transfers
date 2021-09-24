package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.dto.TransferDto;
import uz.pdp.entity.Card;
import uz.pdp.entity.Income;
import uz.pdp.entity.Outcome;
import uz.pdp.helpers.Utils;
import uz.pdp.repository.CardRepo;
import uz.pdp.repository.IncomeRepo;
import uz.pdp.repository.OutcomeRepo;
import uz.pdp.service.TransferService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {


    private final IncomeRepo incomeRepo;

    private final OutcomeRepo outcomeRepo;

    private final CardRepo cardRepo;

    @Override
    public ResponseEntity<?> transfer(TransferDto dto, HttpServletRequest request) {
        String username = Utils.getUsername(request);
        Optional<Card> fromOptionalCard = cardRepo.findByUsernameAndIdAndActiveTrue(username, dto.getFromCard());
        if (fromOptionalCard.isEmpty()) return ResponseEntity.status(404).body("Card not found");
        Optional<Card> toOptionalCard = cardRepo.findByIdAndActiveTrue(dto.getToCard());
        if (toOptionalCard.isEmpty()) return ResponseEntity.status(404).body("Card not found");

        Card fromCard = fromOptionalCard.get();
        Card toCard = toOptionalCard.get();
        Double amount = dto.getAmount();
        if (amount > fromCard.getBalance())
            ResponseEntity.status(409).body("You don't have enough funds in your account");
        Double commissionAndAmount = (amount * 2.0);
        fromCard.setBalance((fromCard.getBalance() - commissionAndAmount));
        toCard.setBalance((toCard.getBalance() + amount));

        cardRepo.save(fromCard);
        cardRepo.save(toCard);

        Income income = new Income();
        income.setAmount(amount);
        income.setFromCard(fromCard);
        income.setToCard(toCard);
        incomeRepo.save(income);

        Outcome outcome = new Outcome();
        outcome.setAmount(amount);
        outcome.setFromCard(fromCard);
        outcome.setToCard(toCard);
        outcome.setCommissionAmount(commissionAndAmount);
        outcomeRepo.save(outcome);

        return ResponseEntity.ok("Transfer successfully ended");
    }
}
