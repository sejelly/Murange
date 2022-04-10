package teamMurange.Murange.UnitTest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import teamMurange.Murange.domain.Music;
import teamMurange.Murange.domain.TopDaily;
import teamMurange.Murange.repository.TopDailyRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UnitTopDailyServiceTest {

    @Mock
    private TopDailyRepository topDailyRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    private List<TopDaily> getStubTopDailyList() {
        List<TopDaily> topDailyList =  new ArrayList<>();

        Music music1 = Music.builder().id(1L).singer("bts").title("butter").build();
        Music music2 = Music.builder().id(2L).singer("10cm").title("americano").build();
        Music music3 = Music.builder().id(3L).singer("jason").title("I'm Yours").build();

        TopDaily topDaily1 = TopDaily.builder().music(music1).rank(0).build();
        TopDaily topDaily2 = TopDaily.builder().music(music2).rank(1).build();
        TopDaily topDaily3 = TopDaily.builder().music(music3).rank(2).build();

        topDailyList.add(topDaily1);
        topDailyList.add(topDaily2);
        topDailyList.add(topDaily3);

        return topDailyList;
    }

    @Test
    public void 오늘의_인기음악_조회 () throws Exception {
        // given
        when(topDailyRepository.findAllOrderByRank()).thenReturn(getStubTopDailyList());

        // when
        List<TopDaily> topDailyList = topDailyRepository.findAllOrderByRank();

        Music music1 = Music.builder().id(1L).singer("bts").title("butter").build();
        Music music2 = Music.builder().id(2L).singer("10cm").title("americano").build();
        Music music3 = Music.builder().id(3L).singer("jason").title("I'm Yours").build();

        TopDaily topDaily1 = TopDaily.builder().music(music1).rank(0).build();
        TopDaily topDaily2 = TopDaily.builder().music(music2).rank(1).build();
        TopDaily topDaily3 = TopDaily.builder().music(music3).rank(2).build();

        // then
        assertEquals(topDailyList.size(), getStubTopDailyList().size());
        assertEquals(topDaily1.getRank(), getStubTopDailyList().get(0).getRank());
        System.out.println(topDaily1.getRank());
        System.out.println(getStubTopDailyList().get(0).getRank());
    }

}
