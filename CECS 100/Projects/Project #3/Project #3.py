#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep 29 00:15:30 2016

@author: admin
"""
import random

### Question 1
print("--------------- QUESTION 1 ---------------")
print(""""GUESSING A NUMBER" GAME""")

def main():
    tryAgain = 'y'
    while (tryAgain == 'y' or tryAgain == "Y"):
        secretNum = random.randint(0, 99)
        numGuess = guessNum()
        checkNum(numGuess, secretNum)
        print("The random number:", secretNum)
        tryAgain = input("Would you like to try again, Y(yes) or N(no)? ")
        
        print("------------------------------------------")
        
def guessNum():
    num = int(input("Enter your guess as a number between 0 and 99: "))
    while(num<0 or num>99):
        num = int(input("Enter another number: "))
    return num
    
def checkNum(num, secret):
    if(num == secret):
        print("Great guess")
    elif(num%10*10+num//10 == secret):
        print("Right Digits, Wrong Order.")
    elif(num%10==secret%10 or num%10==secret//10 or num//10==secret%10 or num//10==secret//10):
        print("Not Bad, One Digit OK.")
    else:
        print("Completely Wrong")
    
main()
    


### Question 2
print("\n", "--------------- QUESTION 2 ---------------", sep="")
print("SIMPLIFIED CRAPS DICE GAME")

bank = 20

def main():
    global bank
    done = 'y'
    print("Your initial money in bank: $", bank, sep = "")
    while(done == 'y' or done == 'Y'): 
        bank = bank - 2 #pay to play (bet)
        if(bank<=0):
            print("You don't have enough money to play the game!")
            break
        result = playGame()
        bank = calculateBanking(result)
        print("Your bank account now: $", bank, sep = "")
        done = input("Would you like to try again, Y(yes) or N(no)? ")
        print("\n", "------------------------------------------", "\n", sep="")
    
def playGame():
    dice1 = random.randint(1, 6)
    dice2 = random.randint(1, 6)
    diceSum = dice1 + dice2
    
    if(diceSum == 2 or diceSum == 3 or diceSum == 12):
        print("The roll was", diceSum)
        print("You lose!")
        return "lose"
    elif(diceSum == 7 or diceSum == 1):
        print("The roll was", diceSum)
        print("You win!")
        return "win"
    else:
        print("The roll was ", diceSum, ", your point is established", sep="")
        print("Starting rolling for the point")
        dice3 = random.randint(1, 6)
        dice4 = random.randint(1, 6)
        diceSum1 = dice3 + dice4
        numRoll = 1
        print("Roll", numRoll, "is", diceSum1)
            
        
        while(diceSum1 != 7 and diceSum1 != diceSum):
            numRoll = numRoll + 1
            dice3 = random.randint(1, 6)
            dice4 = random.randint(1, 6)
            diceSum1 = dice3 + dice4
            print("Roll", numRoll, "is", diceSum1)
                
        if(diceSum1 == 7):
            print("You lose!")
            return "lose"
        else:
            print("You win!")
            return "win"

def calculateBanking(result):
    if(result == "win"):
        global bank 
        bank = bank + 4
    return bank
        
main()
    
    