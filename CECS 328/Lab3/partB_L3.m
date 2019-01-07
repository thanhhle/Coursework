n = 10;
a = randi([-100,100], 1, n);
k = 3;
nums = find_max_numbers(a, k);

function nums = find_max_numbers(a, k)
    if(k == 1 || length(a) == 1)
        nums = a(length(a));
    elseif(length(a) > k)
        [aLeft, aRight] = partition(a);
        if(length(aRight) == k)
            nums = aRight;
        elseif(length(aRight) < k)
            nums = [find_max_numbers([aLeft, a(1)], k - length(aRight)), aRight];
        else
            nums = find_max_numbers(aRight, k);
        end
    else
        nums = a;
    end
end

function [aLeft, aRight] = partition(a)
    aLeft = [];
    aRight = [];
    pivotIndex = 1;
    
    for i = 2:length(a)
        if(a(i) <= a(pivotIndex))
            aLeft = [aLeft, a(i)];
        else
            aRight = [aRight, a(i)];
        end
    end
end