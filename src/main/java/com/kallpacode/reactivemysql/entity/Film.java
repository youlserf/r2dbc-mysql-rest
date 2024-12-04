package com.kallpacode.reactivemysql.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("film") // Maps to the table 'film' in the database
public class Film {

    @Id
    private Long filmId; // Primary key

    private String title;

    private String description;

    private Integer releaseYear;

    // Getters and setters
}