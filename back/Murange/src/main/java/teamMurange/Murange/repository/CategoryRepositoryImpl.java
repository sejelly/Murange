package teamMurange.Murange.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import teamMurange.Murange.domain.Emotion;

import static teamMurange.Murange.domain.QCategory.category;

public class CategoryRepositoryImpl implements CategoryRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CategoryRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Long searchCategoryId(Emotion firstEmotion, Emotion secondEmotion) {
        Long result = queryFactory
                .select(category.id)
                .from(category)
                .where(category.first_emotion.eq(firstEmotion)
                .and(category.second_emotion.eq(secondEmotion)))
                .fetchOne();
        return result;
    };

}
