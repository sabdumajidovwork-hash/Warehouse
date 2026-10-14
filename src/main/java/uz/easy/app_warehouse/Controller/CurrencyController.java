package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.CurrencyDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.CurrencyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @PostMapping
    public Result createCurrency(@RequestBody CurrencyDto currencyDto){
        return  currencyService.createCurrencyService(currencyDto);
    }
}
