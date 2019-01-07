#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 20 09:27:06 2016

@author: admin
"""
def main():
    sort = [0]*13
    diceSumNum = open("diceSumNum.txt", "r")
    sortFile = open("sortFile.txt", "w")
    
    line = diceSumNum.readline()
    while(line!=''):
        line = line.rstrip('\n')
        lineInt = int(line)
        sort[lineInt]+=1
        line = diceSumNum.readline()
    
    for i in range (len(sort)):
        sortFile.write(str(sort[i])+'\n')
        
    diceSumNum.close()
    print(sort)
        
main()
