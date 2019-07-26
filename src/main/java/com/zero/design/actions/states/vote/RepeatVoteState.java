package com.zero.design.actions.states.vote;

/**
 * Created by ljq97 on 2017/8/23.
 */
public class RepeatVoteState implements IVoteState {
    @Override
    public void vote(String user, String voteItem, VoteManagerContext context) {
        //重复投票,暂时不作处理
        System.out.println("请不要重复投票!");
    }
}
