package com.wjw.lintcode.middling;

public class _最多有多少个点在一条直线上 {

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
		Point[] points = new Point[] { new Point(-4, -4), new Point(-8, -582), new Point(-3, 3), new Point(-9, -651),
				new Point(9, 591)};
		int maxPoints = maxPoints(points);
		System.out.println(maxPoints);
	}

	public static int maxPoints(Point[] points) {
		// write your code here
		if (points == null || points.length == 0) {
			return 0;
		}
		int result = 1;
		// Set<Double> allRecord = new HashSet<Double>();
		for (int i = 0; i < points.length; i++) {
			int count = 0;
			double k = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (j == i + 1) {
					k = getK(points[j], points[i]);
					count = 2;
					continue;
				}

				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					count++;
					continue;
				}
				double curK = getK(points[j], points[i]);
				if (curK == k) {
					count++;
				}

				/*
				 * if (allRecord.contains(k)) { continue flag; }
				 */
			}
			result = Math.max(result, count);
			// allRecord.add(k);
		}
		return result;
	}

	static double getK(Point j, Point i) {
		double k = 0;
		if (j.x == i.x) {
			k = (double) Integer.MAX_VALUE;
		} else {
			k = (double) (j.y - i.y) / (double) (j.x - i.x);
		}
		return k;
	}

}
