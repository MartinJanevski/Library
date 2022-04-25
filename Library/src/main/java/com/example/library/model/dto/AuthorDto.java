package com.example.library.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private String name;

    private  String surname;

    private Long countryId;
}
