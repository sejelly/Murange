package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.domain.Calendar;
import teamMurange.Murange.domain.Comment;
import teamMurange.Murange.repository.CommentRepository;
import teamMurange.Murange.service.CommentService;
import teamMurange.Murange.service.LikeMusicService;
import teamMurange.Murange.service.MusicService;
import teamMurange.Murange.service.UserService;

import java.util.List;

@Api(tags = { "Calendar Controller"})
@RestController
@RequiredArgsConstructor
public class CalendarController {

    private MusicService musicService;
    private LikeMusicService likeMusicService;
    private UserService userService;

    @ApiOperation(value = "감정 조회", notes = "사용자의 날짜별 감정 불러오기")
    @GetMapping("/date/{user-id}")
    public ResponseEntity getCalendar(@PathVariable(value = "user-id") Long userId) {
        List<Calendar> calendarList = userService.getCalendarList(userId);
        return new ResponseEntity(calendarList, HttpStatus.OK);
    }
}
