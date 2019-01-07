# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import random
done = False

while(done == False):
    def main():
        m = selectNum()
        k = guess()
        outcome(m, k)
        print("Secret number: ", m)
        
    def selectNum():
        n = random.randint(1,10)
        return n
        
    def guess():
        p = int(input("Guess a number from 1 to 10: "))
        while(p<1 or p>10):
            p = int(input("Guess a number from 1 to 10: "))
        return p
    
    def outcome(x, y):
        if(y==x):
            print("Lucky guess")
        else:
            i=3
            while(i>0):
                y = int(input("Guess again "))
                if(y==x):
                    print("You win")
                    i = 0
                    
                i = i-1
                if(i==-1):
                    print("You lose")
            
    main()
    done = input("Are you done? Enter True to end the game, and False to continue guessing")
