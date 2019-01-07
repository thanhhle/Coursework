function index = linearSearch(a, key)
    for i = 1:length(a)
        if(a(i) == key)
            index = i;
            break;
        end
        index = -1;
    end 
end
