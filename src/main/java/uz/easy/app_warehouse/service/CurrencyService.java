package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.CurrencyDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Currency;
import uz.easy.app_warehouse.repository.CurrencyRepository;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public Result createCurrencyService(CurrencyDto currencyDto) {
        if (currencyRepository.existsByName(currencyDto.getName())) {
            return new Result("Bunday nom bilan valyuta qo'shilgan", false);
        } else {
            Currency currency = new Currency();
            currency.setName(currencyDto.getName());
            currencyRepository.save(currency);
            return new Result("Valyuta yaratildi", true);
        }

    }
}
