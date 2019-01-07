#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 27 09:35:03 2016

@author: admin
"""
from random import gauss
from math import sqrt

def main():
    n = int(input("Enter number of data points: "))
    value = [0]*n
    for i in range (n):
        value[i] = int(gauss(70, 10))
        
    print(value)
    aver = mean(value)
    std = standDev(value, aver)
    
    print("Mean = ", aver)
    print("Standard deviation = ", std)
    
def mean(value):
    sum = 0
    for i in value:
        sum = sum + i
        
    return sum/len(value)
    
def standDev(value, aver):
    sum1 = 0
    for i in value:
        sum1 = sum1 + ((i - aver)**2)
    std = sqrt(sum1/(len(value)-1))
    
    return std
    
main()
