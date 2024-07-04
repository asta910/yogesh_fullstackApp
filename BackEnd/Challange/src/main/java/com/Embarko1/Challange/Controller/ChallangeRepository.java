package com.Embarko1.Challange.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallangeRepository extends JpaRepository <Challange,Long> {
    Optional<Challange> findByMonthIgnoreCase(String month);

}
