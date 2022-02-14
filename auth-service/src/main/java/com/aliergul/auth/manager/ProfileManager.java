package com.aliergul.auth.manager;
import static com.aliergul.auth.constant.RestApiUrl.*;

import com.aliergul.auth.dto.request.ProfileRequestDto;
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
@FeignClient(url="${myapplication.userservice}"+VERSION+PROFILE , name = "profileFeignClient", decode404 = true)
public interface ProfileManager {

    @PostMapping(SAVE)
    ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto);

    @PostMapping(FIND_BY_AUTH_ID)
    ResponseEntity<String> findByAuthId(long id);

}
