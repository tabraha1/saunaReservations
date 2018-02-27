package com.temabraha.reservations.data.repository;

import com.temabraha.reservations.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}
