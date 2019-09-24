#!/usr/bin/python3
# -*- coding: utf-8 -*-


class Soution:
    def game(self, guess: [int], answer: [int]) -> int:
        l1 = 1 if guess[0] == answer[0] else 0
        l2 = 1 if guess[1] == answer[1] else 0
        l3 = 1 if guess[2] == answer[2] else 0
        return l1+l2+l3
    def fraction(self, cont: [int]) -> [int]:
        a = 1
        b = 1
        if len(cont) == 1:
            return [cont[0], 1]
        for i in range(len(cont)-1, 0, -1):
            a = a*(cont[i]*cont[i-1]+1)
            b = b*cont[i]
            c = a
            a = b
            b = c
        if b == 0:return None
        if a% b == 0: return [a//b,1]
        else:
            m = min(a, b)
            ret = 1
            for i in range(1, m//2):
                if a % i == 0 and b % i == 0:
                    ret *= i
            return ret




    def robot(self, command: str, obstacles: [[int]], x: int, y: int) -> bool:
        x1 = 0
        y1 = 0
        count = 0
        strLen = len(command)
        keys = dict()
        for i in obstacles:
            if len(i) == 2:
                if i[0] >= x and i[1] >= y:
                    pass
                else:
                    keys[str(i[0])+str(i[1])] = True
        if strLen == 0:return False
        while True:
            cc = command[count]
            if cc == 'R':
                x1 += 1
            elif cc == 'U':
                y1 += 1
            if x == x1 and y == y1:
                return True
            elif x1 > x or y1 > y:
                return False
            count += 1
            if count == strLen:
                count = 0
            if keys.get(str(x1) + str(y1)):
                return False



index = Soution().fraction([0,0,3])
print(index)