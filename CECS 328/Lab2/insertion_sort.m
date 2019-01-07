function sortedArray = insertion_sort(a)
    for i = 1:(length(a)-1)
        while(i > 0 && a(i+1) < a(i))
            temp = a(i);
            a(i) = a(i+1);
            a(i+1) = temp;
            i = i - 1;
        end
    end
    sortedArray = a;
end