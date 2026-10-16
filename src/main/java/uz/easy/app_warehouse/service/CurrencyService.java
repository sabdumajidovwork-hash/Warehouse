package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.CurrencyDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Currency;
import uz.easy.app_warehouse.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;

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

    public Result getCurrenciesService() {
        List<Currency> currencyList = currencyRepository.findAll();

        if (currencyList.isEmpty()) return new Result("Valyutalar topilmadi", false);

        return new Result("Valyutalar ro'yxati", true, currencyList);
    }

    public Result getCurrencyByIdService(Long id) {
        Optional<Currency> currencyOptional = currencyRepository.findById(id);

        if (currencyOptional.isEmpty()) return new Result("Valyuta topilmadi", false);

        return new Result("Valyuta topildi", true, currencyOptional.get());


    }

    public Result updateCurrencyService(Long id, CurrencyDto dto) {

        Optional<Currency> currencyOptional = currencyRepository.findById(id);

        if (currencyOptional.isEmpty()) return new Result("Valyuta topilmadi", false);

        Currency currency = currencyOptional.get();

        currency.setName(dto.getName());
        currency.setActive(dto.isActive());

        currencyRepository.save(currency);

        return new Result("Valyuta taxrirlandi", true);


    }

    public Result removeCurrencyService(Long id) {

        boolean existsById = currencyRepository.existsById(id);

        if (!existsById) return new Result("Valyuta topilmadi", false);

        currencyRepository.deleteById(id);

        return new Result("Valyuta o'chirildi", true);

    }


}
