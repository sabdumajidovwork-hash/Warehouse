package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.ClientDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Client;
import uz.easy.app_warehouse.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Result createClientService(ClientDto clientDto) {
        if (clientRepository.existsByPhoneNumber(clientDto.getPhoneNumber())) {
            return new Result("bunday telefon raqam bilan client yaratilgan", false);
        } else {
            Client client = new Client();
            client.setName(clientDto.getName());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return new Result("Client yaratildi", true);
        }
    }

}
