function sortedArray = quick_sort(a)
    if(length(a) >= 3)
        pivotIndex = findPivotIndex(a);
        [aLeft, aRight] = partition(a, pivotIndex);
        sortedArray = [quick_sort(aLeft), a(pivotIndex), quick_sort(aRight)];
    elseif(length(a) == 2 && a(1) > a(2))
        sortedArray = swap(a, 1, 2);
    else
        sortedArray = a;
    end
end

function [aLeft, aRight] = partition(a, pivotIndex)
    aLeft = [];
    aRight = [];
    a = swap(a, pivotIndex, length(a));
    pivotIndex = length(a);
    
    for i = 1:(length(a)-1)
        if(a(i) <= a(pivotIndex))
            aLeft = [aLeft, a(i)];
        else
            aRight = [aRight, a(i)];
        end
    end
end

function pivotIndex = findPivotIndex(a)   
    left = 1;
    center = floor(length(a)/2);
    right = length(a);
    
    if(a(left) > a(center))
        a = swap(a, left, center);
    end
    
    if(a(center) > a(left))
        a = swap(a, center, left);
    end
    
    pivotIndex = floor(length(a)/2);
end

function a = swap(a, index1, index2)
    temp = a(index1);
    a(index1) = a(index2);
    a(index2) = temp;
end