package com.zero.headfirst.adapter.clazz;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        SpeakTarget speakTarget = new SpeakAdapter();
        speakTarget.speakChinese();
        speakTarget.speakEnglish();
        speakTarget.speakFrench();
    }
}
