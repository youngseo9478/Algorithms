package brute_force;

public class PrimeNumber {
	public static void main(String[] args) {

	}

	public int solution(String numbers) {
		int answer = 0;
		boolean[] prime = new boolean[1000000]; // ũ�⸦ ��� �����ؾ��ϳ�...
		for (int i = 0; i < prime.length; i++)
			prime[i] = true;
		prime[1] = false; // 1�� �Ҽ��� �ƴϹǷ�
		for (int i = 2; i < prime.length; i++) {
			if (prime[i]) {
				for (int j = i * 2; j < prime.length; j += i) { // i�� ����� ��� �Ÿ���
					prime[j] = false;
				}
			}
		} // �Ҽ��� true�� ���� boolean �迭 ���� �Ϸ�

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
		int arr[] = new int[10]; // int[s.length]�� �ƴ϶� 10��! 0~9����
		for (int i = 0; i < s.length(); i++) {
			// arr[i] = s.charAt(i)-'0'; ���ڷ� �ɰ��°� �ƴϰ�
			// �ش� ���ڰ� � �ִ°��� ī��Ʈ ���ϴ� ����
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
