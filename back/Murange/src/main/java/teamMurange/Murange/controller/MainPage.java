package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.service.MusicService;

import java.time.LocalDate;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class MainPage {

    private MusicService musicService;
    
    @ApiOperation(value = "유저 등록", notes = "유저 계정 생성하기")
    @PostMapping("/users/")
    public ResponseEntity makeUser(/* @RequestBody @Validated UsersRequestDto user*/) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "유저 조회", notes = "유저 계정 조회하기")
    @GetMapping("/users/{user-id}")
    public ResponseEntity getUser(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "daily top100", notes = "오늘의 인기 음악 100개 불러오기")
    @GetMapping("/recommend/topdaily")
    public ResponseEntity getTopDaily(@PathVariable(value = "top-daily") LocalDate date) {
        return new ResponseEntity(HttpStatus.OK);
    }

}