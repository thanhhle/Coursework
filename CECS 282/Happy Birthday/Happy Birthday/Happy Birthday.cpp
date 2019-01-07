// Thanh Le
// CECS 282-07
// Prog 0 - Happy Birthday
// Aug 30, 2017

#include <iostream>
#include <string>
using namespace std;

int main()
{
    string name;
    int age;
    int birthYear;
    char thisYear;
    cout << "What is your name?";
    cin >> name;
    cout << "How old are you " << name << "?";
    cin >> age;
    cout << name << ", have you had your birthday yet this year?? (y/n)";
    cin >> thisYear;
    
    if(thisYear == 'y' || thisYear == 'Y')
        birthYear = 2017 - age;
    else
        birthYear = 2017 - age - 1;
    
    cout << endl;
    cout << "Hi " << name << "!!!\n\nI guess that you were born in " << birthYear << endl;
    cout << "\n\nPress 'Enter' to continue: ";
    
    getchar();
    getchar();
    
    return 0;
}