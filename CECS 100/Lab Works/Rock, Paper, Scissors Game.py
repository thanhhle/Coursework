i#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Oct 12 20:50:11 2016

@author: admin
"""
import random

def main():
    again = 'y'
    while(again == 'y'):
        userChoice, comChoice = playGame()
        while(userChoice == comChoice):
            userChoice, comChoice = playGame()
        analyze(userChoice, comChoice)
        
        print()
        again = input("Do you want to play again?")
    
    
def playGame():
    secretNum = random.randint(1,3)
    
    if(secretNum == 1):
        cChoice = 'rock'
    elif(secretNum == 2):
        cChoice = 'paper'
    else:
        cChoice = 'scissors'
    
    uChoice = input("Enter your choice: ")
    while(uChoice != 'rock' and uChoice != 'paper' and uChoice != 'scissors'):
        uChoice = input("Enter your choice: ")
        
    return uChoice, cChoice
    
def analyze(uChoice, cChoice):
    print("The computer's choice:", cChoice)
    print("Your choice:", uChoice)
    
    if(uChoice == 'rock'):
        if(cChoice == 'paper'):
            print("Computer wins!")
        else:
            print("User wins!")
    elif(uChoice == 'paper'):
        if(cChoice == 'scissors'):
            print("Computer wins!")
        else:
            print("User wins!")
    elif(uChoice == 'scissors'):
        if(cChoice == 'rock'):
            print("Computer wins!")
        else:
            print("User wins!")
        
main()
                