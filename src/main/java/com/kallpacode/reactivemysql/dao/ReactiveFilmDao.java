package com.kallpacode.reactivemysql.dao;

import com.kallpacode.reactivemysql.entity.Film;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ReactiveFilmDao extends R2dbcRepository<Film, Long> {
}