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
@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    private String name;

    private String img_url;

    private String email;

    private String picture;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @OneToMany(mappedBy = "user")
    private List<Playlist> likePlaylistList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlistList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Calendar> calendarList = new ArrayList<>();

//    @OneToMany(mappedBy = "user")
//    private List<Follow> followList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> commentlist = new ArrayList<>();

    @Builder
    public User(String name, String img_url, String email, String picture, Role role) {
        this.name = name;
        this.img_url = img_url;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }
}
