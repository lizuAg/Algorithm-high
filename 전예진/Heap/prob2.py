import heapq

def solution(jobs):
    answer = 0      # 평균 작업 소요시간
    start_time = 0  # 현재 시간
    heap = [] 
    total_jobs = len(jobs)  # 작업의 총 개수

    jobs.sort()  # 작업 요청 시점을 기준으로 정렬

    while jobs or heap:
        while jobs and jobs[0][0] <= start_time:
            # 현재 시간 기준으로 요청된 작업을 모두 우선순위 큐에 추가
            request_time, processing_time = jobs.pop(0)
            heapq.heappush(heap, (processing_time, request_time))

        if heap:
            # 우선순위 큐에서 가장 빨리 끝나는 작업 선택
            processing_time, request_time = heapq.heappop(heap)
            start_time += processing_time
            answer += (start_time - request_time)
        else:
            # 우선순위 큐가 비어있으면 다음으로 빨리 요청된 작업까지 시간 이동
            start_time = jobs[0][0]

    return answer // total_jobs
