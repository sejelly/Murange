package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Table(name = "follow")
public class Follow {

    @Column(name = "follower")
    private Integer follower;

    @Column(name = "followee")
    private Integer followee; // follow하는, 받는 계정 user id와 img 가져올수 있도록 수정

}
