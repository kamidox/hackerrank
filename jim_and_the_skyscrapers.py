# -*- coding: utf-8 -*-


def valid_path(a, i, j):
    """
    :param a: array of the height of the building
    :param i: start index
    :param j: end index
    :return: 1 if it's a valid path, 0 on invalid path
    """
    if a[i] != a[j]:
        return 0
    for k in range(i, j):
        if a[k] > a[i]:
            return 0

    return 1


def meet_constraints(a):
    """
    1 <= N <= 3 * 10 ^ 5 and no skyscraper will have height greater than 10 ^ 6 and lesser than 1.
    :param a: array of the height of the building
    :return: True if we met the constraints
    """
    if len(a) < 1 or len(a) > 3 * pow(10, 5):
        return False
    for aa in a:
        if aa < 1 or aa > pow(10, 6):
            return False
    return True


def valid_path_count(a):
    """
    :param a: array of the height of building
    :return: the valid path count
    """
    count = 0
    n = len(a)
    for i in range(n):
        for j in range(i+1, n):
            count += valid_path(a, i, j)
    return count * 2


def valid_path_count_v2(a):
    """
    :param a: array of the height of building
    :return: the valid path count
    """
    N = len(a)
    S = []
    dic = {}
    i = 0
    count = 0
    while i < N:
        if len(S) == 0 or a[S[-1]] > a[i]:
            S.append(i)
            if a[i] not in dic:
                dic[a[i]] = 0
            dic[a[i]] += 1
        elif a[S[-1]] == a[i]:
            if a[i] not in dic:
                dic[a[i]] = 0
            count += dic[a[i]]
            dic[a[i]] += 1
            S.append(i)
        elif a[S[-1]] < a[i]:
            q = S.pop()
            dic[a[q]] -= 1
            i -= 1
        i += 1
    return count * 2

if __name__ == '__main__':
    path_count = 0
    num = input()
    arr = [int(v) for v in raw_input().split()]
    if num == len(arr) and meet_constraints(arr):
        path_count = valid_path_count_v2(arr)
    print(path_count)
