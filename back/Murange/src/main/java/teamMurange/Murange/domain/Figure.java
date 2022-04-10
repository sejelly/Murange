package teamMurange.Murange.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Figure {

    private float happiness;

    private float sad;

    private float angry;

    private float neutral;

    private float surprised;

    private float disgust;

    private float scared;

    // 평균내서 업데이트할 예정, 일단은 변경하는 로직으로 구현(테스트용)
    public void updateFigure(String updateEmotion, float updateFigure) {
        
        switch (updateEmotion) {
            case "happiness":
                this.happiness = updateFigure;
            case "sad":
                this.sad = updateFigure;
            case "angry":
                this.sad = updateFigure;
            case "neutral":
                this.sad = updateFigure;
            case "disgust":
                this.sad = updateFigure;
            case "surprised":
                this.sad = updateFigure;
            case "scared":
                this.sad = updateFigure;
        }
    }


    @Builder
    public Figure (float happiness, float sad, float angry,float neutral, float surprised, float disgust, float scared) {
        this.happiness = happiness;
        this.sad = sad;
        this.angry = angry;
        this.neutral = neutral;
        this.surprised = surprised;
        this.disgust = disgust;
        this.scared = scared;
    }

}
