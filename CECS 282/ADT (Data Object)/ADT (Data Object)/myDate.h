//
//  myDate.hpp
//  ADT (Data Object)
//
//  Created by Thanh Le on 9/18/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#ifndef myDate_h
#define myDate_h

#include <stdio.h>
#include <string>

using namespace std;

class myDate
{
    private:
        int month;
        int day;
        int year;
    
    public:
        myDate();
        myDate(int M, int D, int Y);
        void display();
        void incrDate(int N);
        void decrDate(int N);
        int daysBetween(myDate D);
        int getMonth();
        int getDay();
        int getYear();
        int dayOfYear();
        string dayOfWeek();
        bool isLeapYear(int Y);
        bool checkDate(int M, int D, int Y);
};

int Greg2Julian(int month, int day, int year);

void Julian2Greg(int JD, int &month, int &day, int &year);

#endif /* myDate_h */
