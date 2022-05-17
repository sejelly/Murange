package teamMurange.Murange.repository;

import teamMurange.Murange.dto.CalendarResponseDto;

public interface CalendarRepositoryCustom {

    CalendarResponseDto searchUserEmotion (Long userIdCond);
}
