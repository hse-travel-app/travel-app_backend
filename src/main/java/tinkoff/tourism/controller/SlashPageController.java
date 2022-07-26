package tinkoff.tourism.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SlashPageController {

    @GetMapping
    public String nothing() {
        return "";
    }
}
