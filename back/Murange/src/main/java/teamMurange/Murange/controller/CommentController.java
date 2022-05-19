package teamMurange.Murange.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import teamMurange.Murange.domain.Comment;
import teamMurange.Murange.dto.CommentRequestDto;
import teamMurange.Murange.service.CommentService;
import teamMurange.Murange.service.MusicService;

import java.util.List;

@Api(tags = { "Recommendation Controller"})
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final MusicService musicService;

    @ApiOperation(value = "댓글 조회", notes = "댓글 조회하기")
    @GetMapping("/comments/{playlist-id}")
    public ResponseEntity getComments(@PathVariable(value = "playlist-id") Long playlistId) {
        List<Comment> commentList = commentService.getCommentList(playlistId);
        return new ResponseEntity(commentList, HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 등록", notes = "댓글 등록하기")
    @PostMapping("/comments")
    public ResponseEntity saveComment(@RequestBody @Validated CommentRequestDto commentRequestDto) {
        commentService.createComment(commentRequestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 수정", notes = "댓글 수정하기")
    @PatchMapping("/comments/{comments-id}")
    public ResponseEntity updateComment(
            @PathVariable(value = "comments-id") Long commentId ,
            @RequestBody @Validated CommentRequestDto comment) {
        commentService.updateComment(commentId, comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글 삭제하기")
    @DeleteMapping("/comments/{comments-id}")
    public ResponseEntity deleteComment (@PathVariable(value = "comments-id") Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
