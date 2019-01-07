function maxSum = MSS(a)
    maxSum = a(1);
    temp = 0;
    for i = 1:length(a)
        temp = temp + a(i);
        if(temp > maxSum)
            maxSum = temp;
        end
        
        if(temp < 0)
            temp = 0;
        end
    end
end