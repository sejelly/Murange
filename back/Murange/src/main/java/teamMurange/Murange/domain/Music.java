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

    @Id @GeneratedValue
    @Column(name="music_id")
    private Long id;

    private String title;

    private String singer;

    private String img_url;

    private int streaming_cnt;

    @Embedded
    private Figure figure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "playlist_id")
//    private Playlist playlist;

    @OneToMany(mappedBy = "LikeMusic")
    private List<LikeMusic> likeMusics = new ArrayList<>();

    @OneToMany(mappedBy = "Enroll")
    private List<Enroll> enrolls = new ArrayList<>();

    // figure 업데이트하기
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
    public Music(Long id, String title, String singer, Figure figure, int streaming_cnt, Category category) {
        this.figure = figure;
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.category = category;
        this.streaming_cnt = streaming_cnt;
    }
    
}
