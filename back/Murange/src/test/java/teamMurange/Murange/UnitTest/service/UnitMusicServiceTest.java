package teamMurange.Murange.UnitTest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import teamMurange.Murange.domain.Figure;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.repository.MusicRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UnitMusicServiceTest {

    @Mock
    private MusicRepository musicRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    private Figure getStubFigure() {
        Float surprised = 0.01F;
        Float neutral = 0.02F;
        Float angry = 0.03F;
        Float sad = 0.03F;
        Float happiness = 0.01F;
        Float disgust = 0.01F;
        Float scared = 0.01F;

        return Figure.builder()
                .surprised(surprised)
                .neutral(neutral)
                .happiness(happiness)
                .sad(sad)
                .scared(scared)
                .disgust(disgust)
                .angry(angry)
                .build();
    }

    private Music getStubMusic() {
        Long id = 1L;
        String singer = "가수이름";
        String title = "노래제목";
        Figure figure = getStubFigure();

        return Music.builder()
                .id(id)
                .singer(singer)
                .title(title)
                .figure(figure)
                .build();
    }

    private List<Music> getStubMusicList() {
        List<Music> musicList =  new ArrayList<>();
        Music music1 = Music.builder().id(1L).singer("bts").title("butter").build();
        Music music2 = Music.builder().id(2L).singer("10cm").title("americano").build();
        Music music3 = Music.builder().id(3L).singer("jason").title("I'm Yours").build();

        musicList.add(music1);
        musicList.add(music2);
        musicList.add(music3);

        return musicList;
    }

    @Test // 감정 분석 결과 & 메인페이지 감정별 추천
    public void 감정카테고리별_음악_조회 () throws Exception{
        // given
        when(musicRepository.findAllByCategoryId(any())).thenReturn(getStubMusicList());

        // when
        List<Music> musicList = musicRepository.findAllByCategoryId(any());

        // then
        assertEquals(musicList.size(), getStubMusicList().size());
        assertEquals(musicList.get(1).getSinger(), getStubMusicList().get(1).getSinger());
        System.out.println(musicList.get(1).getSinger());
        System.out.println(getStubMusicList().get(1).getSinger());
    }



    @Test
    public void 플레이리스트별_음악_조회 () throws Exception{
        // given

        // when

        // then

    }

    @Test
    public void 음악_기본정보_조회 () throws Exception{
        // given
        when(musicRepository.getById(any())).thenReturn(getStubMusic());

        // when
        Music music = musicRepository.getById(any());

        // then
        assertEquals(music.getSinger(), getStubMusic().getSinger());
        assertEquals(music.getTitle(), getStubMusic().getTitle());
    }


    @Test
    public void 음악_감정수치_조회 () throws Exception{
        // given
        when(musicRepository.getById(any())).thenReturn(getStubMusic());

        // when
        Music music = musicRepository.getById(any());
        Figure figure = music.getFigure();

        // then
        assertEquals(figure.getHappiness(), getStubFigure().getHappiness());
        assertEquals(figure.getAngry(), getStubFigure().getAngry());
        // assertEquals(resultFigure, getStubFigure());
    }

    @Test
    public void 음악_감정수치_업데이트 () throws Exception{
        // given
        String first_emotion = "happiness";
        String second_emotion = "sad";
        Float first_emotion_figure = 0.09F;
        Float second_emotion_figure = 0.09F;

        when(musicRepository.getById(any())).thenReturn(getStubMusic());

        // when
        Music music = musicRepository.getById(any());
        Figure figure = music.getFigure();
        
        System.out.println(figure.getHappiness());

        figure.updateFigure(first_emotion, first_emotion_figure);
        figure.updateFigure(second_emotion, second_emotion_figure);
        music.updateFigure(figure);

        // then
        assertEquals(figure.getHappiness(), first_emotion_figure);
        System.out.println(figure.getHappiness());

    }




}
