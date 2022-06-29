package xcale.controller;

import xcale.entity.User;
import xcale.service.UserServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @GetMapping("/login")
    public String login(@RequestParam("user") String user, @RequestParam("password") String password) {

        User usuario = userServiceImpl.getUserByUserName(user);

        if (usuario == null || !usuario.getLogin().equals(user)) {
            return "DATOS_INCORRECTOS";
        }

        boolean passValidated = BCrypt.checkpw(password, usuario.getPassword());

        if (!passValidated) {
            return "DATOS_INCORRECTOS";
        }

        String token = getJWTToken(user);
        return token;
    }


    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts.builder().setId("construyaJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 43500000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    @GetMapping("/login/version")
    @CrossOrigin(
            allowCredentials = "true",
            origins = "*",
            allowedHeaders = "*"
    )
    public ResponseEntity<String> GetApiVersion() {

        return new ResponseEntity<>("Version 2", HttpStatus.OK);
    }
}
