package lotto;

import java.util.Arrays;

public class Lotto {
	int[] lotto = new int[6];	// 로또는 6개의 수자로 구성됨
	//로또가 완성되면 값을 출력
	public int[] getLotto() {
		return lotto;
	}
	//로또 추첨기
	public void setLotto() {		// 파라미터를 지우는 이유는 랜덤 숫자 발생
		// 배열 요소의 초기화 방법
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = 0;
		}
		int randomNum = 0;
		for (int i = 0; i < lotto.length; i++) {
			randomNum = (int) ((Math.random()*45)+1);
			boolean exist = false;	//아래의 forloop 을 제어하기 때문에 outer forloop 밖에 초기화 하면 안된다.
			for (int j = 0; j < lotto.length; j++) {
				if (randomNum == lotto[j]) {	// 중복 회피
					exist = true;					break;
				}
			}
			if (exist) {
				i--;	// 회전수를 줄여라 6회-> 5회
				continue;	// 회전수를 줄인 후 다시 for loop 을 돌아라
			} else {
				lotto[i] = randomNum;
			}
		}
		// 이 구역을 나왔다는 것은 6개의 숫자가 다 중복없이 추출되었다는 의미
		// 그래서 오름차순으로 숫자값들을 정렬하라
		Arrays.sort(lotto);
	}
}
