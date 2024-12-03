package com.kallpacode.reactivemysql.service;

import com.kallpacode.reactivemysql.dao.ReactiveActorDao;
import com.kallpacode.reactivemysql.dao.ReactiveFilmDao;
import com.kallpacode.reactivemysql.entity.Actor;
import com.kallpacode.reactivemysql.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ActorFilmService {
    @Autowired
    private ReactiveActorDao actorDao;
    @Autowired
    ReactiveFilmDao filmDao;

    public Flux<Tuple<Actor, Film>> combineActorFilm(){
        return actorDao.findAll()
                .flatMap(actor -> filmDao.findAll()
                        .filter(film -> film.getFilmId() % actor.getActorId() == 0)
                        .map(film -> new Tuple<>(actor, film)));
    }

    public Flux<Actor> observableVsObserver(){
        return actorDao.findAll()
                .doOnSubscribe(subscription -> System.out.println("Observer subscribed"))
                .doOnNext(actor -> System.out.println("Observable emitted actor: " + actor));
    }

    public Flux<Actor> hotVsColdStreamExample() {
        Flux<Actor> coldStream = actorDao.findAll(); // Cold stream: starts on subscription
        return coldStream.delayElements(Duration.ofMillis(500)); // Simulate delay for testing
    }

    public Flux<Flux<Actor>> bufferingExample() {
        return actorDao.findAll()
                .doOnNext(actor -> System.out.println("Emitting actor: " + actor))
                .bufferTimeout(5, Duration.ofSeconds(2)) // Collect up to 5 actors or within 2 seconds
                .map(Flux::fromIterable); // Wrap each batch as a Flux
    }

    public Flux<Flux<Actor>> windowingExample(){
        return actorDao.findAll()
                .window(3);
    }

    public Flux<Tuple<Actor, Film>> mergeMapExample() {
        return actorDao.findAll()
                .flatMap(actor -> filmDao.findAll()
                        .take(1) // Take only one film per actor for simplicity
                        .map(film -> new Tuple<>(actor, film))); // Merge actors with films
    }

    public Flux<Tuple<Actor, Film>> combineLatestExample() {
        return Flux.combineLatest(actorDao.findAll(), filmDao.findAll(), Tuple::new);
    }

    public Flux<Actor> retryExample() {
        return actorDao.findAll()
                .flatMap(actor -> {
                    if (actor.getActorId() % 2 == 0) {
                        return Mono.error(new RuntimeException("Simulated error"));
                    }
                    return Mono.just(actor);
                })
                .retry(2); // Retry up to 2 times on error
    }

    public Flux<Actor> timeoutExample() {
        return actorDao.findAll()
                .delayElements(Duration.ofSeconds(3)) // Simulate a slow operation
                .timeout(Duration.ofSeconds(2)) // Timeout if it takes longer than 2 seconds
                .onErrorResume(throwable -> Flux.empty()); // Fallback to empty Flux on timeout
    }

}
