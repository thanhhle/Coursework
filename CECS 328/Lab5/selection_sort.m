function a = selection_sort(a)
    for i = 1:length(a)-1
        minIndex = i;
        for k = i+1:length(a)
            if(a(k) < a(minIndex))
                minIndex = k;
            end
        end
        
        if(minIndex ~= i)    
            temp = a(i);
            a(i) = a(minIndex);
            a(minIndex) = temp;
        end
    end
end