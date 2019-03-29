package com.wjw.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _最多价值 {
	static Map<Integer, Integer> map = new HashMap<>();

	static class Task {
		// 当前任务选了最优解
		int max;
		// 任务的id
		int id;
		// 任务的价值
		int price;
		// 任务开始时间
		int btime;
		// 任务结束时间
		int etime;
		String path;

		public Task(int id, int price, int btime, int etime) {
			this.id = id;
			this.price = price;
			this.btime = btime;
			this.etime = etime;
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", price=" + price + ", btime=" + btime + ", etime=" + etime + ", path=" + path
					+ "]";
		}

	}

	public static void main(String[] args) {
		// 任务列表
		List<Task> tasks = new LinkedList<>();
		tasks.add(new Task(1, 5, 1, 4));
		tasks.add(new Task(2, 1, 3, 5));
		tasks.add(new Task(3, 8, 0, 6));
		tasks.add(new Task(4, 4, 4, 7));
		tasks.add(new Task(5, 6, 3, 8));
		tasks.add(new Task(6, 3, 5, 9));
		tasks.add(new Task(7, 2, 6, 10));
		tasks.add(new Task(8, 4, 8, 11));
		f(tasks);

	}

	private static void f(List<Task> tasks) {
		int i = 0;
		// 遍历任务
		while (i < tasks.size()) {
			Task task = tasks.get(i);
			// 选
			Task ifTask = ifTask(task, tasks, i);
			// 不选找出上一个
			Integer noTask = map.get(i - 1);
			if (noTask == null) {
				// 路径为自己
				task.path = task.id + " ";
				map.put(i, ifTask.price);
			} else {

				// 找出最大的那一个
				if (ifTask.max > noTask) {
					task.path = ifTask.path + " " + task.id + " ";
					map.put(i, ifTask.max);
				} else {
					task.path = tasks.get(i-1).path + " ";
					map.put(i, noTask);
				}
			}
			i++;
		}

		System.out.println(map);
		System.out.println(tasks);

	}

	private static Task ifTask(Task task, List<Task> tasks, int i) {
		int min = Integer.MAX_VALUE;
		// 获取当前任务相近的值
		for (int j = 0; j < i; j++) {
			int time = task.btime - tasks.get(j).etime;
			// 保存时间不冲突的最小值
			if (time >= 0 && time < min)
				min = time;
		}

		List<Task> list = new ArrayList<>();
		for (int j = 0; j < i; j++) {
			int time = task.btime - tasks.get(j).etime;
			// 保存任务的最小不冲突链表
			if (time >= 0 && time == min)
				list.add(tasks.get(j));
		}

		if (list.size() == 0)
		{
			// 如果前面没有结果
			task.max=task.price;
			return task;
		}
		// 记录最大
		int max = 0;
		Task mat = null;
		for (Task t : list) {
			int price = map.get(t.id-1) + task.price;
			if (price > max) {
				mat = t;
				max = price;
				mat.max = max;
			}
		}
		return mat;
	}

}
