package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.dto.CardDto;

import javax.servlet.http.HttpServletRequest;

public interface CardService {
    ResponseEntity<?> add(CardDto dto, HttpServletRequest request);

    ResponseEntity<?> get(HttpServletRequest request);
}
