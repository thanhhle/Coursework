//
//  main.cpp
//  WAR
//
//  Created by Thanh Le on 9/7/17.
//  Copyright © 2017 Thanh Le. All rights reserved.
//
#include <iostream>
#include "Deck.h"
#include "Card.h"

using namespace std;

int main() {
    Deck myDeck;
    int choice;
    bool gameOn = true;
    
    while(gameOn)
    {
        cout << "1) Get a new card deck" << endl;
        cout << "2) Show all remaining cards in the deck" << endl;
        cout << "3) Shuffle" << endl;
        cout << "4) Play WAR!" << endl;
        cout << "5) Exit" << endl;
        
        cin >> choice;
        
        while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5)
        {
            cin.clear();
            cin.ignore();
            cout << "Invalid choice" << endl;
            cout << "Enter choice again!" << endl;
            cin >> choice;
        }
        
        if(choice == 1)
            myDeck.refreshDeck();
        
        else if(choice == 2)
            myDeck.showDeck();
        
        else if(choice == 3)
            myDeck.shuffle();
        
        else if(choice == 4)
        {
            cout << "Get ready to play WAR!!!" << endl;
            while(myDeck.cardsLeft() > 1)
            {
                myDeck.shuffle();
                cout << "There are " << myDeck.cardsLeft() << " cards in the deck." << endl;
                cout << "...dealing..." << endl;
                        
                Card yourCard = myDeck.deal();
                cout << "One for you..." << endl;
                yourCard.showCard();
                        
                Card myCard = myDeck.deal();
                cout << "One for me..." << endl;
                myCard.showCard();
                        
                if(yourCard.getValue() > myCard.getValue())
                    cout << "You Win!!!!" << endl;
                else if(yourCard.getValue() < myCard.getValue())
                    cout << "I Win!!!!" << endl;
                else
                    if(yourCard.getSuitValue() > myCard.getSuitValue())
                    {
                        cout << "You Win!!!!" << endl;
                    }
                    else
                    {
                        cout << "I Win!!!!" << endl;
                    }
                        
                cout << "\nWanna play again? (Y/N)" << endl;
                
                char answer;
                cin >> answer;
                        
                if(answer == 'Y' || answer == 'y')
                    continue;
                else
                    break;
            }
                
            if(myDeck.cardsLeft() <= 1)
                cout << "There is NOT ENOUGH CARD in the deck to play the game" << endl;
        }
                
        else if(choice == 5)
        {
            cout << "Goodbye" << endl;
            gameOn = false;
        }
    }
    return 0;
}
