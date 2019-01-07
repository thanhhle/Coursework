# -*- coding: utf-8 -*-
"""
Created on Tue Sep  6 09:30:20 2016

@author: admin
"""

### Solution 1
char1 = input("Enter first character: ")
char2 = input("Enter second character: ")
char3 = input("Enter third character: ")

num1 = ord(char1)
num2 = ord(char2)
num3 = ord(char3)

if(num1 >= num2 and num1 >= num3):
    if(num2 >= num3):
        print (char3, char2, char1)
    else:
        print (char2, char3, char1)
        
elif(num2 >= num1 and num2 >= num3):
    if(num1 >= num3):
        print (char3, char1, char2)
    else:
        print (char1, char3, char2)
        
else:
    if(num1 >= num2):
        print (char2, char1, char3)
    else:
        print (char1, char2, char3)
        
        
### Solution 2
char1 = input("Enter first character: ")
char2 = input("Enter second character: ")
char3 = input("Enter third character: ")

if(char1 >= char2 and char1 >= char3):
    if(char2 >= char3):
        print (char3, char2, char1)
    else:
        print (char2, char3, char1)
        
elif(char2 >= char1 and char2 >= char3):
    if(char1 >= char3):
        print (char3, char1, char2)
    else:
        print (char1, char3, char2)
        
else:
    if(char1 >= char2):
        print (char2, char1, char3)
    else:
        print (char1, char2, char3)