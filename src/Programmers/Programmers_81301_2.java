public class Programmers_81301_2 {
    public static void main(String[] args) {
        int answer = 0;

        String s = "23four5six7";

        String[] alphabets =
                {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<alphabets.length; i++) {
            s = s.replaceAll(alphabets[i], String.valueOf(i));
        }

        answer = Integer.parseInt(s);
        System.out.println(answer);
    }
}
