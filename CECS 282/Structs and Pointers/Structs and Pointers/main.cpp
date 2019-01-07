//
//  main.cpp
//  Structs and Pointers
//
//  Created by Thanh Le on 10/2/17.
//
//
#include <iostream>
#include <iomanip>
#include <stdio.h>
#include <cstring>
#include "myDate.h"

using namespace std;

struct Student
{
    char name[20];
    int ID;
    char grade;
    myDate bday;
    string homeTown;
};

char getRandomGrade()
{
    char gradeList[5] = {'A', 'B', 'C', 'D', 'F'};
    return gradeList[rand() % 5];
}

int getRandomID()
{
    return rand() % 8999 + 1000;
}

myDate getRandomBDay()
{
    myDate randomDate;
    bool test = false;
    int day, month, year;
    while (!test)
    {
        day = rand() % 31 + 1;
        month = rand() % 12 + 1;
        year = rand() % 5 + 1995;
        test = randomDate.checkDate(month, day, year);
    }
    return myDate(month, day, year);
}

void initStudents(Student *tenStudents)
{
    char nameList[10][20] = {"Thanh Le", "Maureen Le", "Kenneth Nguyen", "Wendy Trump", "Stella Tinh", "Sarocha Burintr", "Saranee Burintr", "Jonathan Smith", "Kennedy Clinton", "Rosetta Florence"};
    
    string homeTownList[10] = {"Long Beach", "Paris", "Los Angeles", "New York", "Ho Chi Minh", "Bangkok", "Stanton", "Milan", "Beijin", "Phnom Penh"};
    
    for(int i = 0; i < 10; i++)
    {
        strcpy(tenStudents[i].name, nameList[i]);
        tenStudents[i].ID = getRandomID();
        for(int k = 0; k < i; k++)
        {
            if(tenStudents[k].ID == tenStudents[i].ID)
            {
                tenStudents[i].ID = getRandomID();
                k = -1;
            }
        }

        tenStudents[i].grade = getRandomGrade();
        tenStudents[i].bday = getRandomBDay();
        tenStudents[i].homeTown = homeTownList[i];
    }
}

void sort(Student *ptr[], string type)
{
    int resultCompare;
    Student *temp;
    
    for(int i = 0; i < 9; i++)
    {
        for(int k = i+1; k < 10; k++)
        {
            if(type == "name")          resultCompare = strcmp(ptr[i]->name, ptr[k]->name);
            else if(type == "ID")       resultCompare = ptr[i]->ID > ptr[k]->ID;
            else if(type == "grade")    resultCompare = ptr[i]->grade > ptr[k]->grade;
            else if(type == "bday")     resultCompare = ptr[i]->bday.daysBetween(ptr[k]->bday);
            else                        resultCompare = ptr[i]->homeTown > ptr[k]->homeTown;
            
            if(resultCompare > 0)
            {
                temp = ptr[i];
                ptr[i] = ptr[k];
                ptr[k] = temp;
            }
        }
        
    }
}

void display(Student *ptr[])
{
    cout << left << setw(20) << "Name" << left << setw(15) << "Student ID" << left << setw(10) << "Grade" << left << setw(25) << "Birthday" << left << setw(20) << "Home Town" << endl;
    
    cout << "-----------------------------------------------------------------------------------" << endl;
    
    for (int i = 0; i < 10; i++)
    {
        cout << left << setw(20) << (*ptr)->name << left << setw(15) << (*ptr)->ID << left << setw(10) << (*ptr)->grade << left << setw(25) << (*ptr)->bday.printDate() << left << setw(20) << (*ptr)->homeTown << endl;
        ptr++;
    }
    cout << endl;

}

int main() {
    srand(time(NULL));
    Student tenStudents[10];
    
    initStudents(tenStudents);
    
    Student *origin[10];
    Student *sortedName[10];
    Student *sortedID[10];
    Student *sortedGrade[10];
    Student *sortedBDay[10];
    Student *sortedHomeTown[10];
    
    for(int i = 0; i < 10; i++)
    {
        origin[i] = &tenStudents[i];
        sortedName[i] = &tenStudents[i];
        sortedID[i] = tenStudents + i;
        sortedGrade[i] = tenStudents + i;
        sortedBDay[i] = &tenStudents[i];
        sortedHomeTown[i] = &tenStudents[i];
    }
    
    int choice;
    bool runProgram = true;
    while (runProgram)
    {
        cout << endl;
        cout << "0: Display Original List" << endl;
        cout << "1: Display List Sorted by Name" << endl;
        cout << "2: Display List Sorted by Student ID" << endl;
        cout << "3: Display List Sorted by Grade" << endl;
        cout << "4: Display List Sorted by Birthday" << endl;
        cout << "5: Display List Sorted by Hometown" << endl;
        cout << "6: Exit" << endl;
        cin >> choice;
        cout << endl;
        
        if(choice == 0)
        {
            display(origin);
        }
        else if(choice == 1)
        {
            sort(sortedName, "name");
            display(sortedName);
        }
        else if(choice == 2)
        {
            sort(sortedID, "ID");
            display(sortedID);
        }
        else if(choice == 3)
        {
            sort(sortedGrade, "grade");
            display(sortedGrade);
        }
        else if(choice == 4)
        {
            sort(sortedBDay, "bday");
            display(sortedBDay);
        }
        else if(choice == 5)
        {
            sort(sortedHomeTown, "homeTown");
            display(sortedHomeTown);
        }
        else if(choice == 6)
        {
            cout << "Exiting..." << endl;
            runProgram = false;
        }
    }
    
    return 0;
}
