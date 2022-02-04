package com.aliergul.auth.mapper;

import com.aliergul.auth.dto.request.DoLoginRequestDto;
import com.aliergul.auth.dto.request.DoSignUpRequestDto;
import com.aliergul.auth.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IUserMapper {

    //IUserMapper INSTANCE = Mappers.getMapper( IUserMapper.class );
    /**
     * Birebir aynı olanların eşleşmesi durumu var.
     * eğer alanların yani değişken adlarının aynı olmadığı durumlarda set işlemmi nasıl olacak
     * @param dto
     * @return
     */
    //@Mapping(source ="email",target="username")

    User toUser(final DoLoginRequestDto dto);
    User toUser(final DoSignUpRequestDto dto);
}
