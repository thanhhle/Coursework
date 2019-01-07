function maxSum = MSS_nlogn(a)
    if(length(a) == 1)
        maxSum = a(1);
    else
        index = ceil(length(a)/2);
        MSS_left = MSS_nlogn(a(1:index));
        MSS_right = MSS_nlogn(a(index+1:length(a)));
        MSS_m = 0;
        
        temp = 0;
        for i = index:-1:1
            temp = temp + a(i);
            if(temp > MSS_m)
                MSS_m = temp;
            end
        end
        
        temp = MSS_m;
        for i = index+1:length(a)
            temp = temp + a(i);
            if(temp > MSS_m)
                MSS_m = temp;
            end
        end
        
        maxSum = max(max(MSS_left, MSS_right), MSS_m);
    end
end