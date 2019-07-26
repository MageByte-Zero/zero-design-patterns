package com.zero.design.actions.states.vote;

/**
 * 正常投票-具体状态类
 * Created by ljq97 on 2017/8/23.
 */
public class NormalVoteState implements IVoteState {
    @Override
    public void vote(String user, String voteItem, VoteManagerContext context) {
        //正常投票，记录到投票记录中
        context.getMapVote().put(user, voteItem);
        System.out.println("恭喜投票成功!");
    }
}
