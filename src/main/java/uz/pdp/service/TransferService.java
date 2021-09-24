package uz.pdp.service;

import org.springframework.http.ResponseEntity;
import uz.pdp.dto.TransferDto;

import javax.servlet.http.HttpServletRequest;

public interface TransferService {
    ResponseEntity<?> transfer(TransferDto dto, HttpServletRequest request);

}
