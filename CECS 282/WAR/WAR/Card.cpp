//
//  Card.cpp
//  WAR
//
//  Created by Thanh Le on 9/7/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#include <iostream>
#include <string>
#include "Card.h"

using namespace std;

Card::Card()
{
    rank = 'z';
    suit = 'z';
}

Card::Card(char s, char r)
{
    suit = s;
    rank = r;
}

void Card::setCard(char s, char r)
{
    suit = s;
    rank = r;
}

int Card::getValue()
{
    if (rank == 'A')
        return 1;
    else if (rank == 'T')
        return 10;
    else if (rank == 'J')
        return 11;
    else if (rank == 'Q')
        return 12;
    else if (rank == 'K')
        return 13;
    else
        return (int)rank - 48;
}

int Card::getSuitValue()
{
    if (suit == 'H')
        return 4;
    else if (suit == 'D')
        return 3;
    else if (suit == 'C')
        return 2;
    else
        return 1;
}

void Card::showCard()
{
    string rankStr[] = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    
    string suitStr[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
    
    cout << "    " << rankStr[getValue()-1] << " of " << suitStr[4 - getSuitValue()] << endl;

    cout << " ------- " << endl;
    
    if(rank == 'T')
        cout << "[10     ]" << endl;
    else
        cout << "[" << rank << "      ]" << endl;
    
    if (suit == 'S')
        cout << "[   *   ]\n[  * *  ]\n[ ***** ]\n[*  *  *]\n[   *   ]\n";
    else if (suit == 'C')
        cout << "[   *   ]\n[*  *  *]\n[ * * * ]\n[   *   ]\n[   *   ]\n";
    else if (suit == 'D')
        cout << "[   *   ]\n[  * *  ]\n[ *   * ]\n[  * *  ]\n[   *   ]\n";
    else if (suit == 'H')
        cout << "[ ** ** ]\n[*  *  *]\n[ *   * ]\n[  * *  ]\n[   *   ]\n";
    
    if(rank == 'T')
        cout << "[     10]" << endl;
    else
        cout << "[      " << rank << "]" << endl;
    
    cout << " ------- " << endl << endl;
}



