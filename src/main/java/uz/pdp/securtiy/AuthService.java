package uz.pdp.securtiy;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import uz.pdp.dto.LoginDto;
@Service
public interface AuthService  extends UserDetailsService {

    ResponseEntity<?> login(LoginDto dto);
}
