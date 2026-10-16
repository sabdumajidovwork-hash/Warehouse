package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.CurrencyDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.CurrencyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @PostMapping
    public Result createCurrency(@RequestBody CurrencyDto currencyDto) {
        return currencyService.createCurrencyService(currencyDto);
    }

    @GetMapping
    public Result getCurrencies() {
        return currencyService.getCurrenciesService();
    }

    @GetMapping("/{id}")
    public Result getCurrencyId(@PathVariable Long id){
        return  currencyService.getCurrencyByIdService(id);
    }

    @PutMapping("/{id}")
    public Result updateCurrency(@PathVariable Long id, @RequestBody CurrencyDto currencyDto){
        return  currencyService.updateCurrencyService(id,currencyDto);
    }

    @DeleteMapping("/{id}")
    public  Result removeCurrency(@PathVariable Long id){
        return  currencyService.removeCurrencyService(id);
    }
}
