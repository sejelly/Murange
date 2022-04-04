package teamMurange.Murange.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaylistPage {

    // 플레이리스트의 음악 불러오기
    @GetMapping("/playlist/{playlist-id}")
    public ResponseEntity getMusic(@PathVariable(value = "playlist-id") Long playlistId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 조회
    @GetMapping("/comments/{playlist-id}")
    public ResponseEntity getComments(@PathVariable(value = "playlist-id") Long playlistId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 입력
    @PostMapping("/comments")
    public ResponseEntity saveComment(/* @RequestBody @Validated CommentsRequestDto comment*/) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 수정
    @PatchMapping("/comments/{comments-id}")
    public ResponseEntity updateComment(
            @PathVariable(value = "comments-id") Long commentId /*,
            @RequestBody @Validated CommentsRequestDto comment*/) {
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{comments-id}")
    public ResponseEntity deleteComment (@PathVariable(value = "comments-id") Long commentId) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
