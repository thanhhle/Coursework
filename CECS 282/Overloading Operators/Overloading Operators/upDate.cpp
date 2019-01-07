//
//  upDate.cpp
//  Overloading Operators
//
//  Created by Thanh Le on 10/23/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#include "upDate.h"
int upDate::count = 0;

#include <iostream>
#include <string>

using namespace std;

upDate::upDate()
{
    dptr = new int[3];
    dptr[0] = 5;
    dptr[1] = 11;
    dptr[2] = 1959;
    count++;
}

upDate::upDate(int M, int D, int Y)
{
    dptr = new int[3];
    setDate(M, D, Y);
    count++;
}

upDate::upDate(const upDate &d)
{
    dptr = new int[3];
    dptr[0] = d.dptr[0];
    dptr[1] = d.dptr[1];
    dptr[2] = d.dptr[2];
    count++;
}

upDate::~upDate()
{
    delete [] dptr;
    count--;
}

void upDate::setDate(int M, int D, int Y)
{
    if(checkDate(M, D, Y))
    {
        dptr[0] = M;
        dptr[1] = D;
        dptr[2] = Y;
    }
    else
    {
        dptr[0] = 5;
        dptr[1] = 11;
        dptr[2] = 1959;
    }
}

int upDate::getMonth()
{
    return dptr[0];
}

int upDate::getDay()
{
    return dptr[1];
}

int upDate::getYear()
{
    return dptr[2];
}

string upDate::getMonthName()
{
    string monthStr[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    return monthStr[getMonth()-1];
}



upDate upDate::operator+(int n)             //upDate + int
{
    upDate temp(*this);
    temp.incrDate(n);
    return temp;
}

upDate operator+(int n, upDate d)           //int + upDate
{
    upDate temp(d);
    temp.incrDate(n);
    return temp;
}

upDate upDate::operator-(int n)             //upDate - int
{
    upDate temp(*this);
    temp.decrDate(n);
    return temp;
}

int upDate::operator-(upDate d)             //upDate - upDate
{
    return d.daysBetween(*this);
}

ostream &operator<<(ostream &out, const upDate &d)
{
    out << d.dptr[0] << "/" << d.dptr[1] << "/" << d.dptr[2];
    return out;
}


upDate upDate::operator=(upDate d)            //upDate = upDate
{
    dptr[0] = d.dptr[0];
    dptr[1] = d.dptr[1];
    dptr[2] = d.dptr[2];
    return (*this);
}


upDate& upDate::operator++()                   //++upDate
{
    incrDate(1);
    return (*this);
}

upDate upDate::operator++(int dummy)           //update++
{
    upDate temp(*this);
    incrDate(1);
    return temp;
}

upDate& upDate::operator--()                   //--upDate
{
    decrDate(1);
    return (*this);
}

upDate upDate::operator--(int dummy)           //upDate--
{
    upDate temp(*this);
    decrDate(1);
    return temp;
}

bool upDate::operator==(upDate d)              //upDate == upDate d
{
    return (daysBetween(d) == 0);
}

bool upDate::operator<(upDate d)               //upDate < upDate d
{
    return (daysBetween(d) > 0);
}

bool upDate::operator>(upDate d)               //upDate > upDate d
{
    return (daysBetween(d) < 0);
}

int upDate::julian()
{
    return Greg2Julian(dptr);
}

int upDate::GetDateCount()
{
    return count;
}

bool upDate::checkDate(int M, int D, int Y)
{
    int daysInMonth[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    if(isLeapYear(Y))    daysInMonth[1] = 29;
    
    if(M < 1 || M > 12)                         return false;
    else if(D < 1 || D > daysInMonth[M-1])      return false;
    else                                        return true;
}

bool upDate::isLeapYear(int Y)
{
    if(Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0))
    {
        return true;
    }
    else    return false;
}

void upDate::incrDate(int N)
{
    int JD = julian();
    JD = JD + N;
    Julian2Greg(JD, dptr);
}

void upDate::decrDate(int N)
{
    int JD = julian();
    JD = JD - N;
    Julian2Greg(JD, dptr);
}

int upDate::daysBetween(upDate D)
{
    return D.julian()-julian();
}

int Greg2Julian(int *D)
{
    int I = D[2];
    int J = D[0];
    int K = D[1];
    
    return K - 32075 + 1461 * (I + 4800 + (J-14)/12)/4 + 367 * (J - 2 - (J - 14)/12 * 12)/12 - 3 * ((I + 4900 + (J - 14)/12)/100)/4;
}

void Julian2Greg(int JD, int *D)
{
    int I = D[2];
    int J = D[0];
    int K = D[1];
    
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
    
    D[2] = I;
    D[0] = J;
    D[1] = K;
}

