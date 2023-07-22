package ru.pakulin.springcore;

public class MusicPlayer {

    /*
     * Класс музыкального плеера
     */
    private Music music;
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

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println(music.getSong());
    }
}
