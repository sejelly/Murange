package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "top_daily")
public class TopDaily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="top_daily_id")
    private Long id;

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
