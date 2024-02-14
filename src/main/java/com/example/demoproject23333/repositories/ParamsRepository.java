package com.example.demoproject23333.repositories;


import com.example.demoproject23333.model.Params;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParamsRepository extends JpaRepository<Params,Long> {
    List<Params> findBySpeedTimeBetween( LocalDateTime startDate, LocalDateTime endDate);

}
