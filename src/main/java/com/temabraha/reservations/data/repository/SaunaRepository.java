package com.temabraha.reservations.data.repository;

import com.temabraha.reservations.data.entity.Sauna;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaunaRepository extends CrudRepository<Sauna, Long> {
    Sauna findByNumber(String number);
}
