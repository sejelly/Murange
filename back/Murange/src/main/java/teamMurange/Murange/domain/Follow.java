package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "follow")
public class Follow {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="follow_id") // 그냥 테이블 번호
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user") // 사용자 본인
    private User user;

    @Column(name = "followee_email") // 팔로우하려는 인물
    private String followee_email;

    //@JoinColumn
    //private User user;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn
    //private User followee;

    @Builder
    public Follow (User user1, String user2_email) {
        this.user = user1;
        this.followee_email = user2_email;
    }

}
