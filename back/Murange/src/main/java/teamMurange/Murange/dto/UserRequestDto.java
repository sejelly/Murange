package teamMurange.Murange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserRequestDto {

    private Long user_id;
    private String name;
    private String img_url;
    private String email;
    private Badge badge;

    private List<Playlist> likePlaylistList;
    private List<Calendar> calendarList;
    private List<Follow> followList;
}
