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

@Api(tags = { "Profile Controller"})
@RestController
@RequiredArgsConstructor
public class ProfilePage {
    
    @ApiOperation(value = "감정 조회", notes = "사용자의 날짜별 감정 불러오기")
    @GetMapping("/date/{user-id}")
    public ResponseEntity getCalendar(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "내 플레이리스트 조회", notes = "사용자가 만든 플레이리스트 불러오기")
    @GetMapping("/likes/my/{user-id}")
    public ResponseEntity getPli(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "좋아요한 플레이리스트 조회", notes = "사용자가 좋아요한 플레이리스트 불러오기")
    @GetMapping("/likes/playlist/{user-id}")
    public ResponseEntity getLikePli(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "좋아요한 노래 조회", notes = "사용자가 좋아요한 노래 불러오기")
    @GetMapping("/likes/music/{user-id}")
    public ResponseEntity getLikeMusic(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @ApiOperation(value = "팔로워 조회", notes = "내가 추가한 사용자 불러오기")
    @GetMapping("/likes/follow/{user-id}")
    public ResponseEntity getFollow(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
