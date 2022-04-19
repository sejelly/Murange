package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "top_daily")
public class TopDaily {

    private int rank;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music music;

    @Builder
    public TopDaily (Music music, int rank, LocalDate date) {
        this.date = date;
        this.music = music;
        this.rank = rank;
    }

}
