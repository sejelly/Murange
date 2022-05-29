package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.domain.LikePlaylist;
import teamMurange.Murange.service.LikeMusicService;
import teamMurange.Murange.service.MusicService;
import teamMurange.Murange.service.UserService;

import java.util.List;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class LikePlaylistController {

    private MusicService musicService;
    private LikeMusicService likeMusicService;
    private UserService userService;

    @ApiOperation(value = "좋아요한 플레이리스트 조회", notes = "사용자가 좋아요한 플레이리스트 불러오기")
    @GetMapping("/likes/playlist/{user-id}")
    public ResponseEntity getLikePlaylist(@PathVariable(value = "user-id") Long userId) {
        List<LikePlaylist> likePlaylistList = userService.getLikePlaylistList(userId);
        return new ResponseEntity(likePlaylistList, HttpStatus.OK);
    }

}
