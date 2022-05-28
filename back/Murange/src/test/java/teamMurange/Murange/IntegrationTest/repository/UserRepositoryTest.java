package teamMurange.Murange.IntegrationTest.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.QUser;
import teamMurange.Murange.domain.User;
import teamMurange.Murange.dto.CalendarResponseDto;
import teamMurange.Murange.repository.UserRepository;

import javax.persistence.EntityManager;

import static teamMurange.Murange.domain.QCalendar.calendar;

@SpringBootTest
@Transactional
@Commit
public class UserRepositoryTest {
    @Autowired
    EntityManager em;
    @Autowired
    UserRepository userRepository;


    @Test
    public void start() {
        User user = User.builder().name("wang").email("22@gmail.com").build();
        userRepository.save(user);

    };
}
