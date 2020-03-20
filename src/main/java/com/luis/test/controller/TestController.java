package com.luis.test.controller;

import com.luis.test.domain.Account;
import com.luis.test.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
public class TestController {

    private AccountService accountService;

    public TestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/post")
    public String addMember(@RequestBody Map<String, Object> data) {
        String response;
        System.out.println(data);
        if (data.get("idNumber") != null && data.get("name") != null) {
            response = "DATOS RECIBIDOS!";
            System.out.println(response);
            return response;
        } else {
            response = "DATOS INCORRECTOS!";
            System.out.println(response);
            return response;
        }
    }

    @GetMapping( value = {"", "/"})
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("Hello", "hellou");
        return response;
    }

    @PostMapping("/create")
    public Account create(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        Account account = new Account((Integer) data.get("idNumber"), (String) data.get("name"), (Integer) data.get("value"));
        return this.accountService.create(account);
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestBody Map<String, Object> data) {
        Integer value = this.check((Integer) data.get("idNumber")).get().getValue() + (Integer) data.get("value");
        Account account = new Account((Integer) data.get("idNumber"), (String) data.get("name"), value);
        return this.accountService.create(account);
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody Map<String, Object> data) {
        Integer value;
        if(this.check((Integer) data.get("idNumber")).get().getValue() < (Integer) data.get("value"))
            value = 0;
        else
            value = this.check((Integer) data.get("idNumber")).get().getValue() - (Integer) data.get("value");
        Account account = new Account((Integer) data.get("idNumber"), (String) data.get("name"), value);
        return this.accountService.create(account);
    }

    @GetMapping("/check/{id}")
    public Optional<Account> check(@PathVariable Integer id){
        return this.accountService.check(id);
    }


}
