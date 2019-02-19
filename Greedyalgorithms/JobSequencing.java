
import java.util.ArrayList;
//This is my own implementation of job sequencing program
//appears to be working correctly
import java.util.Arrays;
import java.util.List;

class Job implements Comparable<Job> {
       @Override
       public String toString() {
             return "Job [id=" + id + ", profit=" + profit + ", deadline=" + deadline + "]";
       }

       char id;
       int profit;
       int deadline;

       public Job(char id, int deadline, int profit) {
             super();
             this.id = id;
             this.profit = profit;
             this.deadline = deadline;
       }

       public char getId() {
             return id;
       }

       public int getProfit() {
             return profit;
       }

       public int getDeadline() {
             return deadline;
       }

       @Override
       public int compareTo(Job o) {
             // TODO Auto-generated method stub
             return o.profit - this.profit;
       }

}

public class JobSequencing {
       static List<Character> findSequence(Job[] jobs,int k) {
             Character[] ch = new Character[k];
             Arrays.fill(ch,'/');
             for (int i=0; i < jobs.length;i++) {
                    int l = jobs[i].getDeadline();
                    System.out.println("Getting the deadline of the job "+l);
                    if (ch[l-1]=='/') {
                          ch[l-1]= jobs[i].getId();
                          continue;
                          
                    }
                    int index= 0;
                    while(index == l-2) {
                          if (ch[index]=='/') {
                                 ch[index] = jobs[i].getId();
                                 break;
                                 
                          }
                          index++;
                    }
                    
             }
             
             List<Character> n =  new ArrayList(Arrays.asList(ch));
             System.out.println(n);
             for(int i = 0; i < n.size();i++){
            	    if(n.get(i).equals('/')){
            	        n.remove(i--);
            	    }
            	}
             System.out.println(n);
             return n;
             
       }
       static int findMaxDeadline(Job[] jobs) {
             int max = 0;
             for (int i=0; i < jobs.length;i++) {
                    if (jobs[i].getDeadline() > max)
                          max = jobs[i].getDeadline();
                    
             }
             return max;
       }
       public static void main(String[] args) {
             Job[] jobs = new Job[5];

             jobs[0] = new Job('a', 2, 100);
             jobs[1] = new Job('b', 1, 19);
             jobs[2] = new Job('c', 2, 27);
             jobs[3] = new Job('d', 1, 25);
             jobs[4] = new Job('e', 3, 15);
             
             Arrays.sort(jobs);
             System.out.println(Arrays.toString(jobs));
             int k = findMaxDeadline(jobs);
             findSequence(jobs, k);
             
             System.out.println(k);
             
             
             
       }

}

