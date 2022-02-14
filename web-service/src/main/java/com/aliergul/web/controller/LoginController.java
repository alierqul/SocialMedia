package com.aliergul.web.controller;

import com.aliergul.web.dto.request.DoLoginDto;
import com.aliergul.web.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {
    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    // localhost/login
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        /**
         * template altındaki html page ile aynı olmalıdır.
         * public altında ki html file ları KULLANILAMAZ
         */
        modelAndView.setViewName("login");
        /*
        List<LoginPageModel.urun> list = new ArrayList<>();
        list.add(LoginPageModel.urun.builder().urunAdi("PC").build());
        list.add(LoginPageModel.urun.builder().urunAdi("LAPTOP").build());

        modelAndView.addObject("model",
                LoginPageModel
                        .builder()
                        .title("Üye Ol!!!")
                        .urunler(list)
                        .build());
        modelAndView.addObject("model2",
                "Başka Model");
        */
        return modelAndView;
    }

    @PostMapping("/login")
    Object doLogin(@Valid DoLoginDto dto){
        if(service.Login(dto.getEmail(),dto.getPassword())) {
            return "redirect:/";
        }else{
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("login");
            modelAndView.addObject("apiError","Lütfen Bilgilerinizi Kontrol ediniz.");
            return modelAndView;
        }

    }

}
