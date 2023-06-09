package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // 웹어플리케이션에서 /hello라고 치면 이 메서드를 호출해줌
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";  //resources/templates/hello.html을 찾아서 랜더링 해라(hello.html을 실행시켜라)

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) { //모델에 담으면 뷰에서 랜더링할때 씀
        model.addAttribute("name", name); // 키,네임
        return "hello-template";

    }


    //이걸 쓸일은 거의 없음
    @GetMapping("hello-string")
    @ResponseBody //http에서(head와 body부분이 있음), body부에 이 데이터를 내가 직접넣어주겠다..!
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody //json으로 반환
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); //ctrl + shift +enter 나머지 자동완성
        hello.setName(name);
        return hello;
    }


    static class Hello {
        private String name;

        
        //프로퍼티 접근방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}




