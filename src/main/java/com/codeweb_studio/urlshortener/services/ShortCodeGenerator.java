package com.codeweb_studio.urlshortener.services;

import org.springframework.stereotype.Service;
import java.util.Random;

/**
 * Generates short Url Strings
 */

@Service
public class ShortCodeGenerator {

    public static final int SHORT_CODE_LENGTH = 8;

    public String generateShortCode(){
        String SALTCHARS = "AGABACJKASCBSKJCBSJCBSKJBCKJSACBCKJASBC1231321231CSAVHCVAJHVSHVCHJSCVAHVAHCSVA";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < SHORT_CODE_LENGTH){
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }
}
