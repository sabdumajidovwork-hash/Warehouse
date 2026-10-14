package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Measurement;
import uz.easy.app_warehouse.repository.MeasurementRepository;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement) {
        boolean existsByName = measurementRepository.existsByName(measurement.getName());

        if (existsByName) {
            return new Result("Bunday o'lchov birligi mavjud", false);
        } else {
            measurementRepository.save(measurement);
            return new Result("O'lchov birligi qo'shildi", true);
        }
    }

}
