package com.example.lab9_20233429.repository;

import com.example.lab9_20233429.entity.StfPuzzleSv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StfPuzzleSvRepository {
    public interface StfPuzzleSvRepositoryCustom extends JpaRepository<StfPuzzleSv, String> {}
}
