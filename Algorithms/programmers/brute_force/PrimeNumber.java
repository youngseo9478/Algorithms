package brute_force;

public class PrimeNumber {
	public static void main(String[] args) {

	}

	public int solution(String numbers) {
		int answer = 0;
		boolean[] prime = new boolean[1000000]; // 크기를 어떻게 설정해야하나...
		for (int i = 0; i < prime.length; i++)
			prime[i] = true;
		prime[1] = false; // 1은 소수가 아니므로
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < prime.length; j += i) { // i의 배수는 모두 거르기
					prime[j] = false;
				}
			}
		} // 소수만 true값 가진 boolean 배열 생성 완료

		int[] nArr = toNumberArray(numbers);
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				int[] pArr = toNumberArray(Integer.toString(i));
				if (isPossible(nArr, pArr)) {
					answer++;
				}
			}
		}
		return answer;
	}

	int[] toNumberArray(String s) {
		int arr[] = new int[10]; // int[s.length]가 아니라 10개! 0~9까지
		for (int i = 0; i < s.length(); i++) {
			// arr[i] = s.charAt(i)-'0'; 숫자로 쪼개는게 아니고
			// 해당 숫자가 몇개 있는가를 카운트 업하는 것임
			arr[s.charAt(i) - '0']++;
		}
		return arr;
	}

	boolean isPossible(int[] nArr, int[] pArr) {
		for (int i = 0; i < 10; i++) {
			if (nArr[i] < pArr[i]) {
				return false;
			}
		}
		return true;
	}
}
