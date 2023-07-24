package ru.pakulin.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class MusicPlayer {

    /*
     * Класс музыкального плеера
     */

    private Music music1;
    private Music music2;
    private Music music3;
    private Random random;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2, @Qualifier("electronicMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3=music3;
        this.random=new Random();
    }

    public void playMusic(Genre genre) {
/*        String song1=music1.getSong()[random.nextInt(2)];
        String song2=music2.getSong()[random.nextInt(2)];*/
        String song = null;
        switch (genre){
            case ROCK -> song=getRandomSong(music1);
            case CLASSICAL -> song=getRandomSong(music2);
            case ELECTRONIC -> song=getRandomSong(music3);
        }

        System.out.println("трек: " + song);
    }
    public String getRandomSong(Music music){
        return music.getSong()[random.nextInt(3)];
    }
}
