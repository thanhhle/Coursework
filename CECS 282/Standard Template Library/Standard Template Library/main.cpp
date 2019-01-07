//
//  main.cpp
//  Standard Template Library
//
//  Created by Thanh Le on 11/7/17.
//
//

#include <iostream>
#include <time.h>
#include <iomanip>
#include <map>
#include <string>

#include "BigInt.h"

using namespace std;

int fact(int);
BigInt GoldRabbits(BigInt bigN);

int main()
{
    BigInt bigX(28675), bigY("46368"), bigResult;
    
    bigResult = bigX + bigY;
    cout << bigX  << "+" << bigY << "=" << bigResult;
    getchar(); // pause
    
    for (BigInt n = 0; n <= 1000; n++)
    {
        cout << (n<950?"\n":"\n\n")<<"The GoldRabbit of ("<<n<<") is "<<GoldRabbits(n);
        if (n == 30) // pause at 30
            getchar();
    }
    
    getchar(); // pause after the GoldRabbits
    
    for (int i=0; i<20; i++)
    {
        try {
            cout << "Fact("<<i<<"):"<<fact(i)<<endl;
        }
        catch(...) {
            cout << "Fact("<<i<<"):"<<"Overflow"<<endl;
        }
    }
    getchar();
    
    return 0;
}

BigInt GoldRabbits(BigInt bigN)
{
    static map<BigInt, BigInt> fiboMap;
    if (bigN == 0 || bigN == 1)
        fiboMap[bigN] = BigInt(1);
    else
        fiboMap[bigN] = fiboMap[bigN-1] + fiboMap[bigN-2];

    return fiboMap[bigN];
}

int fact(int n)
{
    if(n == 0 || n == 1)
        return 1;
    else
    {
        double result = (double)n * fact(n-1);
        if(result != int(result))
            throw overflow_error("");
        else
            return result;
    }
}
