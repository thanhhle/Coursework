# -*- coding: utf-8 -*-
"""
Created on Tue Sep  6 09:05:15 2016

@author: admin
"""
num1 = int(input("Enter first number: "))
num2 = int(input("Enter second number: "))
num3 = int(input("Enter third number: "))

if(num1 >= num2 and num1 >= num3):
    if(num2 >= num3):
        print (num3, num2, num1)
    else:
        print (num2, num3, num1)
        
elif(num2 >= num1 and num2 >= num3):
    if(num1 >= num3):
        print (num3, num1, num2)
    else:
        print (num1, num3, num2)
        
else:
    if(num1 >= num2):
        print (num2, num1, num3)
    else:
        print (num1, num2, num3)
