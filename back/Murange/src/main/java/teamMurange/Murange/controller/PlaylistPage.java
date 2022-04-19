package teamMurange.Murange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teamMurange.Murange.domain.Comment;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.dto.CommentRequestDto;
import teamMurange.Murange.repository.CommentRepository;
import teamMurange.Murange.service.CommentService;
import teamMurange.Murange.service.MusicService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaylistPage {

    private final CommentService commentService;
    private final MusicService musicService;

    // 플레이리스트의 음악 불러오기
    @GetMapping("/playlist/{playlist-id}")
    public ResponseEntity getMusic(@PathVariable(value = "playlist-id") Long playlistId) {
        List<Music> musicList = musicService.getMusicsByPlaylist(playlistId);
        return new ResponseEntity(musicList, HttpStatus.OK);
    }

    // 댓글 조회
    @GetMapping("/comments/{playlist-id}")
    public ResponseEntity getComments(@PathVariable(value = "playlist-id") Long playlistId) {
        List<Comment> commentList = commentService.getCommentList(playlistId);
        return new ResponseEntity(commentList, HttpStatus.OK);
    }

    // 댓글 입력
    @PostMapping("/comments")
    public ResponseEntity saveComment(@RequestBody @Validated CommentRequestDto commentRequestDto) {
        commentService.createComment(commentRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 수정
    @PatchMapping("/comments/{comments-id}")
    public ResponseEntity updateComment(
            @PathVariable(value = "comments-id") Long commentId ,
            @RequestBody @Validated CommentRequestDto comment) {
        commentService.updateComment(commentId, comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{comments-id}")
    public ResponseEntity deleteComment (@PathVariable(value = "comments-id") Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
