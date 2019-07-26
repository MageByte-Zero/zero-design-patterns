package com.zero.headfirst.adapter.clazz;

public class SpeakAdapter extends EnglishSpeaker implements SpeakTarget {

    public SpeakAdapter() {
    }

    @Override
    public void speakChinese() {
        System.out.println("通过适配器，将英语转化为中文：我可以说中文");
    }

    @Override
    public void speakFrench() {
        System.out.println("通过适配器，将英语转化为法语：我可以说法语了");
    }

    @Override
    public void speakEnglish() {
        super.speakEnglish();
    }
}
