package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name="user_id")
    private Long id;

    private String name;

    private String img_url;

    private String email;

    @OneToOne
    @JoinColumn(name = "id")
    private Badge badge;

    @OneToMany(mappedBy = "LikePli")
    private List<LikePli> likeplis = new ArrayList<>();

    @OneToMany(mappedBy = "Pli")
    private List<Pli> plis = new ArrayList<>();

    @OneToMany(mappedBy = "Calendar")
    private List<Calendar> calendars = new ArrayList<>();

    @OneToMany(mappedBy = "Follow")
    private List<Follow> follows = new ArrayList<>();

    @OneToMany(mappedBy = "Comments")
    private List<Comments> commentslist = new ArrayList<>();
}
