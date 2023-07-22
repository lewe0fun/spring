package ru.pakulin.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        //Music testBean = context.getBean("MusicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(testBean);

        /*
         *Dependency injection
         */

        MusicPlayer musicPlayer = context.getBean("MusicPlayer", MusicPlayer.class);

        musicPlayer.playMusic();
        System.out.println(musicPlayer.getName()+"\n"+musicPlayer.getVolume());
        context.close();
    }
}
