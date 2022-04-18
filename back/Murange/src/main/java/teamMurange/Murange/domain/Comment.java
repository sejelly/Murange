package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;


@Getter
@NoArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private LocalDate created_at;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public void updateComment(String newContents, LocalDate newDate) {
        this.contents = newContents;
        this.created_at = newDate;
    }

    // 테스트용으로 빌더에 id 추가
    @Builder
    public Comment(Long id, LocalDate created_at, String contents, User userComment, Playlist playlistComment) {
        this.contents = contents;
        this.created_at = created_at;
        this.user = userComment;
        this.playlist = playlistComment;
    }

}
