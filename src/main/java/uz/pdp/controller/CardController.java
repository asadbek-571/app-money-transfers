package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dto.CardDto;
import uz.pdp.service.CardService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CardDto dto, HttpServletRequest request) {
        return cardService.add(dto, request);
    }

    @GetMapping
    public ResponseEntity<?> get(HttpServletRequest request) {
        return cardService.get(request);
    }

}
