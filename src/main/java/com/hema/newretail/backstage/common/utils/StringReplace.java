package com.hema.newretail.backstage.common.utils;

/**
 * @author by hyw, Date on 2018-09-03.
 */
public class StringReplace {
    private String sString;
    private String tString;
    private int lenOfsS;
    private int lenOftS;
    private String lString;
    private String rString;
    private int lenOfrS;

    public StringReplace() {
    }

    public StringReplace(String sourceString, String targetString, String replaceString) {
        this.sString = sourceString;
        this.tString = targetString;
        this.rString = replaceString;
        this.lenOfsS = this.sString.length();
        this.lenOftS = this.tString.length();
        this.lenOfrS = this.rString.length();
    }

    public void setSourceString(String sourceString) {
        this.sString = sourceString;
        this.lenOfsS = this.sString.length();
    }

    public void setTargetString(String targetString) {
        this.tString = targetString;
        this.lenOfsS = this.tString.length();
    }

    public void setReplaceString(String replaceString) {
        this.rString = replaceString;
        this.lenOfrS = this.rString.length();
    }

    public String getReplaceString() {
        this.lString = this.sString;
        int len = this.lString.length();
        boolean matches = false;
        char rS = this.tString.charAt(0);
        //int j = false;

        for(int i = 0; i < len; ++i) {
            if (rS == this.lString.charAt(i) && i + this.lenOftS <= len) {
                matches = this.tString.regionMatches(0, this.lString, i, this.lenOftS);
                if (matches) {
                    String tempLeft = this.lString.substring(0, i);
                    this.lString.substring(i, i + this.lenOftS);
                    String tempMid = this.rString;
                    String tempRight = this.lString.substring(i + this.lenOftS, len);
                    this.lString = tempLeft + tempMid + tempRight;
                    i = i + this.lenOfrS - 1;
                    len = this.lString.length();
                }
            }
        }

        return this.lString;
    }

    public static String getReplaceString(String sourceString, String targetString, String replaceString) {
        String ttString = targetString;
        String rrString = replaceString;
        int lenOfsS = sourceString.length();
        int lenOftS = targetString.length();
        int lenOfrS = replaceString.length();
        if (lenOfsS > 0 && lenOftS > 0 && lenOfrS > 0) {
            String llString = sourceString;
            int len = sourceString.length();
            boolean matches = false;
            char rS = targetString.charAt(0);
           // int j = false;

            for(int i = 0; i < len; ++i) {
                if (rS == llString.charAt(i) && i + lenOftS <= len) {
                    matches = ttString.regionMatches(0, llString, i, lenOftS);
                    if (matches) {
                        String tempLeft = llString.substring(0, i);
                        llString.substring(i, i + lenOftS);
                        String tempRight = llString.substring(i + lenOftS, len);
                        llString = tempLeft + rrString + tempRight;
                        i = i + lenOfrS - 1;
                        len = llString.length();
                    }
                }
            }

            return llString;
        } else {
            return sourceString;
        }
    }
}
