package com.reeduc.ReeducSistema.controller;

import com.reeduc.ReeducSistema.model.User;
import com.reeduc.ReeducSistema.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/entrar")
    public String login() {
        return "login";
    }

    @PostMapping("/entrar")
    public String login(@RequestParam String name,
                        @RequestParam String password,
                        SecurityContext currentContext,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        User usuario = userService.loadUserByName(name);

        if (usuario == null || !userService.verifyPassword(password, usuario.getSenha())) {
            return "redirect:/login?error=true";
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(usuario, null, authorities);

        currentContext.setAuthentication(authentication);

        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        securityContextRepository.saveContext(currentContext, request, response);

        return "redirect:/";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registrar";
    }


    @PostMapping("/registrar")
    public String registrar(@RequestParam String name,
                            @RequestParam String password) {
//        DTO
        User usuario = new User();
        usuario.setName(name);
        usuario.setSenha(password);

        userService.saveUser(usuario);
        return "redirect:/login";
    }
}