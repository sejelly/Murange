package teamMurange.Murange.IntegrationTest.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.Category;
import teamMurange.Murange.domain.Emotion;
import teamMurange.Murange.domain.QUser;
import teamMurange.Murange.domain.User;
import teamMurange.Murange.dto.CalendarResponseDto;
import teamMurange.Murange.dto.MusicResponseDto;
import teamMurange.Murange.repository.CalendarRepository;
import teamMurange.Murange.repository.CategoryRepository;
import teamMurange.Murange.repository.MusicRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static teamMurange.Murange.domain.QCategory.category;

@SpringBootTest
@Transactional
@Commit
public class CategoryRepositoryTest {

    @Autowired
    EntityManager em;

    private MusicRepository musicRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    private CalendarRepository calendarRepository;


    @DisplayName("주감정 부감정으로 카테고리 id 조회하기")
    @Test
    public void startQuerydsl() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Emotion firstEmotion = Emotion.angry;
        Emotion secondEmotion = Emotion.sad;
        Long result = queryFactory
                .select(category.id)
                .from(category)
                .where(category.firstEmotion.eq(firstEmotion)
                        .and(category.secondEmotion.eq(secondEmotion)))
                .fetchOne();


    }
}
