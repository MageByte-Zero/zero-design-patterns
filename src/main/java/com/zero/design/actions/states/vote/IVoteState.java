package com.zero.design.actions.states.vote;

/**
 * 抽象状态类
 * Created by ljq97 on 2017/8/23.
 */
public interface IVoteState {

    /**
     * 处理状态对应的逻辑
     *
     * @param user     投票人
     * @param voteItem 投票项
     * @param context  投票上下文，用来在实现状态对应的功能处理的时候，
     *                 可以回调上下文的数据
     */
    void vote(String user, String voteItem, VoteManagerContext context);
}
