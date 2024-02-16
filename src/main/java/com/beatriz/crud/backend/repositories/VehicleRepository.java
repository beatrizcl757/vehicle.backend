package com.beatriz.crud.backend.repositories;

import com.beatriz.crud.backend.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
