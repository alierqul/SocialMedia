package com.aliergul.web.controller;


import com.aliergul.web.dto.request.DoSignUpRequestDto;
import com.aliergul.web.manager.AuthServiceManager;
import com.aliergul.web.service.S3ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private final S3ManagerService s3ManagerService;

    private final AuthServiceManager authServiceManager;

    // localhost/register
    @GetMapping("/signup")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        /**
         * template altındaki html page ile aynı olmalıdır.
         * public altında ki html file ları KULLANILAMAZ
         */
        modelAndView.setViewName("signup");
        return modelAndView;
    }
    @PostMapping("/signup")
    public Object register(String firstname, String lastname,
                           String email, String password,String city,
                           String country, MultipartFile image) {
        ModelAndView model = new ModelAndView();
        /**
         * Üyelik için
         * Auth -> ka, şifre
         * User -> profil bilgilerini
         * ProfileId ver
         */
        log.info("İstek Geldi: \n:"
                +firstname
                +"\n"+lastname
                +"\n"+email
                +"\n"+country
                +"\n"+city
                +"\n"+password);
       String profileId =  authServiceManager.doSignUp(DoSignUpRequestDto.builder()
                        .password(password)
                        .username(email)
                        .lastname(lastname)
                        .firstname(firstname)
                        .country(country)
                        .city(city)
                        .build());
        try{

           String imageURL= s3ManagerService.putObject(profileId+".png",image);
          log.info("ImageURL: "+imageURL);
          model.setViewName("login");

        }catch (Exception e){
            log.error("The image don't load...: "+e.getMessage());
            model.setViewName("register");
        }
        return model;
    }


}
