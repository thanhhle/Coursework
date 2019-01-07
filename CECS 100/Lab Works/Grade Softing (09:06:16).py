# -*- coding: utf-8 -*-
"""
Created on Tue Sep  6 08:55:13 2016

@author: admin
"""
### With IF-ELSE STATEMENT
grade = int(input("Enter your grade: "))

if(grade>=90):
    print("Your grade is A")
else:
    if(grade>=80):
        print("Your grade is B")
    else:
        if(grade>=70):
            print("Your grade is C")
        else:
            if(grade>=60):
                print("Your grade is D")
            else:
                print("Your grade is F")
                
### With ELIF
grade = int(input("Enter your grade: "))

if(grade >= 90):
    print("Your grade is A")
elif(grade >= 80):
    print("Your grade is B")
elif(grade >= 70):
    print("Your grade is C")
elif(grade >= 60):
    print("Your grade is D")
else:
    print("Your grade is F")
    