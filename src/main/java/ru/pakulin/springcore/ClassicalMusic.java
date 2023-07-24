package ru.pakulin.springcore;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music{
    public void doMyInit(){
        System.out.println("initialization");
    }
    public void doMyDestroy(){
        System.out.println("destruction");
    }
    @Override
    public String[] getSong() {
        return new String[]{"Щелкунчик","опера попера","шмель"};
    }
}
