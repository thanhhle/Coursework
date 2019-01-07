function a = heap_sort(a)
    a = build_MaxHeap(a);
    for i = length(a):-1:2
        temp = a(1);
        a(1) = a(i);
        a(i) = temp;
        a(1:i-1) = max_heapify(a(1:i-1), 1);
    end 
end


function a = build_MaxHeap(a)
    for i = ceil(length(a)/2):-1:1
        a = max_heapify(a, i);
    end
end


function a = max_heapify(a, i)
    max_index = i;
    left_index = 2*i;
    right_index = 2*i + 1;
    
    if(left_index <= length(a) && a(left_index) > a(max_index))
        max_index = left_index;
    end
    
    if(right_index <= length(a) && a(right_index) > a(max_index))
        max_index = right_index;   
    end
    
    if(max_index ~= i)
        temp = a(max_index);
        a(max_index) = a(i);
        a(i) = temp;
        a = max_heapify(a, max_index);
    end
end