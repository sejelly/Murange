package teamMurange.Murange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainPage {

    // 계정 생성
    @PostMapping("/users/")
    public ResponseEntity makeUser(/* @RequestBody @Validated UsersRequestDto user*/) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 계정 조회
    @GetMapping("/users/{user-id}")
    public ResponseEntity getUser(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // daily top100 불러오기
    @GetMapping("/recommend/topdaily")
    public ResponseEntity getTopDaily(@PathVariable(value = "top-daily") Date date) {
        return new ResponseEntity(HttpStatus.OK);
    }


    // 감정에 따른 음악 불러오기
    @GetMapping("/recommend/{category-id}")
    public ResponseEntity getMusic(@PathVariable(value = "category-id") Long categoryId) {
        return new ResponseEntity(HttpStatus.OK);
    }

}