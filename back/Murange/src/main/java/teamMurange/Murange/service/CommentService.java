package teamMurange.Murange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.Comment;
import teamMurange.Murange.domain.Playlist;
import teamMurange.Murange.domain.User;
import teamMurange.Murange.dto.CommentRequestDto;
import teamMurange.Murange.repository.CommentRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    // 댓글 조회 (playlist_id로)
    @Transactional(readOnly = true)
    public List<Comment> getCommentList(Long playlist_id) {
        List<Comment> commentList = commentRepository.findAllByPlaylistOrderByCreatedAtDesc(playlist_id);
        return commentList;
    }

    // 댓글 입력
    public void createComment(CommentRequestDto commentRequestDto) {
        // User user = usersRepository.getById(commentRequestDto.getUser_id());
        // Playlist playlist = playlistRepository.getById(commentRequestDto.getPlaylist_id());
        String newContent = commentRequestDto.getContents();

        LocalDate date = LocalDate.now();

        Comment comment = Comment.builder().contents(newContent).created_at(date)
                /*.userComment(user).playlistComment(playlist)*/.build();
        commentRepository.save(comment);
    }

    // 댓글 수정
    public void updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        String newContent = commentRequestDto.getContents();
        LocalDate date = LocalDate.now();

        Comment comment = commentRepository.getById(commentId);
        comment.updateComment(newContent, date);
    }


    // 댓글 삭제
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
