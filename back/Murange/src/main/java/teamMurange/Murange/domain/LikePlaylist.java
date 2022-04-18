package teamMurange.Murange.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "like_playlist")
public class LikePlaylist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="like_playlist_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

}
