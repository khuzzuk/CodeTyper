package com.epam.coder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeText {
    private String code;
    private int currentPosition;
    public void loadText(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CodeText.class.getResourceAsStream("/javaText")))){
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine())!=null){
                builder.append(line);
                builder.append("\n");
            }
            code = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return code.substring(0,currentPosition);
    }
    public String getNextText(){
        currentPosition+=4;
        return getText();
    }

    public String getPreviousText() {
        currentPosition = Math.max(0,currentPosition-4);
        return getText();
    }
}
