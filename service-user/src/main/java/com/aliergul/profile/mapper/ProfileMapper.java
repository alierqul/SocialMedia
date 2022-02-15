package com.aliergul.profile.mapper;

import com.aliergul.profile.dto.request.ProfileRequestDto;
import com.aliergul.profile.repository.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

    Profile toProfile(final ProfileRequestDto dto);

}