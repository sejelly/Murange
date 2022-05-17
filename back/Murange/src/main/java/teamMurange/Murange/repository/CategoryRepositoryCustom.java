package teamMurange.Murange.repository;

import teamMurange.Murange.domain.Emotion;

public interface CategoryRepositoryCustom {

    Long searchCategoryId (Emotion firstEmotion, Emotion secondEmotion);

}
