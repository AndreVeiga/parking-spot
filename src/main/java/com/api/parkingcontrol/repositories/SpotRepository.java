package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.SpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpotRepository extends JpaRepository<SpotModel, UUID> {
}
