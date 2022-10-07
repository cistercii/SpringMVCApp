package ru.springexample.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculation(@RequestParam(value = "a", required = false) int a,
                              @RequestParam(value = "b", required = false) int b,
                              @RequestParam(value = "operation", required = false) String operation,
                              Model model) {
        double result;
        char symbol;
        switch (operation) {
            case "add": {
                result = a + b;
                symbol = '+';
                break;
            }
            case "dif": {
                result = a - b;
                symbol = '-';
                break;
            }
            case "mul": {
                result = a * b;
                symbol = '*';
                break;
            }
            default: {
                result = 0.0;
                symbol = ' ';
            }
        }

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("operation", symbol);
        model.addAttribute("result", result);
        return "first/calculation";
    }
}
