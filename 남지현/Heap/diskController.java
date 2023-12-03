import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> queue = new PriorityQueue<>();
        Arrays.sort(jobs, (job1, job2) -> job1[0]-job2[0]);
        List<Job> completedJobs = new ArrayList<>();
        int now = 0;
        int index = 0;
        int count = 0;
        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= now) {
                int[] jobInfo = jobs[index++];
                queue.add(new Job(jobInfo[0], jobInfo[1]));
            }
            if (!queue.isEmpty()) {
                Job job = queue.poll();
                job.startJob(now);
                now += job.processTime;
                completedJobs.add(job);
                count++;
            } else{
                now++;
            }
        }

        int sum = completedJobs.stream().mapToInt(Job::calculateCompletion).sum();
        return sum/count;
    }
    
    class Job implements Comparable<Job>{
        int requestTime;
        int processTime;
        int startTime;

        Job(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
            this.startTime = -1;
        }
        
        public void startJob(int time) {
            this.startTime = time;
        }

        public int calculateCompletion() {
            return startTime + processTime - requestTime;
        }

        public int compareTo(Job job) {
            return this.processTime - job.processTime;
        }
    }

}
