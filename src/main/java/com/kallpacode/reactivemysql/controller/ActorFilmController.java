package com.kallpacode.reactivemysql.controller;

import com.kallpacode.reactivemysql.dto.ActorFilmDto;
import com.kallpacode.reactivemysql.entity.Actor;
import com.kallpacode.reactivemysql.entity.Film;
import com.kallpacode.reactivemysql.service.ActorFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/reactive/actorfilm")
public class ActorFilmController {

    @Autowired
    private ActorFilmService actorFilmService;

    // Combine Actor and Film (join-like logic)
    @GetMapping("/combine-actor-film")
    public Flux<ActorFilmDto<Actor, Film>> combineActorFilm() {
        return actorFilmService.combineActorFilm();
    }

    // Observable vs Observer: shows the observable-emitting and observer-reacting relationship
    @GetMapping("/observable-vs-observer")
    public Flux<Actor> observableVsObserver() {
        return actorFilmService.observableVsObserver();
    }

    // Hot vs Cold Streams: demonstrates cold stream behavior
    @GetMapping("/hot-vs-cold")
    public Flux<Actor> hotVsColdStreamExample() {
        return actorFilmService.hotVsColdStreamExample();
    }

    // Buffering: collects multiple items into batches before emitting them
    @GetMapping("/buffering")
    public Flux<Flux<Actor>> bufferingExample() {
        return actorFilmService.bufferingExample();
    }

    // Windowing: splits the stream into windows of a fixed size
    @GetMapping("/windowing")
    public Flux<Flux<Actor>> windowingExample() {
        return actorFilmService.windowingExample();
    }

    // MergeMap: handles concurrent operations and merges results
    @GetMapping("/mergemap")
    public Flux<ActorFilmDto<Actor, Film>> mergeMapExample() {
        return actorFilmService.mergeMapExample();
    }

    // CombineLatest: combines multiple streams, emitting the latest value from each
    @GetMapping("/combine-latest")
    public Flux<ActorFilmDto<Actor, Film>> combineLatestExample() {
        return actorFilmService.combineLatestExample();
    }

    // Retry: retry failed operations (with a simulated failure)
    @GetMapping("/retry")
    public Flux<Actor> retryExample() {
        return actorFilmService.retryExample();
    }

    // Timeout: handle timeout if operation takes too long
    @GetMapping("/timeout")
    public Flux<Actor> timeoutExample() {
        return actorFilmService.timeoutExample();
    }
}
