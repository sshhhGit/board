package com.example.board.controller;

import com.example.board.dto.AccountForm;
import com.example.board.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @GetMapping("/signup")
    public String createUserForm(Model model) {
        model.addAttribute("userForm", new AccountForm());
        return "board/signup.html";
    }

    @PostMapping("/signup")
    public String createUser(@Validated AccountForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "board/signup.html";
        }
        accountService.createUser(form);
        return "redirect:/";
    }
}