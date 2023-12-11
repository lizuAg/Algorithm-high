//[프로그래머스] 디스크 컨트롤러(https://school.programmers.co.kr/learn/courses/30/lessons/42627)

import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] jobs) {
        int time = 0, sumWaitDuration = 0;
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Arrays.sort(jobs, Comparator.comparingInt(arr -> arr[0]));
        
        int i = 0;
        while(true){
            for(; i<jobs.length; i++){
                if(jobs[i][0] <= time)
                    pq.add(new Process(jobs[i][0], jobs[i][1]));
                else break;
            }
            
            if(!pq.isEmpty()){
                Process current = pq.poll();
                sumWaitDuration += current.getWaitDuration(time);
                time += current.duration;
            }else {
                if(i < jobs.length)
                    time = jobs[i][0]; // 작업이 없으면 다음 작업 도착 시간으로 이동
                else
                    break;
            }
        }
        //모든 작업 종료 시간 + 각 작업 별 대기 시간 - 실제 작업이 시작되기까지의 시간
        return (time + sumWaitDuration - jobs[0][0])/jobs.length;
    }
}

class Process implements Comparable<Process> {
    int requestTime, duration;
    
    public Process(int requestTime, int duration) {
        this.requestTime = requestTime;
        this.duration = duration;
    }
    
    public int getWaitDuration(int time){
        return time - requestTime;
    }
    
    @Override
    public int compareTo(Process other) {
        return duration - other.duration;
    }
}
