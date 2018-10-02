package hash;

import java.util.Arrays;

public class Marathon {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "leo", "kiki" };
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length - 1];
	}
}
