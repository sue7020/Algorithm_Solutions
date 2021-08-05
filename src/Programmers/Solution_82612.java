public class Programmers_82612 {

    // 부족한 금액 계산하기
    public static void main(String[] args) {
        solution(3,20,4);
    }

    public static long solution(int price, int money, int count) {
            long answer = 0;
            long totalPrice = 0;

            for(int i=1; i<=count; i++)
                totalPrice += (price * i);

            answer = money < totalPrice ? totalPrice - money : 0;
            System.out.println(answer);

            return answer;
        }
    }
