# -*- coding: utf-8 -*-
"""
Created on Tue Sep 13 08:25:42 2016

@author: admin
"""

### Question 1
print("--------------- QUESTION 1 ---------------")
print("Calculate the sum of an infinite series")

a = int(input("Input a: "))

r = float(input("Input r, |r| < 1: "))

while(abs(r) >= 1):
    r = float(input("Enter again  "))

k = int(input("Number of terms (integer) in summation, k: "))

s = a/(1-r)

print(" k, Sum in Theory, Actual Sum, %error")

for i in range(k+1):
    sum = 0
    for m in range(i+1):
        sum = sum + a*r**m
        
    print(format(i,'2.0f'), format(s, '.5f'), format(sum, '.5f'), format((s-sum)/s, '%'), sep='     ')
    
  
### Question 2
print("--------------- QUESTION 2 ---------------")
print("This program calculates the monthly payment theoretically, and then verifies it.")


P = int(input("Initial principal = "))
i = float(input("APR as a % = "))
n = int(input("Duration of loan in number of months = "))
i = i/100/n
I = float(P*i)/(1-(1+i)**(-n))
accumulatedInterest = 0

print('\n')

print("Monthly payment = $", format(I, '.2f')) 

print('\n')

print("The month#, accumulated interest, and ending loan balance are:")

for j in range(n+1):
    balance = float((((1+i)**j)*P)-(I*(1-(1+i)**j))/(-i))
    if(j!=0):
        accumulatedInterest = accumulatedInterest + balance*i
    print(format(j,'6.0f'), format(accumulatedInterest, '.2f'), format(balance, '.2f'), sep='             ')
    

### Question 3
print("--------------- QUESTION 3 ---------------")
import turtle
import random

g = turtle.Turtle()
g.shape("triangle")

r = 200
numDarts = 100
dartsInCircle = 0

g.up()
g.goto(-200,-200)
g.down()

for i in range(4):
    g.forward(r*2)
    g.left(90)
    
g.up()
g.forward(r)
g.down()
    
g.circle(r)

g.up()
    
for i in range(numDarts):
    x=200-400*random.random()
    y=200-400*random.random()
    if(x**2+y**2<r**2):
        dartsInCircle = dartsInCircle + 1
        
    g.speed(100)
    g.goto(x,y)
    g.dot()
    g.goto(0,0)
        
          
print("""Number of "darts" in the circle:""", dartsInCircle)
print("""The ratio of "darts" in the circle to total "darts thrown":""", format(dartsInCircle/numDarts, '.5f'))
print("The ratio, times 4: ", dartsInCircle*4/numDarts)
