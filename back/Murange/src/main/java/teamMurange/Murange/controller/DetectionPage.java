package teamMurange.Murange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.repository.MusicRepository;
import teamMurange.Murange.service.LikeMusicService;
import teamMurange.Murange.service.MusicService;

import java.util.List;

@RestController
public class DetectionPage {

    private MusicService musicService;
    private LikeMusicService likeMusicService;

    // 감정 category-id에 따른 음악 불러오기
    @GetMapping("/recommend/{category-id}")
    public ResponseEntity getComments(@PathVariable(value = "category-id") Long categoryId) {
        List<Music> musicList = musicService.getMusicsByCategory(categoryId);
        // 좋아요 순서대로 -> DB 수정 필요
        return new ResponseEntity(musicList, HttpStatus.OK);
    }

    // 음악 좋아요 저장
    @PostMapping("/likes/{user-id}/{music-id}")
    public ResponseEntity createLikeMusic(@PathVariable(value = "user-id") Long userId,
                                    @PathVariable(value = "music-id") Long musicId) {
        likeMusicService.createLikeMusic(userId, musicId);
        return new ResponseEntity(HttpStatus.OK);
    }

    // 음악 좋아요 취소
    @PostMapping("/likes/{like-music-id}")
    public ResponseEntity deleteLikeMusic(@PathVariable(value = "like-music-id") Long likeMusicId) {
        likeMusicService.deleteLikes(likeMusicId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
