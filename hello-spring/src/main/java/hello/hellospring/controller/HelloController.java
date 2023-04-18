package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // 웹어플리케이션에서 /hello라고 치면 이 메서드를 호출해줌
    public String hello(Model model){
        model.addAttribute("data","spring!!");
        return "hello";  //resources/templates/hello.html을 찾아서 랜더링 해라(hello.html을 실행시켜라)

    }
}

