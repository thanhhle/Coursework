//
//  upDate.h
//  Overloading Operators
//
//  Created by Thanh Le on 10/23/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#ifndef upDate_h
#define upDate_h

#include <stdio.h>
#include <string>
using namespace std;

class upDate
{
    private:
        int *dptr;
        static int count;
    
    public:
        upDate();
        upDate(int, int, int);
        upDate(const upDate &);
        ~upDate();
        void setDate(int, int, int);
        int getMonth();
        int getDay();
        int getYear();
        string getMonthName();
    
        upDate operator+(int);
 friend upDate operator+(int, upDate);
        upDate operator-(int);
        int operator-(upDate);

 friend ostream &operator<<(ostream &, const upDate &);
    
        upDate &operator++();
        upDate operator++(int);
        upDate &operator--();
        upDate operator--(int);
        upDate operator=(upDate);
    
        bool operator==(upDate);
        bool operator<(upDate);
        bool operator>(upDate);
    
        int julian();
        bool checkDate(int, int, int);
        bool isLeapYear(int);
        void display();
        void incrDate(int);
        void decrDate(int);
        int daysBetween(upDate);
    
        static int GetDateCount();
};

int Greg2Julian(int *D);

void Julian2Greg(int JD, int *D);

#endif /* upDate_h */
