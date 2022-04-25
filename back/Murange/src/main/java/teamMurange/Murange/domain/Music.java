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
@Table(name = "music")
public class Music {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="music_id")
    private Long id;

    private String title;

    private String singer;

    private String img_url;

    private String path;

    private int streaming_cnt;

    @Embedded
    private Figure figure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "music")
    private List<LikeMusic> likeMusicList = new ArrayList<>();

    @OneToMany(mappedBy = "music")
    private List<Enroll> enrollList = new ArrayList<>();

    public void updateFigure(Figure figure) {
        Figure.builder()
                .angry(figure.getAngry())
                .disgust(figure.getDisgust())
                .happiness(figure.getHappiness())
                .sad(figure.getSad())
                .neutral(figure.getNeutral())
                .scared(figure.getScared())
                .surprised(figure.getSurprised())
                .build();
        this.figure = figure;
    }

    // 테스트용 음악 생성 빌더
    @Builder
    public Music(Long id, String title, String img_url, String singer, Figure figure, int streaming_cnt, Category category, Playlist playlist) {
        this.figure = figure;
        this.id = id;
        this.img_url = img_url;
        this.title = title;
        this.singer = singer;
        this.category = category;
        this.streaming_cnt = streaming_cnt;
    }
    
}
