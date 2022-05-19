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
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Emotion firstEmotion;

    @Enumerated(EnumType.STRING)
    private Emotion secondEmotion;

    @OneToMany(mappedBy = "category")
    private List<Music> musicList = new ArrayList<>();

    @Builder
    public Category(Long id, Emotion firstEmotion, Emotion secondEmotion) {
        this.id = id;
        this.firstEmotion = firstEmotion;
        this.secondEmotion = secondEmotion;
    }
}
