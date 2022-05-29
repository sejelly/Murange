package teamMurange.Murange.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamMurange.Murange.domain.TopWeekly;
import teamMurange.Murange.repository.TopWeeklyRepository;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class TopWeeklyService {

    private final TopWeeklyRepository topWeeklyRepository;

    // 인기많은 순서대로 조회
    @Transactional(readOnly = true)
    public List<TopWeekly> getTopWeekly (Long category_id) {
        List<TopWeekly> topWeeklyList = topWeeklyRepository.findAll();
        return topWeeklyList;
    }

    // 조회수가 많아지면 TopWeekly 생성
}
