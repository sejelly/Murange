package teamMurange.Murange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamMurange.Murange.domain.Music;

import java.util.List;
@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    // category_id로 music 찾기
    List<Music> findAllByCategoryId(Long category_id);

    // playlist_id로 music 찾기
    // List<Music> findAllByPlaylistId(Long playlist_id);
}


