# -*- coding: utf-8 -*-
"""
Created on Tue Aug 30 09:03:01 2016

@author: admin
"""

# Question 1
print("---------- QUESTION 1 ----------")
print("First, you think of a three-digit number, remember that it has first and last digits differ by at least two, then you reverse it and subtract the smaller from the larger. After that, you add the new number with its reverse together. I will guess what the result is.")

number = int(input("Enter a three-digit number which has first and last digits differ by at least two: "))

while (len(str(number))!=3) or (abs((number//100) - number%10) < 2):
    number = int(input("Enter again "))

print ("Your number:", number)

reversed_num = (number%10)*100 + ((number%100)//10)*10 + (number//100)
print ("Reversed number:", reversed_num, '\n')

difference = abs(reversed_num - number)
print ("Difference between the entered number and the reversed number:", difference, '\n')

reversed_difference = (difference%10)*100 + ((difference%100)//10)*10 + (difference//100)
print ("The reverse of the difference:", reversed_difference, '\n')

print ("The sum of the difference and the reversed difference:", difference + reversed_difference, '\n')


# Question 2
print("---------- QUESTION 2 ----------")
cookie_num = int(input("How many cookies that you want to make? "))

print("To make", cookie_num, "cookies, you need: ")

sugar = float((1.5/48)*cookie_num)
butter = float((1/48)*cookie_num)
flour = float((2.75/48)*cookie_num)

if sugar <= 1:
    print(format(sugar, '10,.3f'), "cup of sugar")
else:
    print(format(sugar, '10,.3f'), "cups of sugar")

if butter <= 1:
    print(format(butter, '10,.3f'), "cup of butter")
else:
    print(format(butter, '10,.3f'), "cups of butter")

if flour <=1:
    print(format(flour, '10,.3f'), "cup of flour")
else:
    print(format(flour, '10,.3f'), "cups of flour")
