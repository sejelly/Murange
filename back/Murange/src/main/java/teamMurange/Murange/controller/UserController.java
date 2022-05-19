package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teamMurange.Murange.dto.UserRequestDto;
import teamMurange.Murange.service.UserService;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @ApiOperation(value = "유저 등록", notes = "유저 계정 생성하기")
    @PostMapping("/users/")
    public ResponseEntity makeUser(@RequestBody @Validated UserRequestDto userRequestDto) {
        userService.makeUser(userRequestDto);
        return new ResponseEntity(HttpStatus.OK);
        // ! spring security, google oauth2 연결 후 변경사항 체크
    }

    @ApiOperation(value = "유저 조회", notes = "유저 계정 조회하기")
    @GetMapping("/users/{user-id}")
    public ResponseEntity getUser(@PathVariable(value = "user-id") Long userId) {
        userService.getUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
