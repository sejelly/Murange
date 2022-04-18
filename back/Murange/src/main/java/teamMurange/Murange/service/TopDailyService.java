package teamMurange.Murange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.TopDaily;
import teamMurange.Murange.repository.TopDailyRepository;

import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class TopDailyService {

    private final TopDailyRepository topDailyRepository;

    // 인기많은 순서대로 조회
    @Transactional(readOnly = true)
    public List<TopDaily> getTopDaily (Long category_id) {
        List<TopDaily> topDailyList = topDailyRepository.findAllOrderByRank();
        return topDailyList;
    }

    // 조회수가 많아지면 TopDaily 생성

}
