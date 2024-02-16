package com.beatriz.crud.backend.services;


import com.beatriz.crud.backend.dtos.VehicleDto;
import com.beatriz.crud.backend.entities.Vehicle;
import com.beatriz.crud.backend.exceptions.AppException;
import com.beatriz.crud.backend.mappers.VehicleMapper;
import com.beatriz.crud.backend.repositories.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;


    public List<VehicleDto> allVehicles() {
        List<Vehicle> all = vehicleRepository.findAll();
        return vehicleMapper.toVehicleDtos(all);

    }

    public VehicleDto getVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        return vehicleMapper.toVehicleDto(vehicle);

    }

    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);

        Vehicle createdVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toVehicleDto(createdVehicle);
    }

    public VehicleDto deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));
        VehicleDto vehicleDto = vehicleMapper.toVehicleDto(vehicle);

        vehicleRepository.deleteById(id);
        return vehicleDto;
    }

    public VehicleDto updateVehicle(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new AppException("Vehicle not found", HttpStatus.NOT_FOUND));

        vehicleMapper.updateVehicle(vehicle, vehicleMapper.toVehicle(vehicleDto));

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toVehicleDto(savedVehicle);
    }
}
