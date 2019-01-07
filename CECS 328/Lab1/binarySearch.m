function index = binarySearch(a, key)
    left = 1;
    right = length(a);
    index = -1;
    
    while(left <= right)
        mid = floor((left + right)/2);
        if(key < a(mid))
            right = mid - 1;
        elseif(key > a(mid))
            left = mid + 1;
        else
            index = mid;
            return;
        end
    end
end