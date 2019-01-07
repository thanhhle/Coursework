#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 20 20:15:25 2016

@author: admin
"""
import turtle

def main():
    g = turtle.Turtle()
    g.up()
    g.goto(-350, -200)
    g.down()
    g.speed(10)
    
    sortFile = open("sortFile.txt", "r")
    line0 = sortFile.readline()
    line1 = sortFile.readline()
    line = sortFile.readline()
    line = line.rstrip('\n')
    while(line!=""):
        lineInt = int(line)
        g.forward(50)
        if(lineInt!=0):
            g.left(90)
            g.forward(lineInt*0.025)
            g.right(90)
            g.forward(5)
            g.right(90)
            g.forward(lineInt*0.025)
            g.left(90)
        else:
            g.forward(5)
    
        line = sortFile.readline()
        line = line.rstrip('\n')
    
    g.forward(50)
    g.up()
    g.goto(-350, -215)
    
    for i in range (2,13):
        g.forward(51.5)
        g.write(i)
        g.forward(3.5)
        
    sortFile.close()
    
main()
        
    