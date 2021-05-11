package Programmers;

import java.util.*;

// 2019 KAKAO BLIND RECRUITMENT
// 후보키
public class Solution_42890 {

    public static List<String> keyCandidates;

    public static void main(String[] args) {
        String[][] relation = {
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}};

        System.out.println(solution(relation));
    }

    public static int solution(String[][] relation) {
        int answer = 0;

        // 후보키 후보
        keyCandidates = new ArrayList<>();

        boolean[] visited = new boolean[relation[0].length];

        // 1. 유일성이 맞는 후보키 도출
        for(int i=1; i<=relation[0].length; i++)
            comb(visited, 0, relation[0].length, i, relation);

        // 2. 최소성 원칙 적용
        isMinimal(keyCandidates);

        for (String keyCandidate : keyCandidates)
            if (!keyCandidate.equals(""))
                answer++;

        return answer;
    }

    // 키 조합 구하기
    static void comb(boolean[] visited, int depth, int n, int r, String[][] relation) {
        if(r == 0) {
            // 키 조합이 유일성을 만족시키는지 확인
            IsUnique(visited, relation);
            return;
        }
        if(depth == n) {
            return;
        } else {
            visited[depth] = true;
            comb(visited, depth + 1, n, r - 1, relation);

            visited[depth] = false;
            comb(visited, depth + 1, n, r, relation);
        }
    }

    // 키조합이 유일성을 만족시키는지 확인한다.
    static void IsUnique(boolean[] colCombinations, String[][] relation) {

        Set<String> colSet = new HashSet<>();

        // colCombinations에 대응하는 colum값들을 모두 더해 unique한지 확인한다.
        for (String[] strings : relation) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < strings.length; j++) {
                if (colCombinations[j])
                    temp.append(strings[j]);
            }
            colSet.add(temp.toString());
        }

        StringBuilder keys = new StringBuilder();

        if(colSet.size() == relation.length) { // unique 하다면
            for(int k=0; k<colCombinations.length; k++) // column조합을 String으로 append해준다 (ex. col1 col2 --> "12")
               if(colCombinations[k])
                   keys.append(k);

            keyCandidates.add(keys.toString());
        }
    }

    // 최소성을 만족시키는지 확인한다.
    public static void isMinimal(List<String> keyCnadidates) {
        List<Integer> removeIndx = new ArrayList<>(); // 최소성을 만족하지 않는 column 조합

        for(int i=0; i<keyCnadidates.size(); i++)
        {
            String keyCombination = keyCnadidates.get(i);

            for(int j=i+1; j<keyCnadidates.size(); j++) {
                boolean remove = true;
                for (int k = 0; k < keyCombination.length(); k++) {
                    if (!keyCnadidates.get(j).contains(String.valueOf(keyCombination.charAt(k)))) {
                        remove = false;
                        break;
                    }
                }

                if (remove && !removeIndx.contains(j))
                    removeIndx.add(j);
            }
        }

        for (Integer indx : removeIndx) keyCnadidates.set(indx, "");
    }
}
