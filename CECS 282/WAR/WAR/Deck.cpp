//
//  Deck.cpp
//  WAR
//
//  Created by Thanh Le on 9/7/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//

#include <iostream>
#include <string>

#include "Deck.h"

using namespace std;

Deck::Deck()
{
    refreshDeck();
}

void Deck::refreshDeck()
{
    topCard = 0;
    char ranks[13] = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
    char suits[4] = { 'H', 'D', 'C', 'S' };
    
    for (int i = 0; i < 52; i++)
    {
        cards[i].setCard(suits[i/13], ranks[i%13]);
    }
}

Card Deck::deal()
{
    if(topCard < 52)
    {
        return cards[topCard++];
    }
    cout << "There is NOT ENOUGH CARD in the deck to deal" << endl;
    return Card();
}

void Deck::shuffle()
{
    srand(int(time(NULL)));
    if(topCard == 0)
    {
        for (int i = 0; i < 10000; i++)
        {
            int x = rand()% 52;
            int y = rand()% 52;
            Card temp = cards[x];
            cards[x] = cards[y];
            cards[y] = temp;
        }
    }
}

int Deck::cardsLeft()
{
    return 52 - topCard;
}

void Deck::showDeck()
{
    for (int i = topCard; i < 52; i++)
    {
        cards[i].showCard();
    }
}
