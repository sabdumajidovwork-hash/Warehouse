package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.ClientDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Client;
import uz.easy.app_warehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

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

    public Result getClientsService() {
        List<Client> clientList = clientRepository.findAll();

        if (clientList.isEmpty()) return new Result("Clientlar topilmadi", false);

        return new Result("Clientlar ro'yxati", true, clientList);
    }

    public Result getClientByIdService(Long id) {

        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isEmpty()) return new Result("Client topilmadi", false);

        return new Result("Client topildi", true, clientOptional.get());

    }

    public Result updateClientService(Long id, ClientDto dto) {

        Optional<Client> clientOptional = clientRepository.findById(id);

        if (clientOptional.isEmpty()) return new Result("Client topilmadi", false);

        Client client = clientOptional.get();
        client.setPhoneNumber(dto.getPhoneNumber());
        client.setName(dto.getName());
        client.setActive(dto.isActive());

        clientRepository.save(client);


        return new Result("Client tahrirlandi", true);

    }

    public Result removeClientService(Long id) {
        boolean existsById = clientRepository.existsById(id);

        if (!existsById) return new Result("Client topilmadi", false);

        clientRepository.deleteById(id);
        return new Result("Client o'chirildi", true);
    }

}
