package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.OutputDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Client;
import uz.easy.app_warehouse.entity.Currency;
import uz.easy.app_warehouse.entity.Output;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.repository.ClientRepository;
import uz.easy.app_warehouse.repository.CurrencyRepository;
import uz.easy.app_warehouse.repository.OutputRepository;
import uz.easy.app_warehouse.repository.WarehouseRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputService {
    private final OutputRepository outputRepository;
    private final WarehouseRepository warehouseRepository;
    private final CurrencyRepository currencyRepository;
    private final ClientRepository clientRepository;

    public Result createOutputService(OutputDto dto) {
        boolean existsByCode = outputRepository.existsByCode(dto.getCode());
        if (existsByCode) {
            return new Result("Bunday code li 'Output' shakllangan  ", false);
        }

        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(dto.getWarehouseId());
        Optional<Currency> currencyOptional = currencyRepository.findById(dto.getCurrencyId());
        Optional<Client> clientOptional = clientRepository.findById(dto.getClientId());

        if (warehouseOptional.isEmpty()) {
            return new Result("Ombor topilmadi", false);
        }
        if (currencyOptional.isEmpty()) {
            return new Result("Valyuta topilmadi", false);
        }
        if (clientOptional.isEmpty()) {
            return new Result("Client topilmadi", false);
        }

        Output output = new Output();
        output.setClient(clientOptional.get());
        output.setCurrency(currencyOptional.get());
        output.setWarehouse(warehouseOptional.get());
        output.setDate(dto.getDate());
        output.setCode(dto.getCode());
        output.setFacture_number(dto.getFactureNumber());

        outputRepository.save(output);
        return new Result("Chiqim yaratildi", true);

    }
}
