import java.util.PriorityQueue;

public class Lab8P4 {
    int Jesses_cookies(int[] cookies, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        int mixes = 0;
        for(int i : cookies){ // Add the Cookies to the jar
            priorityQueue.add(i);
        }
        while(priorityQueue.peek() <= k){
            if(priorityQueue.size() < 2) return -1;
            int mixedCookie = priorityQueue.poll() + 2*priorityQueue.poll();
            mixes++;
            priorityQueue.add(mixedCookie);
        }
        return mixes;
    }

    public static void main(String[] args) {
        Lab8P4 lab = new Lab8P4();
        int[] testArray = {1,2,3};
        System.out.println(lab.Jesses_cookies(testArray,4));
    }
}
