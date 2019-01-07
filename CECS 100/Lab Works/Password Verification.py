1#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 10 08:52:18 2016

@author: admin
"""
def main():
    verify = False
    pw = input("What's your password? ")
    while(verify == False):    
        while(len(pw)<10):
            print("Password not long enough")
            pw = input("Enter your password again: ")
            
        count = [0]*4

        for ch in pw:
            if(ch.isdigit()):
                count[0]+=1
            if(ch.isupper()):
                count[1]+=1
            if(ch in ["%", "@", "#", "?", "!", "&"]):
                count[2]+=1
            if(ch.islower()):
                count[3]+=1

        if (count[0] < 2):
            print("Not enough digits")
        elif (count[1] < 2):
            print("Not enough capital letters")
        elif (count[2] < 2):
            print("Not enough special characters")
        elif (count[3] < 2):
            print("Not enough lowercase letters")
        else:
            break
        pw = input("Enter your password again: ")
    print("Your password is verified!")
main()
        
            