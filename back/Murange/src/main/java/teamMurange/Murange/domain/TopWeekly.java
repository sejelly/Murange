package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "top_weekly")
public class TopWeekly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="top_weekly_id")
    private Long id;

    private int rank;

    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "music_id")
    private Music music;
}
