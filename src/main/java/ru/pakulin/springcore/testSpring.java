package ru.pakulin.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        //musicPlayer.playMusic(Genre.ELECTRONIC);
        System.out.println(musicPlayer.getName()+" ~ "+musicPlayer.getVolume());

        context.close();
    }
}
