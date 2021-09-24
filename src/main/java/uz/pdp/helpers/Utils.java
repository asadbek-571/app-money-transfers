package uz.pdp.helpers;

import lombok.RequiredArgsConstructor;
import uz.pdp.securtiy.JWTProvider;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class Utils {


    public static String getUsername(HttpServletRequest request) {
        JWTProvider jwtProvider = new JWTProvider();
        String token = request.getHeader("Authorization").substring(7);
        return jwtProvider.getLoginFromToken(token);
    }

}
