package teamMurange.Murange.domain;

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
}
