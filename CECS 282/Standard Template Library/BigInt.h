//
//  BigInt.hpp
//  Standard Template Library
//
//  Created by Thanh Le on 11/7/17.
//
//

#ifndef BigInt_h
#define BigInt_h

#include <stdio.h>
#include <string>
#include <vector>

using namespace std;

class BigInt
{
    private:
        vector<int> storage;
        void stripLeadingZero(BigInt &);
    
    public:
        BigInt();
        BigInt(int);
        BigInt(string);
        BigInt operator++(int);
        bool operator<=(BigInt);
        bool operator==(int);
        bool operator==(BigInt);
        BigInt operator-(BigInt);
        BigInt operator-(int);
        BigInt operator+(BigInt);
        bool operator<( const BigInt &) const;
        friend ostream & operator<<(ostream &, const BigInt &);
};

#endif /* BigInt_h */
