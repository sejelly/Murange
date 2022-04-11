package teamMurange.Murange.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@Table(name = "calendar")
public class Calendar {
    @Id
    @Column(name = "calendar_id")
    private Long calendar_id;

    @Column(name = "date")
    private Date date;


}
