package com.aliergul.socialmedia.manager;

import com.aliergul.socialmedia.constant.RestApiUrl;
import com.aliergul.socialmedia.dto.request.ProfileRequestDto;
import com.aliergul.socialmedia.dto.request.FindByAutIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * MicroService mimrisi ile kullanılan yapılarda adresler değişebilir.
 * localhost:8091/v1
 * Bu nedenle istek atılacak microservislerde farklı adresler de olabilir. test ya da geliştirm ortamları farklı olabilir.
 * bunu yönetebilmek adına URL bilgisi application.yml içiinden çekilmeli.
 */
@FeignClient(url="${myapplication.userservice}"+ RestApiUrl.VERSION+ RestApiUrl.PROFILE , name = "profileFeignClient", decode404 = true)
public interface ProfileManager {

    @PostMapping(RestApiUrl.SAVE)
    ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto);

    @PostMapping(RestApiUrl.FIND_BY_AUTH_ID)
    String findByAuthId(@RequestBody FindByAutIdDto id);

}
