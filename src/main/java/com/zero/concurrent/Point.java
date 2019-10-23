package com.zero.concurrent;

import java.util.concurrent.locks.StampedLock;

class Point {
    // 共享变量 x、y 坐标
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * 移动坐标
     *
     * @param deltaX
     * @param deltaY
     */
    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 计算到原点的距离
     *
     * @return
     */
    public double distanceFromOrigin() {
        //乐观读
        long stamp = sl.tryOptimisticRead();
        // 读取共享数据到局部变量
        double currentX = x, currentY = y;
        //读操作期间是否存在写操作，若存在则升级为悲观读锁，并重新读取共享变量
        if (!sl.validate(stamp)) {
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                //释放悲观读
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    /**
     * 若当前坐标在原点则移动
     *
     * @param newX
     * @param newY
     */
    public void moveIfAtOrigin(double newX, double newY) {
        // 不能直接使用乐观读，不是只读的方法
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                //升级为写锁，若返回值不等于 0 则获取写锁成功
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    // 转换写锁失败则先释放读锁，再获取写锁
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }
}
