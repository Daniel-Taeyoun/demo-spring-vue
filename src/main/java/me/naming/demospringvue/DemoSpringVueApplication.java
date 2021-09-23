package me.naming.demospringvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoSpringVueApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringVueApplication.class, args);
  }

  @Controller
  public class TmpController{

    @GetMapping("/hello")
    public String hello(){
      return "/hello";
    }

  }

}
