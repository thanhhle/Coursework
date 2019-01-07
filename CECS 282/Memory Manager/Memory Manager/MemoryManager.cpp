
#include "MemoryManager.h"

#include <iomanip>
#include <iostream>
using namespace std;

namespace MemoryManager
{
    // IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT
    //
    // This is the only static memory that you may use, no other global variables
    // may be created, if you need to save data make it fit in MM_pool
    //
    // IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT IMPORTANT
    
    const int MM_POOL_SIZE = 65536;
    char MM_pool[MM_POOL_SIZE];
    
    // I have provided this tool for your use
    void memView(int start, int end)
    {
        const unsigned int SHIFT = 8;
        const unsigned int MASK = 1 << (SHIFT - 1);
        
        unsigned int value;	// used to facilitate bit shifting and masking
        
        cout << "         Pool                     Unsignd  Unsigned " << endl;
        cout << "Mem Add     indx   bits   chr ASCII#  short      int    " << endl;
        cout << "----------- ---- -------- --- ------ ------- ------------" << endl;
        
        for (int i = start; i <= end; i++)
        {
            cout << (long*)(MM_pool + i) << ':';	// the actual address in hexadecimal
            cout << '[' << setw(2) << i << ']';		// the index into MM_pool
            
            value = MM_pool[i];
            cout << " ";
            for (int j = 1; j <= SHIFT; j++)	// the bit sequence for this byte (8 bits)
            {
                cout << ((value & MASK) ? '1' : '0');
                value <<= 1;
            }
            cout << " ";
            
            cout << "| " << *(char*)(MM_pool + i) << "| (";	// the ASCII character of the 8 bits (1 byte)
            cout << setw(4) << ((int)(*((unsigned char*)(MM_pool + i)))) << ")";// the ASCII number of the character
            
            cout << " (" << setw(5) << (*(unsigned short*)(MM_pool + i)) << ")";// the unsigned short value of 16 bits (2 bytes)
            cout << " (" << setw(10) << (*(unsigned int*)(MM_pool + i)) << ")";	// the unsigned int value of 32 bits (4 bytes)
            
            cout << endl;
        }
    }
    
    // Initialize set up any data needed to manage the memory pool
    void initializeMemoryManager(void)
    {
        int freeHead = 0;       // starting index of the freelist
        int inUseHead = 2;      // starting index of the inUselist
        int usedHead = 4;       // starting index for the used list - deallocated memory
        
        int nextLink = 2;       // offset index of the next link
        int prevLink = 4;       // offset index of the prev link
        
        *(unsigned short*)(MM_pool + freeHead) = 6;                 // freelist starts at byte 6
        *(unsigned short*)(MM_pool + 6) = MM_POOL_SIZE - 6;         // we used 6 bytes to start things
        *(unsigned short*)(MM_pool + inUseHead) = 0;                // nothing in the inUse list yet
        *(unsigned short*)(MM_pool + usedHead) = 0;                 // nothing in the used list yet
        
    }
    
    // Return a pointer inside the memory pool
    // If no chunk can accommodate aSize call onOutOfMemory()
    void* allocate(int aSize)
    {
        if(freeMemory() == 0)
            onOutOfMemory();
        
        int allocatedIndex = *(unsigned short*)(MM_pool);
        
        // size = aSize
        *(unsigned short*)(MM_pool + allocatedIndex) = aSize;
        
        // next = inUseHead
        *(unsigned short*)(MM_pool + allocatedIndex + 2) = *(unsigned short*)(MM_pool + 2);
        
        // prev = 0
        *(unsigned short*)(MM_pool + allocatedIndex + 4) = 0;
    
        // inUseHead = freeHead
        *(unsigned short*)(MM_pool + 2) = allocatedIndex;
        
        // freeHead = freeHead + 6 + aSize
        *(unsigned short*)(MM_pool) += aSize + 6;
        
        // if NOT first stored pointer: prev of next node =  inUsedHead
        if(allocatedIndex != 6)
            *(unsigned short*)(MM_pool + (*(unsigned short*)(MM_pool + allocatedIndex + 2) + 4)) = *(unsigned short*)(MM_pool + 2);

        return (void*)(MM_pool + (allocatedIndex + 6));
    }
    
    
    // Free up a chunk previously allocated memory
    void deallocate(void* aPointer)
    {
        int prev = *(unsigned short*)((char*)aPointer - 2);
        int next = *(unsigned short*)((char*)aPointer - 4);
        int deallocatedIndex = *(unsigned short*)(MM_pool + prev + 2);
        
        // next of prev code = next node (prev = 0: inUsedHead = next)
        *(unsigned short*)(MM_pool + prev + 2) = *(unsigned short*)(MM_pool + deallocatedIndex + 2);
        
        // prev of next node = prev node
        if(next != 0)
            *(unsigned short*)(MM_pool + next + 4) = *(unsigned short*)(MM_pool + deallocatedIndex + 4);
        
        // prev = 0
        *(unsigned short*)(MM_pool + deallocatedIndex + 4) = 0;
        
        // next = usedHead
        *(unsigned short*)(MM_pool + deallocatedIndex + 2) = *(unsigned short*)(MM_pool + 4);
        
        // prev of usedHead(next node) = index
        *(unsigned short*)(MM_pool + *(unsigned short*)(MM_pool + 4) + 4) = deallocatedIndex;
        
        // usedHead = index
        *(unsigned short*)(MM_pool + 4) = deallocatedIndex;
    }
    
    
    // Scan the memory pool and return the total free space remaining in bytes
    int freeMemory(void)
    {
        return MM_POOL_SIZE - *(unsigned short*)(MM_pool + 0);
    }
    
    
    // Scan the memory pool and return the total deallocated memory in bytes
    int usedMemory(void)
    {
        int count = 0;
        int next = *(unsigned short*)(MM_pool + 4);
        
        while(next != 0)
        {
            count += *(unsigned short*)(MM_pool + next) + 6;
            next = *(unsigned short*)(MM_pool + next + 2);
        }
        
        return count;
    }
    
    
    // Scan the memory pool and return the total in use memory
    int inUseMemory(void)
    {
        int count = 0;
        int next = *(unsigned short*)(MM_pool + 2);

        while(next != 0)
        {
            count += *(unsigned short*)(MM_pool + next) + 6;
            next = *(unsigned short*)(MM_pool + next + 2);
        }
        
        return count;
    }
    
    
    // Return the size (in bytes) associated with this memory address
    int size(void * aPointer)
    {
        return *(unsigned short*)((char*)aPointer - 6);
    }
    
    
    // This is called when no more memory is available to allocate
    void onOutOfMemory(void)
    {
        std::cerr << "/nMemory pool out of memory" << std::endl;
        cin.get( );
        exit(1);
    }
}


