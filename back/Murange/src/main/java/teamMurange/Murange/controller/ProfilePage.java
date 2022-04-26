package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamMurange.Murange.domain.Follow;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.domain.Playlist;
import teamMurange.Murange.service.UserService;

import java.util.List;

@Api(tags = { "Profile Controller"})
@RestController
@RequiredArgsConstructor
public class ProfilePage {
    
    @ApiOperation(value = "감정 조회", notes = "사용자의 날짜별 감정 불러오기")
    @GetMapping("/date/{user-id}")
    public ResponseEntity getCalendar(@PathVariable(value = "user-id") Long userId) {
        List<Calendar> calendarList = UserService.getCalendarList(userId);
        return new ResponseEntity(calendarList, HttpStatus.OK);
    }

    @ApiOperation(value = "내 플레이리스트 조회", notes = "사용자가 만든 플레이리스트 불러오기")
    @GetMapping("/likes/my/{user-id}")
    public ResponseEntity getMyPlaylist(@PathVariable(value = "user-id") Long userId) {
        List<Playlist> myPlaylistList = UserService.getMyPlaylistList(userId);
        return new ResponseEntity(myPlaylistList, HttpStatus.OK);
    }

    @ApiOperation(value = "좋아요한 플레이리스트 조회", notes = "사용자가 좋아요한 플레이리스트 불러오기")
    @GetMapping("/likes/playlist/{user-id}")
    public ResponseEntity getLikePlaylist(@PathVariable(value = "user-id") Long userId) {
        List<Playlist> likePlaylistList = UserService.getLikePlaylistList(userId);
        return new ResponseEntity(likePlaylistList, HttpStatus.OK);
    }

    @ApiOperation(value = "좋아요한 노래 조회", notes = "사용자가 좋아요한 노래 불러오기")
    @GetMapping("/likes/music/{user-id}")
    public ResponseEntity getLikeMusic(@PathVariable(value = "user-id") Long userId) {
        List<Music> likeMusicList = UserService.getLikeMusicList(userId);
        return new ResponseEntity(likeMusicList, HttpStatus.OK);
    }
    
    @ApiOperation(value = "팔로워 조회", notes = "내가 추가한 사용자 불러오기")
    @GetMapping("/likes/follow/{user-id}")
    public ResponseEntity getFollow(@PathVariable(value = "user-id") Long userId) {
        List<Follow> followerList = userService.getFollowerList(userId);
        return new ResponseEntity(followerList, HttpStatus.OK);
    }

    @ApiOperation(value = "팔로워 삭제", notes = "사용자 팔로우 끊기")
    @DeleteMapping("/likes follow/{follow-id}")
    public ResponseEntity deleteFollow (@PathVariable(value = "follow-id") Long followId) {
        userService.deleteFollow(followId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
