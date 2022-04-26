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
    private UserService userService;
    private TopDailyService topDailyService;
    private TopWeeklyService topWeeklyService;
    
    @ApiOperation(value = "유저 등록", notes = "유저 계정 생성하기")
    @PostMapping("/users/")
    public ResponseEntity makeUser(@RequestBody @Validated UsersRequestDto user) {
        userService.makeUser(UserRequestDto);
        return new ResponseEntity(HttpStatus.OK);
        // ! spring security, google oauth2 연결 후 변경사항 체크
    }

    @ApiOperation(value = "유저 조회", notes = "유저 계정 조회하기")
    @GetMapping("/users/{user-id}")
    public ResponseEntity getUser(@PathVariable(value = "user-id") Long userId) {
        userService.getUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "daily top100", notes = "오늘의 인기 음악 100개 불러오기")
    @GetMapping("/recommend/topdaily")
    public ResponseEntity getTopDaily(@PathVariable(value = "top-daily") LocalDate date) {
        List<TopDaily> topDailyList = TopDailyService.getTopDailyList(categoryId);
        return new ResponseEntity(topDailyList, HttpStatus.OK);
    }

    @ApiOperation(value = "weekly top100", notes = "금주의 인기 음악 100개 불러오기")
    @GetMapping("/recommend/topweekly")
    public ResponseEntity getTopWeekly(@PathVariable(value = "top-weekly") LocalDate date) {
        List<TopWeekly> topWeeklyList = TopWeeklyService.getTopWeeklyList(categoryId);
        return new ResponseEntity(topWeeklyList, HttpStatus.OK);
    }

    // ! 검색 기능 보류 - 추후 사용자 검색 시 팔로우 기능 열어둬야함

}