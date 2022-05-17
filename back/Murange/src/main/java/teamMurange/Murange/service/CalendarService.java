package teamMurange.Murange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.Comment;
import teamMurange.Murange.dto.CalendarResponseDto;
import teamMurange.Murange.dto.CommentRequestDto;
import teamMurange.Murange.repository.CalendarRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;

    // 사용자의 마지막 감정 기록 조회
    @Transactional(readOnly = true)
    public CalendarResponseDto findUserCalendar(Long userId) {
        CalendarResponseDto result =calendarRepository.searchUserEmotion(userId);
        return result;
    }


}
