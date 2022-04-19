package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Emotion first_emotion;

    @Enumerated(EnumType.STRING)
    private Emotion second_emotion;

    @OneToMany(mappedBy = "Music")
    private List<Music> musicList = new ArrayList<>();
}
