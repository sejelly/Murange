package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Table(name = "badge")
public class Badge {
    @Id
    @Column(name = "badge_id")
    private Integer badge_id;

    @Column(name = "likes")
    private Integer likes;

}
