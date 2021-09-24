package uz.pdp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.dto.CardDto;
import uz.pdp.entity.Card;
import uz.pdp.helpers.Utils;
import uz.pdp.repository.CardRepo;
import uz.pdp.service.CardService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

private final CardRepo cardRepo;


    @Override
    public ResponseEntity<?> add(CardDto dto, HttpServletRequest request) {
        Card card=new Card();
        card.setBalance(dto.getBalance());
        card.setExpireDate(new Date(System.currentTimeMillis()+(518400000*60L)));
        card.setNumber(dto.getNumber());
        card.setUsername(Utils.getUsername(request));
        cardRepo.save(card);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<?> get(HttpServletRequest request) {
        String username = Utils.getUsername(request);
        List<Card> cardList = cardRepo.findAllByUsername(username);
        if (cardList.isEmpty())
            return ResponseEntity.status(404).body("Card not found");
        return ResponseEntity.ok(cardList);
    }

}
