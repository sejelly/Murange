package teamMurange.Murange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamMurange.Murange.domain.LikeMusic;

@Repository
public interface LikeMusicRepository extends JpaRepository<LikeMusic, Long> {

}
