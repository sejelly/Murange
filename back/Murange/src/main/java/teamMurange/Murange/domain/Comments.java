package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comments {
    @Id
    @Column(name = "comments_id")
    private Long comments_id;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "contents")
    private String contents;


}
