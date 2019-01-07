# -*- coding: utf-8 -*-
"""
Created on Tue Sep  6 08:53:46 2016

@author: admin
"""
change = float(input("Enter your change: $"))

dollars = int(change)
quarters = int((change - dollars)/0.25)
dimmers = int((change - dollars - quarters*0.25)/0.10)
pennies = int((change - dollars - quarters*0.25 - dimmers*0.10)/0.01)

if(dollars > 1):
    print(dollars, "dollars")
elif(dollars == 1):
    print(dollars, "dollar")

if(quarters > 1):
    print(quarters, "quarters")
elif(quarters == 1):
    print(quarters, "quarter")
    
if(dimmers > 1):
    print(dimmers, "dimmers")
elif(dimmers == 1):
    print(dimmers, "dimmer")

if(pennies > 1):
    print(pennies, "pennies")
elif(pennies == 1):
    print(pennies, "penny")