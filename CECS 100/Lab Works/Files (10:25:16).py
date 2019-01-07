#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 25 09:03:51 2016

@author: admin
"""
import random

def main():
    n = int(input('Number of random numbers to work with?'))
    myFile = open('fileData.txt', 'w')
    
    for i in range(1, n+1):
        num = random.randint(1, 100)
        myFile.write(str(num)+'\n')
        
    myFile.close
    print("fileData has data")
    
def test():
    myFile2 = open('fileData.txt', 'r')
    
    contents = myFile2.read()
    print(contents)
    
    fileList = myFile2.readlines()
    print(fileList)
    '''
    myFile2 = open('fileData.txt', 'r')
    print(myFile2.readline(12))
    '''
    
    
    myFile3 = open('fileData.txt', 'r')
    fileList = myFile3.read()
    print(fileList)
    
    
    fileList = myFile3.readlines()
    print(fileList)
    
main()
test()
"""
def main():
    n = int(input("How many numbers are being considered? "))
    myFile = open("numbers.txt", "w")
    print("Enter a number: ")
    for i in range(1, n+1):
        number = float(input("#" + str(i) + ": "))
        myFile.write(str(number) + '\n')
    myFile.close()
    print("myFile has data")
main()


def main():
    myFile = open("numbers.txt", "r")
    sum = 0
    i = 1
    print("Here is a running sum of the numbers")
    for j in myFile:
        num = float(j)
        print("num", i, ",", num, sep=" ")
        i+=1
        sum+=num
    myFile.close()
    print("Sum of numbers in numbers.txt =", sum, "and average =", sum/i)
main()


def main():
    myFile = open("numbers.txt", "r")
    
    line = myFile.readline()
    sum = 0.0
    i = 0
    
    while(line != ''):
        i+=1
        
        sum+=float(line)
        print(line)
        line = myFile.readline()
        
    print("Sum of numbers in numbers.txt =", sum, "and average =", sum/i)
    myFile.close()
    
main()


def main():
    myFile = createFile()
    readFile(myFile)
    
def createFile():   
    myFile = open("numbers.txt", "w")
    for i in range(20):
        num = str(random.randint(1,6)) + '\n'
        myFile.write(num)
    
    myFile.close()
    return myFile

def readFile(myFile):
    myFile = open("numbers.txt", "r")
    line = myFile.readline()
    while(line!=""):
        line = line.rstrip('\n')
        print(line)
        line = myFile.readline()
    myFile.close()
    
main()
"""                                                                                                                                                                                                                                                                                                                                                