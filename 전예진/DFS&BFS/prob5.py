from collections import deque

def solution(rectangle,cx,cy,ix,iy):
    candy = set()
    for x,y,X,Y in rectangle:
        candy.update([(j+0.5, i) for j in range(y, Y) for i in (x, X)])
        candy.update([(j,i+0.5) for i in range(x, X) for j in (y, Y)])

    edge = set()
    for b,a in candy:
        for x,y,X,Y in rectangle:
            if x<a<X and y<b<Y:
                break
        else:
            edge.add((b,a))

    que,dy,dx = deque([(0, cy, cx)]), [.5,0,-.5,0], [0,.5,0,-.5]
    while que:
        cnt,b,a = que.popleft()
        if a==ix and b==iy:
            return cnt
        for i in range(4):
            if ((is_in_edge_y:=b+dy[i]), (is_in_edge_x:=a+dx[i])) in edge:
                edge.remove((is_in_edge_y, is_in_edge_x))
                que.append((cnt+1, b+2*dy[i], a+2*dx[i]))
