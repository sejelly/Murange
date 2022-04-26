package teamMurange.Murange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamMurange.Murange.domain.LikePlaylist;

@Repository
public interface LikePlaylistRepository extends JpaRepository<LikePlaylist, Long> {

}
