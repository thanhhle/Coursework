//
//  BigInt.cpp
//  Standard Template Library
//
//  Created by Thanh Le on 11/7/17.
//
//
#include <iostream>
#include <vector>
#include <string>

#include "BigInt.h"

using namespace std;

BigInt::BigInt()
{
    storage.push_back(0);
}
    
BigInt::BigInt(int n)
{
    while(n/10 >= 1)
    {
        storage.push_back(n%10);
        n = n/10;
    }
    storage.push_back(n);
}
        
BigInt::BigInt(string bigS)
{
    for(int i = (int)bigS.size()-1; i >= 0; i--)
    {
        storage.push_back(int(bigS.at(i) - '0'));
    }
}
            
BigInt BigInt::operator++(int dumy)
{
    BigInt temp(*this);
    (*this) = (*this) + 1;
    return temp;
}
                
bool BigInt::operator<(const BigInt & bigN) const
{
    if      ((*this).storage.size() < bigN.storage.size())         return true;
    else if ((*this).storage.size() > bigN.storage.size())         return false;
    else
    {
        for(int i = (int)bigN.storage.size()-1; i > -1; i--)
        {
            if((*this).storage[i] < bigN.storage[i])
            {
                return true;
            }
        }
        return false;
    }
}

bool BigInt::operator==(BigInt bigN)
{
    return (*this).storage == bigN.storage;
}

bool BigInt::operator==(int bigN)
{
    return (*this).storage == BigInt(bigN).storage;
}
                    
bool BigInt::operator<=(BigInt bigN)
{
    return ((*this) < bigN || (*this) == bigN);
}
    
BigInt BigInt::operator-(BigInt bigN)
{
    BigInt result;
    BigInt bigger;
    BigInt smaller;
    
    if((*this) == bigN)
    {
        return BigInt(0);
    }
    else
    {
        if((*this) < bigN)
        {
            bigger = bigN;
            smaller = (*this);
        }
        else
        {
            bigger = (*this);
            smaller = bigN;
        }
        
        int size = (int)bigger.storage.size();
        int borrow = 0;
        
        for(int i = 0; i < size; i++)
        {
            int dif = bigger.storage[i] - (i >= smaller.storage.size() ? 0 : smaller.storage[i]) - borrow;
            borrow = 0;
            
            if(dif < 0)
            {
                borrow = 1;
                dif = dif + 10;
            }
            
            result.storage.push_back(dif);
        }
      
        stripLeadingZero(result);
        
        result.storage.erase(result.storage.begin());           // delete vector<int> result first element (0)
        
        if((*this) < bigN)
        {
            result.storage[result.storage.size()-1] = -result.storage[result.storage.size()-1];
        }
        
        return result;
    }
}

BigInt BigInt::operator-(int n)
{
    return (*this) - BigInt(n);
}
                                    
BigInt BigInt::operator+(BigInt bigN)
{
    BigInt result;
    
    int size = (*this).storage.size() > bigN.storage.size() ? (int)(*this).storage.size() : (int)bigN.storage.size();
    int carry = 0;
    
    for(int i = 0; i < size; i++)
    {
        int sum = (i >= ((*this).storage.size()) ? 0 : (*this).storage[i]) + (i >= bigN.storage.size() ? 0 : bigN.storage[i]) + carry;
        carry = 0;
        
        if(sum >= 10)
        {
            carry = 1;
            sum = sum%10;
        }
        result.storage.push_back(sum);
    }
    
    if(carry != 0)
    {
        result.storage.push_back(1);
    }
    
    result.storage.erase(result.storage.begin());           // delete vector<int> result first element (0)
    return result;
}

ostream & operator<<(ostream & out, const BigInt & bigN)
{
    vector<int>::const_reverse_iterator rit;
    for(rit = bigN.storage.crbegin(); rit != bigN.storage.crend(); rit++)
    {
        out << *rit;
    }
    return out;
}

void BigInt::stripLeadingZero(BigInt & bigN)
{
    while(bigN.storage[bigN.storage.size()-1] == 0)
    {
         bigN.storage.pop_back();
    }
}