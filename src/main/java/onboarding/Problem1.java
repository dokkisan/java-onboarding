package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }

        int pobiResult = findMaxNum(pobi);
        int crongResult = findMaxNum(crong);

        if (pobiResult > crongResult) {
            answer = 1;
        } else if (pobiResult < crongResult) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static int findMaxNum(List<Integer> input) {
        int maxNum = 0;

        for (int i = 0; i < input.size(); i++) {
            String[] num = String.valueOf(input.get(i)).split("");
            int sum = 0;
            int mutiply = 1;
            for (int j = 0; j < num.length; j++) {
                sum += Integer.parseInt(num[j]);
                mutiply *= Integer.parseInt(num[j]);
            }

            maxNum = Math.max(Math.max(sum, mutiply), maxNum);
        }

        return maxNum;
    }

    public static boolean checkError(List<Integer> input) {
        if ((input.get(0) + 1) == input.get(1)) {
            return false;
        }
        return true;
    }
}