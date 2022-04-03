package teamMurange.Murange.domain;

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

    @OneToMany(mappedBy = "LikeMusic")
    private List<LikeMusic> likeMusics = new ArrayList<>();

    @OneToMany(mappedBy = "Enroll")
    private List<Enroll> enrolls = new ArrayList<>();

}
