package teamMurange.Murange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectionPage {

    // 감정에 따른 음악 불러오기
    @GetMapping("/recommend/{category-id}")
    public ResponseEntity getComments(@PathVariable(value = "category-id") Long categoryId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 음악 좋아요 표시
    @PostMapping("/likes/{user-id}/{music-id}")
    public ResponseEntity likeMusic(@PathVariable(value = "user-id") Long userId,
                                    @PathVariable(value = "music-id") Long musicId) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
