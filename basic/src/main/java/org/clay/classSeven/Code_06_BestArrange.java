package org.clay.classSeven;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最多可以开多少场宣讲会
 * 1. 按照最先开始的时间贪心，错误：可能一开开一天
 * 2. 按照最短时间贪心，错误：可能一个时间短的宣讲在两个时间稍长的宣讲的中间。
 *
 * 正确的贪心策略：哪个项目结束的早，然后淘汰掉因为这个项目而不能做的其他项目。
 */
public class Code_06_BestArrange {
    /**
     * 项目宣讲实体
     */
	public static class Program {
		public int start;//开始时间
		public int end;//结束时间

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

    /**
     * @param programs  总共的项目宣讲
     * @param cur 当前时间
     * @return
     */
	public static int bestArrange(Program[] programs, int cur) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (cur <= programs[i].start) {
				result++;
				cur = programs[i].end;//当前时间置为选择的项目的结束时间，也就是淘汰掉因为这个项目而不能做的其他项目
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
