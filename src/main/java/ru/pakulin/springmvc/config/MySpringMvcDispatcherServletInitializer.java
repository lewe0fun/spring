package ru.pakulin.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};//где находится спринг конфигурация
    }

    protected String[] getServletMappings() {
        return new String[]{"/"}; //все запросы от пользователя отправляем на диспетчекр сервлет
    }
}
