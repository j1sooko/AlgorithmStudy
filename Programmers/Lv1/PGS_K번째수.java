import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] subArray = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            /*
            int[] subArray = new int[commands[i][1] - commands[i][0] + 1];
            int k = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                subArray[k++] = array[j];
            }
            */
            Arrays.sort(subArray);
            answer[i] = subArray[commands[i][2] - 1];
            
        }
        
        return answer;
    }
}
