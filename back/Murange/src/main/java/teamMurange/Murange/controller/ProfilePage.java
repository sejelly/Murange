package teamMurange.Murange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilePage {

    // 날짜별 감정 불러오기
    @GetMapping("/date/{user-id}")
    public ResponseEntity getCalendar(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 내가 만든 플레이리스트 불러오기
    @GetMapping("/likes/my/{user-id}")
    public ResponseEntity getPli(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 좋아요한 플레이리스트 불러오기
    @GetMapping("/likes/playlist/{user-id}")
    public ResponseEntity getLikePli(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 좋아요한 노래 불러오기
    @GetMapping("/likes/music/{user-id}")
    public ResponseEntity getLikeMusic(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // follower, followee 불러오기
    @GetMapping("/likes/follow/{user-id}")
    public ResponseEntity getFollow(@PathVariable(value = "user-id") Long userId) {
        return new ResponseEntity(HttpStatus.OK);
    }

}
