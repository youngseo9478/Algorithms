package sort;

import java.util.Arrays;

public class NumberOfK {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(solution(array, commands).toString());
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] cut = new int[commands[i][1] - commands[i][0] + 1];
			for (int k = 0; k < cut.length; k++) {
				cut[k] = array[commands[i][0] - 1 + k];
			}
			Arrays.sort(cut);
			answer[i] = cut[commands[i][2] - 1];
		}

		return answer;
	}
}
