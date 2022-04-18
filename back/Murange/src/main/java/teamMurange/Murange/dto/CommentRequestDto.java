package teamMurange.Murange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private String contents;

    private Long user_id;
    private Long playlist_id;
}
