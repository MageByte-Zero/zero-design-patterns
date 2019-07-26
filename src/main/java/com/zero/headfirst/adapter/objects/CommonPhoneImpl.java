/**
 * Project: com-zero-design-stu
 * File created at 2019/6/24 19:50
 */
package com.zero.headfirst.adapter.objects;

/**
 * 普通3.5mm耳机 [Adaptee - 待适配者]
 * @author lijianqing
 * @version 1.0
 * @ClassName HeadPhone
 * @date 2019/6/24 19:50
 */
public class CommonPhoneImpl implements CommonPhoneInterface {
    @Override
    public void listenMusic() {
        System.out.println("标准手机 3.5 mm 耳机接口听歌");
    }

}
