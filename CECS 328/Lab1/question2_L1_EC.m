a = input('Enter a binary array');
disp(splitPos(a));

function position = splitPos(a)
    left = 1;
    right = length(a);
    
    while(left <= right)
        mid = floor((left+right)/2);
        
        if(a(mid) == 0)
            left = mid + 1;
        else
            right = mid - 1;
        end
    end
    position = right;
end