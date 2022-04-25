package com.example.library.model;

import com.example.library.model.enums.Category;
import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

}
