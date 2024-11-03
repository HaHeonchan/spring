package com.seq.login.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;


    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/account")
    String addAccount(
            String name,
            String password
    ) {
        Account account = new Account();
        account.setName(name);
        var hash = new BCryptPasswordEncoder().encode(password);
        account.setPassword(hash);
        accountRepository.save(account);

        return "redirect:/info";
    }


    @GetMapping("/info")
    String info(Model model) {
        List<Account> result = accountRepository.findAll();
        model.addAttribute("accounts", result);

        return "info.html";
    }
}
