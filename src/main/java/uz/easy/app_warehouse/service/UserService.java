package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.UserDto;
import uz.easy.app_warehouse.entity.User;
import uz.easy.app_warehouse.entity.Warehouse;
import uz.easy.app_warehouse.entity.WarehouseUser;
import uz.easy.app_warehouse.repository.UserRepository;
import uz.easy.app_warehouse.repository.WarehouseRepository;
import uz.easy.app_warehouse.repository.WarehouseUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WarehouseUserRepository warehouseUserRepository;
    private final WarehouseRepository warehouseRepository;

    public Result createUserService(UserDto userDto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        boolean existsByCode = userRepository.existsByCode(userDto.getCode());
        Optional<Warehouse> warehouseOptional = warehouseRepository.findById(userDto.getWarehouseId());
        if (existsByPhoneNumber) {
            return new Result("Bunday telefon raqam bilan user yaratilgan", false);
        } else if (existsByCode) {
            return new Result("Bunday code bilan user yaratilgan", false);
        } else if (warehouseOptional.isEmpty()) {
            return new Result("Ombor topilmadi", false);
        } else {

            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            User savedUser = userRepository.save(user);
            WarehouseUser warehouseUser = new WarehouseUser();
            warehouseUser.setUser(savedUser);
            warehouseUser.setWarehouse(warehouseOptional.get());

            warehouseUserRepository.save(warehouseUser);


            return new Result("User yaratildi", true);
        }


    }
}
