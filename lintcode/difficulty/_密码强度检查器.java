package lintcode.difficulty;

public class _密码强度检查器 {

	public int strongPasswordChecker(String s) {
		// write your code here
		char[] cs = s.toCharArray();
		if (cs.length == 0) {
			return 6;
		}

		// 0 数字 1 大写 2 小写 3 连续
		int[] value = new int[4];
		int length = cs.length;
		for (int i = 0; i < length; i++) {
			if (cs[i] >= '0' && cs[i] <= '9') {
				value[0]++;
			}

			if (cs[i] >= 'A' && cs[i] <= 'Z') {
				value[1]++;
			}

			if (cs[i] >= 'a' && cs[i] <= 'z') {
				value[2]++;
			}

			if (i < length - 2 && cs[i] == cs[i + 1] && cs[i] == cs[i + 2]) {
				value[3]++;
			}
		}
		// 缺少的
		int shortInt = 0;
		for (int i = 0; i < value.length - 1; i++) {
			if (value[i] == 0) {
				shortInt++;
			}
		}

		if (length < 6) {
			return 6 - length > shortInt ? 6 - length : shortInt;
		}

		if (length > 20) {
			// 如果 减去重复的小于二十
			if (length - value[3] <= 20) {
				// 如果重复的大于
				return value[3] > shortInt ? value[3] : shortInt;
			}
			return length - 20 + shortInt;
		}

		return value[3] >= shortInt?value[3]:shortInt;
	}

}
