//
//  Card.h
//  WAR
//
//  Created by Thanh Le on 9/7/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#ifndef Card_h
#define Card_h

#include <stdio.h>

class Card
{
    private:
        char suit;
        char rank;
    
    public:
        Card();
        Card(char s, char r);
        void setCard(char s, char r);
        int getValue();
        void showCard();
        char getSuit();
        char getRank();
        int getSuitValue();
};

#endif /* Card_h */
