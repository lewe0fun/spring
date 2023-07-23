package ru.pakulin.springcore;

import java.util.List;

public class MusicPlayer {

    /*
     * Класс музыкального плеера
     */
    private List<Music> musicList;
    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    /*
     * @param music - зависимость извне
     */

/*    public MusicPlayer(Music music) {
        this.music = music;
    }*/

    //инверсия зависимостей

/*    public void setMusic(List<Music> music) {
        this.music = music;
    }*/

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        for(Music music:musicList)
            System.out.println(music.getSong());
    }
}
