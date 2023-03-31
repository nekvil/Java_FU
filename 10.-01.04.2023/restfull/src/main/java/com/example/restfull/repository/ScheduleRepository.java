package com.example.restfull.repository;

import com.example.restfull.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByCityFromId(int from);
    List<Schedule> findByCityToId(int to);
    List<Schedule> findByTrainId(int trainId);
    List<Schedule> findByStartTime(LocalDateTime startTime);
    List<Schedule> findByEndTime(LocalDateTime endTime);
}
