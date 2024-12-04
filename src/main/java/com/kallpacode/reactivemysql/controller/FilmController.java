package com.kallpacode.reactivemysql.controller;

import com.kallpacode.reactivemysql.dao.ReactiveFilmDao;
import com.kallpacode.reactivemysql.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reactive/films")
public class FilmController {
    @Autowired
    private ReactiveFilmDao filmDao;

    @GetMapping
    public Flux<Film> getAllFilms() {
        return filmDao.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Film> getFilmById(@PathVariable Long id) {
        return filmDao.findById(id);
    }
}
