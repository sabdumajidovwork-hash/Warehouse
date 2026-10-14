package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.easy.app_warehouse.dto.ClientDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Result createClient(@RequestBody ClientDto clientDto){
        return clientService.createClientService(clientDto);
    }


}
