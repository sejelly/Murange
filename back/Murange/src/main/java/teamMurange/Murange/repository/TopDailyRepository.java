package teamMurange.Murange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamMurange.Murange.domain.TopDaily;

import java.util.List;

@Repository
public interface TopDailyRepository extends JpaRepository<TopDaily, Long> {

    // 인기있는 순서대로 조회
    List<TopDaily> findAll();
}
