package com.golojan.peticd.repositories;

import com.golojan.peticd.models.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {}
