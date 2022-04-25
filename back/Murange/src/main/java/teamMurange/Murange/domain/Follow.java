package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "follow")
public class Follow {

    @Column(name = "follower")
    private Integer follower;

    @Id
    @Column(name = "follow_id")
    private Integer id; // follow하는, 받는 계정 user id와 img 가져올수 있도록 수정

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
