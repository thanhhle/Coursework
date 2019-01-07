a1 = [0, 2, 10, 26, 68];
a2 = [1, 11, 18, 20, 41];

a3 = [5, 6, 14, 26];
a4 = [3, 41, 88, 100];

a5 = [5, 10];
a6 = [2, 41];

median1 = getMedian(a1, a2);
median2 = getMedian(a3, a4);
median3 = getMedian(a5, a6);

function median = getMedian(a1, a2)
    if(length(a1) <= 2 && length(a2) <= 2)
        median = (max(a1(1), a2(1)) + min(a1(2), a2(2)))/2;
        return;
    end
    
    mIndex = floor((length(a1) + 1)/2);
    m1 = a1(mIndex);
    m2 = a2(mIndex);
    
    if(m1 == m2)
        median = m1;
    elseif(m1 > m2)
        if(mod(length(a1), 2) == 1)
            a1 = a1(1:mIndex);
        else
            a1 = a1(1:(mIndex + 1));
        end
        a2 = a2(mIndex:length(a2));
        median = getMedian(a1, a2);
    else
        if(mod(length(a1), 2) == 1)
            a2 = a2(1:mIndex);
        else
            a2 = a2(1:(mIndex + 1));
        end
        a1 = a1(mIndex:length(a1));
        median = getMedian(a1, a2);
    end
end