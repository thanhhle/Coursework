n = input('Enter an integer');
disp(ceil_sqrt(n));

function answer = ceil_sqrt(n)
    if(n == 0 || n == 1)
        answer = n;
        return;
    else
        left = 1;
        right = n;
        while(left <= right)
            if(mod(left + right, 2) == 1)
                mid = (left + right + 1)/2;
            else
                mid = (left + right)/2;
            end
        
            if(mid*mid == n)
                answer = mid;
                return;
            elseif(mid*mid < n)
                left = mid + 1;
            else   
                right = mid - 1;
                answer = mid;
            end
        end   
    end
end