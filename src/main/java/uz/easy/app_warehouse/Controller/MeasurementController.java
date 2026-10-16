package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.MeasurementDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.MeasurementService;

@RestController
@RequestMapping("/measurement")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping
    public Result addMeasurementController(@RequestBody MeasurementDto measurementDto) {
        return measurementService.addMeasurementService(measurementDto);
    }

    @GetMapping
    public Result getMeasurements() {
        return measurementService.getMeasurementsService();
    }

    @GetMapping("/{id}")
    public Result getMeasurementById(@PathVariable Long id) {
        return measurementService.getMeasurementByIdService(id);
    }

    @PutMapping("/{id}")
    public Result updateMeasurement(@PathVariable Long id, @RequestBody MeasurementDto measurementDto) {
        return measurementService.updateMeasurementService(id, measurementDto);
    }

    @DeleteMapping("/{id}")
    public Result removeMeasurement(@PathVariable Long id) {
        return measurementService.removeMeasurementService(id);
    }


}
