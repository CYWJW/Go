package com.wjw.lintcode.middling;

public class _打劫房屋 {

	public long houseRobber(int[] A) {
		// write your code here
		if (A.length == 0) {
			return 0;
		}
		long nowStep = 0, befStep = 0;

		for (int value : A) {
			long step = nowStep;
			nowStep = Math.max(nowStep, befStep + value);
			befStep = step;
		}
		
		return nowStep;
	}
}
