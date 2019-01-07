#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 20 08:58:53 2016

@author: admin
"""
import random

def main():
    diceSumNum = open("diceSumNum.txt", "w")
    numSums = getUserInput()
    for i in range (numSums):
        dice1 = random.randint(1,6)
        dice2 = random.randint(1,6)
        sum = str(dice1 + dice2) + '\n'
        diceSumNum.write(sum)
    diceSumNum.close()
    
def getUserInput():
    while True:
        try:
            return int(input("Please enter a number: "))
        except ValueError:
            print("Invalid input. Please try again!")
            
main()