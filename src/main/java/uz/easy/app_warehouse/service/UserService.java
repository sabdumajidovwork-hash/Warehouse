package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.UserDto;
import uz.easy.app_warehouse.entity.User;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.repository.UserRepository;
import uz.easy.app_warehouse.repository.WarehouseRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;

    public Result createUserService(UserDto userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        boolean existsByCode = userRepository.existsByPhoneNumber(userDto.getCode());
        boolean existsAllById = warehouseRepository.existsAllById(userDto.getWarehouses());
        if (existsByPhoneNumber) {
            return new Result("Bunday telefon raqam bilan user yaratilgan", false);
        } else if (existsByCode) {
            return new Result("Bunday code bilan user yaratilgan", false);
        } else if (!existsAllById) {
            return new Result("Bunday omborxona(lar) mavjud emas", false);
        } else {
            Set<Warehouse> warehouses = new HashSet<>(warehouseRepository.findAllById(userDto.getWarehouses()));
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            user.setWarehouses(warehouses);
            userRepository.save(user);
            return new Result("User yaratildi", true);
        }


    }
}
