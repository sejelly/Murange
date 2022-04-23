package teamMurange.Murange.controller;

import javazoom.jl.player.advanced.AdvancedPlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Mp3PlayerController {

    private AdvancedPlayer player;

    public static void main(String[] args) {

        String file="C:\\Users\\suyou\\Desktop\\Winter Bear ⓒmonoRM912.mp3";
        mp3PlayerSample mp3 = new mp3PlayerSample(file);

        mp3.play();
        // mp3.stop();

    }

    // 음악 재생
    @GetMapping("/play/{music-id}")
    public ResponseEntity playMusic(@PathVariable(value = "music-id") Long musicId) {

        return new ResponseEntity(HttpStatus.OK);

    }

    // 음악 일시 멈춤
    @GetMapping("/play/pause/{music-id}")
    public ResponseEntity pauseMusic(@PathVariable(value = "music-id") Long musicId) {

        return new ResponseEntity(HttpStatus.OK);

    }

    // 음악 정지
    @GetMapping("/play/stop/{music-id}")
    public ResponseEntity stopMusic(@PathVariable(value = "music-id") Long musicId) {

        return new ResponseEntity(HttpStatus.OK);

    }

}
