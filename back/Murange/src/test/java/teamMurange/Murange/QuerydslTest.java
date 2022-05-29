package teamMurange.Murange;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.QUser;
import teamMurange.Murange.domain.User;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
public class QuerydslTest {

    @Autowired
    EntityManager em;

    @Test
    void sample() {
        User user = new User();
        em.persist(user);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QUser qUser = new QUser("U");

        User result = query
                .selectFrom(qUser)
                .fetchOne();

        assertThat(result).isEqualTo(user);
    }

    @Test
    public void startQuerydsl() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        User user = User.builder().name("user1").build();
        em.persist(user);

        //user1 찾아라.
        User findMember = queryFactory
                .select(QUser.user)
                .from(QUser.user)
                .where(QUser.user.name.eq("user1")) //파라미터 바인딩 처리
                .fetchOne();
        assertThat(findMember.getName()).isEqualTo("user1");
    }
}
