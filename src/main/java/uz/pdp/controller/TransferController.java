package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.dto.TransferDto;
import uz.pdp.service.TransferService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class TransferController {


    private final TransferService service;

    @PostMapping
    public ResponseEntity<?> transfer(@RequestBody TransferDto dto, HttpServletRequest request) {
        return service.transfer(dto, request);
    }
}
