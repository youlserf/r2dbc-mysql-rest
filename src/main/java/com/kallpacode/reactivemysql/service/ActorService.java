package com.kallpacode.reactivemysql.service;

import com.kallpacode.reactivemysql.dao.ReactiveActorDao;
import com.kallpacode.reactivemysql.dao.ReactiveFilmDao;
import com.kallpacode.reactivemysql.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActorService {

    @Autowired
    private ReactiveActorDao actorDao;

    @Autowired
    private ReactiveFilmDao filmDao;

    // Fetch all actors
    public Flux<Actor> getAllActors() {
        return actorDao.findAll();
    }

    // Fetch actor by ID
    public Mono<Actor> getActorById(Long id) {
        return actorDao.findById(id);
    }

    // Save a new actor
    public Mono<Actor> addActor(Actor actor) {
        return actorDao.save(actor);
    }

    // Combine Actor and Film data
    public Flux<String> getActorsAndFilms() {
        return actorDao.findAll()
                .flatMap(actor -> filmDao.findAll()
                        .map(film -> "Actor: " + actor.getFirstName() + " " + actor.getLastName() +
                                ", Film: " + film.getTitle()));
    }
}
