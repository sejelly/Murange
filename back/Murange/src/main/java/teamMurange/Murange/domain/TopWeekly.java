package teamMurange.Murange.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "top_weekly")
public class TopWeekly {
    private int rank;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music music;
}
