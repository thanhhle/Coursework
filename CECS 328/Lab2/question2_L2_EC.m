n = 7;
disp("n = "); 
disp(n);
m = input('Enter a positive integer m > n');
a = randi([0, m], 1, n);
a = unique(a);
while(length(a) ~= n)
    a = randi([0, m], 1, n);
    a = unique(a);
end
number = findSmallestMissing(a);
disp("a = ");
disp(a);
disp("The smallest missing is");
disp(number);

function num = findSmallestMissing(a)
    if(length(a) <= 1 || a(1) ~= 0)
        num = 0;
        return;
    else
        left = 1;
        right = length(a);
        while(right - left >= 2)
            mid = floor((left + right)/2);
            if(a(mid) == (mid-1))
                left = mid;   
            else
                right = mid;
            end
        end
  
        if(a(right) - a(left) ~= 1) 
             num = a(left) + 1;
        else
             num = a(right) + 1;
        end
    end
end