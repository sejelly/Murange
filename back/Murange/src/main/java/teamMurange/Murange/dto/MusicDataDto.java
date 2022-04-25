package teamMurange.Murange.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import teamMurange.Murange.domain.Music;

@Getter
@NoArgsConstructor
public class MusicDataDto {

    private String title;

    private String singer;

    private String img_url;

    private int streaming_cnt;

    public MusicDataDto(Music music) {
        this.title = music.getTitle();
        this.singer = music.getSinger();
        this.img_url = music.getImg_url();
        this.streaming_cnt = music.getStreaming_cnt();
    }

}
