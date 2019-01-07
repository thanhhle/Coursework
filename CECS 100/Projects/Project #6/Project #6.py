2#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov  8 08:50:31 2016

@author: admin
"""

def main():
    mode = getMode()
    message = getMessage()
    key = getKey()
    print('\n'+ "Cipher text: " + translateMessage(mode, message, key))
    
def getMode():
    mode = input("Do you want to encode or decode? Enter either 1 for encode, or 2 for decode ")
    while(mode!='1' and mode!='2'):
        mode = input("Please enter your choice again: ")
    return mode
    
def getMessage():
    return input("Enter your message: ")
    
def getKey():
    try:
        key = int(input("Enter your key: "))
    except ValueError:
        print("Key must be a number!")
        key = int(input("Enter your key again: "))

    while(key<=0 or key>=26):
        key = int(input("Enter your key again: "))
    return key

def translateMessage(mode, message, key):
    translatedMess = ""
    for ch in message:
        num = ord(ch)
        if(mode=='1'):
            num += key
        else:
            num -= key
            
        if(ch.isalpha()):
            if(ch.isupper()):
                if(num>ord('Z')):
                    num -= 26
                elif(num<ord('A')):
                    num += 26
            elif(ch.islower()):
                if(num>ord('z')):
                    num -= 26
                elif(num<ord('a')):
                    num += 26
            translatedMess += chr(num)
        else:
            translatedMess += ch
            
    return translatedMess

main()


