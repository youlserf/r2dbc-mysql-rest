package com.kallpacode.reactivemysql.controller;

import com.kallpacode.reactivemysql.entity.Actor;
import com.kallpacode.reactivemysql.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/reactive/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public Flux<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Mono<Actor> getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public Mono<Actor> addActor(@RequestBody Actor actor) {
        return actorService.addActor(actor);
    }
}
