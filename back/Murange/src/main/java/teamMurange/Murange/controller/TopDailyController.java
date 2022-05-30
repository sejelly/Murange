package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.dto.MusicResponseDto;
import teamMurange.Murange.service.MusicService;
import teamMurange.Murange.service.TopDailyService;
import teamMurange.Murange.service.TopWeeklyService;

import java.util.List;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class TopDailyController {

    private final MusicService musicService;
    private final TopWeeklyService topWeeklyService;
    private final TopDailyService topDailyService;

    @ApiOperation(value = "자정마다 topDaily, topWeekly 변경", notes = "매일 자정마다 topDaily, topWeekly 업데이트")
    @Scheduled(cron = "0 0 0 * * *")
    public ResponseEntity updateTopDaily() {
        topDailyService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "일간 인기 음악 추천", notes = "메인 화면에서의 음악 추천")
    @GetMapping("/recommend/today")
    public ResponseEntity getTopDaily() {
        List<MusicResponseDto> musicList = topDailyService.getTopDailyAll();
        return new ResponseEntity(musicList, HttpStatus.OK);
    }
}
