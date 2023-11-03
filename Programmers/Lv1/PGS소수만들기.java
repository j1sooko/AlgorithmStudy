class Solution {
    static int cnt;
    public int solution(int[] nums) {
        int answer = -1;
        boolean[] visited = new boolean[nums.length];
        cnt = 0;
        combine(nums, visited, 3, 0, 0);
        answer = cnt;
        return answer;
    }
    
    // 백트래킹
    public void combine(int[] nums, boolean[] visited, int k, int idx, int sum) {
        if (k == 0) {
            System.out.println("sum " + sum);
            if (isPrime(sum)) {
                cnt++;
            }
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum += nums[i];
                combine(nums, visited, k - 1, i + 1, sum);
                visited[i] = false;
                sum -= nums[i];
            }

        }
            
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) 
                return false;
        }
        return true;
    }
}
