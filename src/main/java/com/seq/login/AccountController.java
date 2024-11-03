package com.seq.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    public final AccountRepository accountRepository;


    @GetMapping("/registration")
    String registration(Model model) {
        List<Account> result = accountRepository.findAll();

        return "registration.html";
    }

    @GetMapping("/info")
    String info(Model model) {
        List<Account> result = accountRepository.findAll();
        model.addAttribute("accounts", result);
        System.out.println(result.get(0).name);

        return "info.html";
    }
}
