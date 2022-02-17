package com.aliergul.socialmedia.mapper;

import com.aliergul.socialmedia.dto.request.DoSignUpRequestDto;
import com.aliergul.socialmedia.dto.response.DoLoginResponseDto;
import com.aliergul.socialmedia.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


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

    User toUser(final DoSignUpRequestDto dto);

    DoLoginResponseDto toLoginResponse(final User dto);
}
