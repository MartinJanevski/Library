package com.example.library.model.dto;

import lombok.*;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    private String name;

    private String continent;
}
