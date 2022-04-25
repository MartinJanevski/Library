package com.example.library.model.dto;

import com.example.library.model.enums.Category;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;
}
