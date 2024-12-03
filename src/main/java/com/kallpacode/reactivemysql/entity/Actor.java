package com.kallpacode.reactivemysql.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("actor")
public class Actor {
    @Id
    private Long actorId;
    private String firstName;
    private String lastName;
    private LocalDate lastUpdate;
}
