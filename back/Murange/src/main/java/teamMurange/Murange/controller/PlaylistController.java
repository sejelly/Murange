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
import teamMurange.Murange.domain.LikePlaylist;
import teamMurange.Murange.domain.Playlist;
import teamMurange.Murange.dto.MusicResponseDto;
import teamMurange.Murange.service.LikeMusicService;
import teamMurange.Murange.service.MusicService;
import teamMurange.Murange.service.UserService;

import java.util.List;

@Api(tags = { "Playlist Controller"})
@RestController
@RequiredArgsConstructor
public class PlaylistController {

    private MusicService musicService;
    private LikeMusicService likeMusicService;
    private UserService userService;


    @ApiOperation(value = "내 플레이리스트 조회", notes = "사용자가 만든 플레이리스트 불러오기")
    @GetMapping("/likes/my/{user-id}")
    public ResponseEntity getMyPlaylist(@PathVariable(value = "user-id") Long userId) {
        List<Playlist> myPlaylistList = userService.getMyPlaylistList(userId);
        return new ResponseEntity(myPlaylistList, HttpStatus.OK);
    }

}
