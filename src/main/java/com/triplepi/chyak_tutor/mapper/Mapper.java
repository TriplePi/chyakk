package com.triplepi.chyak_tutor.mapper;

import org.springframework.stereotype.Component;

import java.time.ZoneId;

@Component
public interface Mapper<E, D> {

    E toEntity(D d);

    D toDTO(E e);
}
