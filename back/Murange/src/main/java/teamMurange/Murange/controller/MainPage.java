package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teamMurange.Murange.dto.CalendarResponseDto;
import teamMurange.Murange.dto.MusicResponseDto;
import teamMurange.Murange.dto.UserRequestDto;
import teamMurange.Murange.service.*;

import java.util.List;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class MainPage {

    private MusicService musicService;
    private UserService userService;
    private TopDailyService topDailyService;
    private TopWeeklyService topWeeklyService;
    private CategoryService categoryService;
    private CalendarService calendarService;


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

    @ApiOperation(value = "유저 감정 기반 음악 추천", notes = "유저의 마지막 감정 기반 음악 추천")
    @GetMapping("/recommend/{user-id}")
    public ResponseEntity getMusicByUserEmotion(@PathVariable(value = "user-id") Long userId) {
        CalendarResponseDto calendar = calendarService.findUserCalendar(userId);
        Long categoryId = categoryService.findCategoryId(calendar.getFirstEmotion(), calendar.getSecondEmotion());
        List<MusicResponseDto> musicResponseDtoList = musicService.getMusicsByCategory(categoryId);

        return new ResponseEntity(musicResponseDtoList, HttpStatus.OK);
    }

//    @ApiOperation(value = "daily top100", notes = "오늘의 인기 음악 100개 불러오기")
//    @GetMapping("/recommend/topdaily")
//    public ResponseEntity getTopDaily(@PathVariable(value = "top-daily") Long categoryId) {
//        List<TopDaily> topDailyList = TopDailyService.getTopDaily(categoryId);
//        return new ResponseEntity(topDailyList, HttpStatus.OK);
//    }

//    @ApiOperation(value = "weekly top100", notes = "금주의 인기 음악 100개 불러오기")
//    @GetMapping("/recommend/topweekly")
//    public ResponseEntity getTopWeekly(@PathVariable(value = "top-weekly") Long categoryId) {
//        List<TopWeekly> topWeeklyList = TopWeeklyService.getTopWeekly(categoryId);
//        return new ResponseEntity(topWeeklyList, HttpStatus.OK);
//    }

    // ! 검색 기능 보류 - 추후 사용자 검색 시 팔로우 기능 열어둬야함

}