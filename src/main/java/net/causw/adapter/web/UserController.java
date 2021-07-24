package net.causw.adapter.web;

import net.causw.application.UserAuthService;
import net.causw.application.UserService;
import net.causw.application.dto.UserAuthDto;
import net.causw.application.dto.UserCreateRequestDto;
import net.causw.application.dto.UserDetailDto;
import net.causw.application.dto.UserSignInRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserAuthService userAuthService;

    public UserController(UserService userService, UserAuthService userAuthService) {
        this.userService = userService;
        this.userAuthService = userAuthService;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDetailDto findById(@PathVariable String id) {
        return this.userService.findById(id);
    }

    @PostMapping(value = "/sign-up")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UserDetailDto signUp(@RequestBody UserCreateRequestDto userCreateDto) {
        return this.userService.create(userCreateDto);
    }

    // TODO : JWT 반영
    @PostMapping(value = "/sign-in")
    @ResponseStatus(value = HttpStatus.OK)
    public UserDetailDto signIn(@RequestBody UserSignInRequestDto userSignInRequestDto) {
        return this.userService.signIn(userSignInRequestDto);
    }

    @GetMapping(value = "/auth/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UserAuthDto findAuthById(@PathVariable String id) {
        return this.userAuthService.findById(id);
    }
}