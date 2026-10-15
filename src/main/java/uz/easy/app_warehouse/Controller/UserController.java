package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.dto.UserDto;
import uz.easy.app_warehouse.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public Result createUser(@RequestBody UserDto userDto) {
        return userService.createUserService(userDto);
    }

    @GetMapping
    public Result getUsers() {
        return userService.getUsersService();
    }

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Long id) {
        return userService.getUserByService(id);
    }

    @PostMapping("/{id}")
    public Result updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUserService(id, userDto);
    }

    @DeleteMapping("/{id}")
    public Result removeUser(@PathVariable Long id) {
        return userService.removeUserService(id);
    }

}
