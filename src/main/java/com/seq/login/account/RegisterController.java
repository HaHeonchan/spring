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
public class RegisterController {

    private final AccountRepository accountRepository;

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("error", "");
        return "register.html";
    }

    @PostMapping("/account")
    String addAccount(
            String name,
            String userId,
            String password,
            Model model
    ) {
        if (name == null || name.isEmpty() || userId == null || userId.isEmpty() || password == null || password.isEmpty()) {
            model.addAttribute("error", "모든 필드를 입력해주세요.");
            model.addAttribute("name", name);
            model.addAttribute("userId", userId);
            model.addAttribute("password", password);
            return "register.html";
        }

        if (accountRepository.existsByUserId(userId)) {
            model.addAttribute("error", "이미 사용 중인 사용자 ID입니다.");
            model.addAttribute("name", name);
            model.addAttribute("userId", userId);
            model.addAttribute("password", password);
            return "register.html";
        }

        Account account = new Account();
        account.setName(name);
        account.setUserId(userId);
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
