package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.dto.MusicResponseDto;
import teamMurange.Murange.service.MusicService;

import java.util.List;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class PlaylistController {

    private final MusicService musicService;

    @ApiOperation(value = "플레이리스트별 음악 조회", notes = "플레이리스트의 음악 불러오기")
    @GetMapping("/playlist/{playlist-id}")
    public ResponseEntity getMusic(@PathVariable(value = "playlist-id") Long playlistId) {
        List<MusicResponseDto> musicList = musicService.getMusicsByPlaylist(playlistId);
        return new ResponseEntity(musicList, HttpStatus.OK);
    }
}
