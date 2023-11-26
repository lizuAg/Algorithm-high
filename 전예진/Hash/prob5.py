def solution(genres, plays):
    answer = []
    
    lst = []
    for i in range(len(genres)):
        lst.append([i, genres[i], plays[i]]) # index, genres, plays 순서대로 리스트에 넣기
    
    lst.sort(key=lambda x : (x[1], -x[2], x[0]))

    dic = {}
    for i in range(len(genres)):
        if genres[i] in dic:
            dic[genres[i]] += plays[i]
        else:
            dic[genres[i]] = plays[i]
    
    sorted_dic = sorted(dic.items(), key=lambda x : -x[1])

    for d in sorted_dic:
        count = 0
        for l in lst:
            if l[1] == d[0]:
                count += 1
                if count > 2:
                    break
                else:
                    answer.append(l[0])


    return answer
