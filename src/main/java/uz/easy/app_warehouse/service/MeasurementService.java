package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.MeasurementDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Measurement;
import uz.easy.app_warehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    public Result addMeasurementService(MeasurementDto dto) {
        boolean existsByName = measurementRepository.existsByName(dto.getName());

        if (existsByName) {
            return new Result("Bunday o'lchov birligi mavjud", false);
        } else {
            Measurement measurement = new Measurement();
            measurement.setName(dto.getName());
            measurement.setActive(dto.isActive());
            measurementRepository.save(measurement);
            return new Result("O'lchov birligi qo'shildi", true);
        }
    }

    public Result getMeasurementsService() {
        List<Measurement> measurementList = measurementRepository.findAll();
        if (measurementList.isEmpty()) return new Result("O'lchov birliklari topilmadi", false);

        return new Result("O'lchov birliklari topildi", true, measurementList);

    }

    public Result getMeasurementByIdService(Long id) {

        Optional<Measurement> measurementOptional = measurementRepository.findById(id);

        if (measurementOptional.isEmpty()) return new Result("O'lchov birligi topilmadi", false);

        return new Result("O'lchov birligi topildi", true, measurementOptional.get());

    }

    public Result updateMeasurementService(Long id, MeasurementDto dto) {

        Optional<Measurement> measurementOptional = measurementRepository.findById(id);

        if (measurementOptional.isEmpty()) return new Result("O'lchov birligi topilmadi", false);

        Measurement measurement = measurementOptional.get();

        measurement.setActive(dto.isActive());
        measurement.setName(dto.getName());

        measurementRepository.save(measurement);

        return new Result("O'lchov birligi tahrirlandi", true);


    }

    public Result removeMeasurementService(Long id) {

        boolean existsById = measurementRepository.existsById(id);

        if (!existsById) return new Result("O'lchov topilmadi", false);

        measurementRepository.deleteById(id);

        return new Result("O'lchov birligi o'chirildi", true);

    }


}
