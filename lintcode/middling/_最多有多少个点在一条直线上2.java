package com.wjw.lintcode.middling;

import java.util.HashMap;

import com.wjw.lintcode.middling._最多有多少个点在一条直线上.Point;
public class _最多有多少个点在一条直线上2 {

	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		int[] a=new int[] {1,2,2};
		Point[] points = new Point[] {new Point(-4, -4), new Point(-8, -582), new Point(-3, 3), new Point(-9, -651),
				new Point(9, 591) };
		int maxPoints = maxPoints(points);
		System.out.println(maxPoints);
	}

	public static int maxPoints(Point[] points) {
		// write your code here
		if (points == null || points.length == 0) {
			return 0;
		}
		int result = 1;
		HashMap<Double, Integer> record = new HashMap<Double, Integer>();
		for (int i = 0; i < points.length; i++) {
			int same = 0;
			record.clear();
			record.put((double) Integer.MIN_VALUE, 1);
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					same++;
					continue;
				}
				double k = 0;
				if (points[j].x == points[i].x) {
					k = (double) Integer.MAX_VALUE;
				} else {
					k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
				}
				if (record.containsKey(k)) {
					record.put(k, record.get(k) + 1);
				} else {
					record.put(k, 2);
				}
			}
			for (int count : record.values()) {
				if (count + same > result) {
					result = count + same;
				}
			}
		}
		return result;
	}

}
