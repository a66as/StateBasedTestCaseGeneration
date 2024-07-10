package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizerUtil {

    /**
     * This method takes a multi-line string, tokenizes it on "@Test", goes to the next line
     * after each "@Test" token, and removes "{" from that line.
     *
     * @param input The multi-line string to be processed.
     * @return A list of strings where "{" has been removed from lines following "@Test".
     */
    public List<String> processString(String input) {
        List<String> result = new ArrayList<>();
        String[] lines = input.split("\n");

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("@Test")) {
                if (i + 1 < lines.length) {
                    // Remove "{" from the next line
                    String str=lines[i + 1].replace("{", "").trim();
                    String[] tokens=str.split("\\(");
                    tokens=tokens[0].split(" ");
                    str= tokens[tokens.length-1];
                    System.out.println(str);
                    result.add(str);
                }
            }
        }

        return result;
    }


}