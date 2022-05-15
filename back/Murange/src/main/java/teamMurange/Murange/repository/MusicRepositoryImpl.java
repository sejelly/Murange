package teamMurange.Murange.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import teamMurange.Murange.domain.QCategory;
import teamMurange.Murange.dto.MusicResponseDto;

import java.util.List;

import static teamMurange.Murange.domain.QEnroll.enroll;
import static teamMurange.Murange.domain.QMusic.music;

public class MusicRepositoryImpl implements MusicRepositoryCustom {



    private final JPAQueryFactory queryFactory;

    public MusicRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<MusicResponseDto> searchMusicByEmotionCategory(Long categoryIdCond) {
        List<MusicResponseDto> result = queryFactory
                .select(Projections.fields(MusicResponseDto.class,
                        music.id,
                        music.title,
                        music.singer,
                        music.img_url,
                        music.streaming_cnt,
                        music.path))
                .from(music)
                .join(music.category, QCategory.category)
                .where(categoryIdEq(categoryIdCond))
                .orderBy(music.streaming_cnt.desc())
                .limit(50)
                .fetch();
        return result;
    }

    private Predicate categoryIdEq(Long categoryIdCond) {
        return categoryIdCond != null ? QCategory.category.id.eq(categoryIdCond) : null;

    };

    @Override
    public List<MusicResponseDto> searchMusicByPlaylist(Long playlistIdCond) {
        List<MusicResponseDto> result = queryFactory
                .select(Projections.fields(MusicResponseDto.class,
                        enroll.music.id,
                        enroll.music.title,
                        enroll.music.singer,
                        enroll.music.img_url,
                        enroll.music.streaming_cnt,
                        enroll.music.path
                        ))
                .from(enroll)
                .where(enroll.playlist.id.eq(playlistIdCond))
                .orderBy(music.streaming_cnt.desc())
                .limit(50)
                .fetch();
        return result;
    }
}
