package ru.pakulin.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

/*        Music music = context.getBean("rockMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);*/
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic();


        //Music testBean = context.getBean("MusicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(testBean);
/*        ClassicalMusic classicalMusic = context.getBean("MusicBeanClassic", ClassicalMusic.class);
        System.out.println(classicalMusic.getSong());

        RockMusic rockMusic = context.getBean("MusicBeanRock", RockMusic.class);
        System.out.println(rockMusic.getSong());

        ElectronicMusic electronicMusic =context.getBean("MusicBeanElectronic", ElectronicMusic.class);
        System.out.println(electronicMusic.getSong());*/
        /*
         *Dependency injection
         */

//        MusicPlayer musicPlayer = context.getBean("MusicPlayer", MusicPlayer.class);
//
//        musicPlayer.playMusic();

        //System.out.println(musicPlayer.getName()+"\n"+musicPlayer.getVolume());
        context.close();
    }
}
