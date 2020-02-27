package com.triplepi.chyak_tutor.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<E, D> {

    E toEntity(D d);

    D toDTO(E e);
}
