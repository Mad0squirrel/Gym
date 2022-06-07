package com.company.work.controllers;
import com.company.work.domain.Purchase;
import com.company.work.domain.Usr;
import com.company.work.repos.PurchaseRepo;
import com.company.work.repos.UsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    PurchaseRepo purchaseRepo;
    @Autowired
    UsrRepo usrRepo;
    @GetMapping("/home")
    public String home(Model model) {
        return "index";
    }
    @GetMapping("/index2")
    public String home2(Model model) {
        return "index2";
    }
    @GetMapping("/purchase")
    public String purchase(Model model) {
        purchaseRepo.save(new Purchase("Light", 1700));
        return "purchase";

    }
    @GetMapping("/purchase2")
    public String purchase2(Model model) {
        purchaseRepo.save(new Purchase("Smart", 2000));
        return "purchase";

    }
    @GetMapping("/purchase3")
    public String purchase3(Model model) {
        purchaseRepo.save(new Purchase("Infinity", 2300));
        return "purchase";

    }
    @GetMapping("/thx")
    public String thx(Model model) {
        return "thx";
    }
    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        usrRepo.save(new Usr(username, password));
        return "thx";
    }
    @GetMapping("/final")
    public String finall(Model model) {
        return "final";
    }


}

