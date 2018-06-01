/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author CeachiBogdan
 */
public class AnalizeMessage {
    public static List<String> tokens;
    public static String MESSAGE_TYPE;
    
     public static  void breakMessage(String message) {
        StringTokenizer st = new StringTokenizer(message);
        tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            tokens.add(token);
        }
        MESSAGE_TYPE = tokens.get(0);   
    }
}
