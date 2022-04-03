package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "enroll")
public class Enroll {

//    @ManyToOne
//    @JoinColumn(name = "playlist_id")
//    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @Builder
    public Enroll(Music music/*, Playlist playlist*/){
        this.music = music;
        // this.playlist = playlist;
    }

}
