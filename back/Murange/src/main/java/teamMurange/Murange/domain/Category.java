package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "category")
    private List<Music> musicList = new ArrayList<>();
}
