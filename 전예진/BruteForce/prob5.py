from itertools import permutations

def solution(k, dungeons):
    all_dungeons = list(permutations(dungeons, len(dungeons)))

    max_cnt = 0

    for dungeon_order in all_dungeons:
        current_stamina = k
        current_dungeon_cnt = 0

        for dungeon in dungeon_order:
            min_required_stamina = dungeon[0]
            consumption_stamina = dungeon[1]

            if current_stamina >= min_required_stamina:
                current_stamina -= consumption_stamina
                current_dungeon_cnt += 1
            else:
                break

        max_cnt = max(max_cnt, current_dungeon_cnt)

    return max_cnt
