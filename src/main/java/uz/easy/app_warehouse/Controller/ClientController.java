package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.ClientDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.ClientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public Result createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClientService(clientDto);
    }

    @GetMapping
    public Result getClients() {
        return clientService.getClientsService();
    }

    @GetMapping("/{id}")
    public Result getClientById(@PathVariable Long id) {
        return clientService.getClientByIdService(id);
    }

    @PutMapping("/{id}")
    public Result updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        return clientService.updateClientService(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public Result removeClientService(@PathVariable Long id) {
        return clientService.removeClientService(id);
    }

}
