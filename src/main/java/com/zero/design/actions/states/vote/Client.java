package com.zero.design.actions.states.vote;

/**
 * 客户端
 * Created by ljq97 on 2017/8/23.
 */
public class Client {
    public static void main(String[] args) {
        VoteManagerContext context = new VoteManagerContext();
        for(int i = 0; i < 20; i++) {
            context.vote("王老吉", "A");
        }
    }

}
