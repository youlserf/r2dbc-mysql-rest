package com.kallpacode.reactivemysql.dao;

import com.kallpacode.reactivemysql.entity.Actor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ReactiveActorDao extends R2dbcRepository<Actor, Long> {
}
