package com.motos.moto01.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    private MessageSource messageSource;
    
    @Autowired
    public MessageUtil(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource(){
        return messageSource;
    }

    public String getMessage(String message, Object[] objects, Locale locale ){
        return getMessageSource().getMessage(message, objects, locale);
    }
}
