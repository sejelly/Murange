package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String name;

    private String img_url;

    private String email;

    @OneToOne
    @JoinColumn(name = "id")
    private Badge badge;

    @OneToMany(mappedBy = "LikePlaylist")
    private List<LikePlaylist> likePlaylistList = new ArrayList<>();

    @OneToMany(mappedBy = "Playlist")
    private List<Playlist> playlistList = new ArrayList<>();

    @OneToMany(mappedBy = "Calendar")
    private List<Calendar> calendarList = new ArrayList<>();

    @OneToMany(mappedBy = "Follow")
    private List<Follow> followList = new ArrayList<>();

    @OneToMany(mappedBy = "Comment")
    private List<Comment> commentlist = new ArrayList<>();

    @Builder
    public User(String name, String img_url, String email) {
        this.name = name;
        this.img_url = img_url;
        this.email = email;
    }
}
