package com.kallpacode.reactivemysql.dto;

import com.kallpacode.reactivemysql.entity.Actor;
import com.kallpacode.reactivemysql.entity.Film;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActorFilmDto<A, F> {
    private Actor actor;
    private Film film;
}
