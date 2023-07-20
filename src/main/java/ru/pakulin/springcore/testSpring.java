package ru.pakulin.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Music testBean = context.getBean("MusicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(testBean);

        musicPlayer.playMusic();
    }
}
