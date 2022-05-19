package teamMurange.Murange.IntegrationTest.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.QUser;
import teamMurange.Murange.domain.User;
import teamMurange.Murange.dto.CalendarResponseDto;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static teamMurange.Murange.domain.QCalendar.calendar;

@SpringBootTest
@Transactional
@Commit
class CalendarRepositoryTest {

    @Autowired
    EntityManager em;

    @DisplayName("유저의 마지막 감정 조회하기")
    @Test
    public void startQuerydsl2() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        Long userIdCond = 10L;

        CalendarResponseDto result = queryFactory
                .select(Projections.fields(CalendarResponseDto.class,
                        calendar.date,
                        calendar.firstEmotion,
                        calendar.secondEmotion))
                .from(calendar)
                .join(calendar.user, QUser.user)
                .where(userIdEq(userIdCond))
                .orderBy(calendar.date.desc())
                .fetchFirst();

    };

    private Predicate userIdEq(Long userIdCond) {
        return userIdCond != null ? QUser.user.id.eq(userIdCond) : null;
    }


}
