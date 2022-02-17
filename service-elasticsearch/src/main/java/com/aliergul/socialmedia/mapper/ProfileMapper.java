package com.aliergul.socialmedia.mapper;


import com.aliergul.socialmedia.rabbitmq.model.ProfileNotification;
import com.aliergul.socialmedia.repository.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

    Profile toProfile(ProfileNotification profileNotification);
}