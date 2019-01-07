//
//  Deck.h
//  WAR
//
//  Created by Thanh Le on 9/7/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#ifndef Deck_h
#define Deck_h

#include <stdio.h>
#include "Card.h"

class Deck
{
    private:
        int topCard;
        Card cards[52];
    
    public:
        Deck();
        void refreshDeck();
        Card deal();
        void shuffle();
        int cardsLeft();
        void showDeck();
};

#endif /* Deck_h */