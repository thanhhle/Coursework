n = input('Enter a positive integer');
a = randi([-100,100], 1, n);
disp(a);
k = input('Enter a number k between 1 and n');
number = quick_selected(a, k);
fprintf('\nThe k^th least element:');
disp(number);

function num = quick_selected(a, k)
    if(length(a) > 1)
        [aLeft, aRight] = partition(a);
        if(k < (length(aLeft)+1))
            num = quick_selected(aLeft, k);
        elseif(k > (length(aLeft)+1))
            num = quick_selected(aRight, k - (length(aLeft)+1));
        else
            num = a(1);
        end
    else
        num = a(1);
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