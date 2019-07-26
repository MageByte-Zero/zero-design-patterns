package com.zero.design.actions.states.vote;

/**
 * Created by ljq97 on 2017/8/23.
 */
public class BlackVoteState implements IVoteState {

    /**
     * 黑名单:记录到黑名单中，禁止登陆系统
     * @param user     投票人
     * @param voteItem 投票项
     * @param context  投票上下文，用来在实现状态对应的功能处理的时候，
     */
    @Override
    public void vote(String user, String voteItem, VoteManagerContext context) {
        //添加到黑名单
        context.getBlackVoteSet().add(user);
        System.out.println("进入黑名单，将禁止登陆和使用本系统.");
    }
}
