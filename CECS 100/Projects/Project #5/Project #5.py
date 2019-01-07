#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov  1 08:55:33 2016

@author: admin
"""
def main():
    print("Input the first matrix")
    matrix1 = readMatrix()
    print("A =", matrix1)
    
    print("---------------------------------------")
    
    print("Input the second matrix")
    matrix2 = readMatrix()
    while(len(matrix1[0])!=len(matrix2)):
        print("\n" + "The number of columns of the first matrix must have the same number of rows of the second matrix")
        print("Enter 2 matrices again!")
        print("Input the second matrix")
        matrix2 = readMatrix()
    print("B =", matrix2)
    
    print()
    print("C =", multiplyMatrices(matrix1, matrix2))
    
   
def readMatrix():
    r = int(input("How many rows in the matrix? "))
    c = int(input("How many columns in the matrix? "))
    
    X = [[0 for j in range (c)] for i in range(r)]
    for i in range(r):
        for j in range(c):
            X[i][j] = int(input("Enter element " + str(j+1) + " in row " + str(i+1) + ": "))
    
    return X
    

def multiplyMatrices(matrix1, matrix2):
    X = [[0 for j in range (len(matrix1))] for i in range(len(matrix2[0]))]
    for i in range(len(X)):
        for j in range(len(X[0])):
            X[i][j] = sum(matrix1[i][k]*matrix2[k][j] for k in range(len(matrix1[0])))
  
    return X
              
main()