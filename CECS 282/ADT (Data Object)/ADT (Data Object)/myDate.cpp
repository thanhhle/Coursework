//
//  myDate.cpp
//  ADT (Data Object)
//
//  Created by Thanh Le on 9/18/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#include <iostream>
#include <string>

#include "myDate.h"

using namespace std;

myDate::myDate()
{
    month = 5;
    day = 11;
    year = 1959;
}

myDate::myDate(int M, int D, int Y)
{
    if(checkDate(M, D, Y))
    {
        month = M;
        day = D;
        year = Y;
    }
    else
    {
        month = 5;
        day = 11;
        year = 1959;
    }
}

bool myDate::checkDate(int M, int D, int Y)
{
    int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if(isLeapYear(Y))    daysInMonth[1] = 29;
    
    if(M < 1 || M > 12)                         return false;
    else if(D < 1 || D > daysInMonth[M-1])      return false;
    else                                        return true;
}

bool myDate::isLeapYear(int Y)
{
    if(Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0))
    {
        return true;
    }
    else    return false;
}

void myDate::display()
{
    string monthStr[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    
    cout << monthStr[month-1] << " " << day << ", " << year;
}

void myDate::incrDate(int N)
{
    int JD = Greg2Julian(month, day, year);
    JD = JD + N;
    Julian2Greg(JD, month, day, year);
}

void myDate::decrDate(int N)
{
    int JD = Greg2Julian(month, day, year);
    JD = JD - N;
    Julian2Greg(JD, month, day, year);
}

int myDate::daysBetween(myDate D)
{
    return Greg2Julian(D.getMonth(), D.getDay(), D.getYear()) - Greg2Julian(month, day, year);
}

int myDate::getMonth()
{
    return month;
}

int myDate::getDay()
{
    return day;
}

int myDate::getYear()
{
    return year;
}

int myDate::dayOfYear()
{
    return -daysBetween(myDate(1, 1, year)) + 1;
}

string myDate::dayOfWeek()
{
    string daysInWeek[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
    int JD = Greg2Julian(month, day, year);
    return daysInWeek[JD % 7];
}

int Greg2Julian(int month, int day, int year)
{
    int I = year;
    int J = month;
    int K = day;
    
    return K - 32075 + 1461 * (I + 4800 + (J-14)/12)/4 + 367 * (J - 2 - (J - 14)/12 * 12)/12 - 3 * ((I + 4900 + (J - 14)/12)/100)/4;
}

void Julian2Greg(int JD, int &month, int &day, int &year)
{
    int I = year;
    int J = month;
    int K = day;
    
    int L = JD + 68569;
    int N = 4 * L/146097;
    L = L - (146097 * N + 3)/4;
    I = 4000 * (L + 1)/1461001;
    L = L - 1461 * I/4 + 31;
    J = 80 * L/2447;
    K = L - 2447 * J/80;
    L = J/11;
    J = J + 2 - 12 * L;
    I = 100 * (N-49) + I + L;
    
    year = I;
    month = J;
    day = K;
}
