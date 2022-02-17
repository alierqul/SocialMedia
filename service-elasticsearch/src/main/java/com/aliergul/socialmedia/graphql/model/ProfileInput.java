package com.aliergul.socialmedia.graphql.model;

import lombok.Data;

@Data
public class ProfileInput {
    String profileid;
    String firstname;
    String lastname;
    String email;
    String city;
    String country;

}
