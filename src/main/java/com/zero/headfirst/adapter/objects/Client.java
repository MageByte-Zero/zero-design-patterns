/**
 * Project: com-zero-design-stu
 * File created at 2019/6/24 19:54
 */
package com.zero.headfirst.adapter.objects;

/**
 * @author lijianqing
 * @version 1.0
 * @ClassName Client
 * @date 2019/6/24 19:54
 */
public class Client {
    public static void main(String[] args) {
        //被适配者 3.5毫米耳机
        CommonPhoneInterface headPhone = new CommonPhoneImpl();
        //适配器
        TypeC2HeadphoneAdapter typeC2HeadphoneAdapter = new TypeC2HeadphoneAdapter(headPhone);
        //通过适配器实现了听歌
        typeC2HeadphoneAdapter.listenMusic();
    }
}
