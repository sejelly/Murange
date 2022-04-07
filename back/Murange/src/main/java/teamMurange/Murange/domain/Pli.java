package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "pli")
public class Pli {

    @Id @GeneratedValue
    @Column(name="pli_id")
    private Long id;

    private String title;

    private String img_url;


    @Embedded
    private Figure figure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "LikePli")
    private List<LikePli> likePli = new ArrayList<>();


}
