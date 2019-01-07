n = input('Enter a positive integer');
a = randi([-10000,10000], 1, n);
sortedA = heap_sort(a);
disp(sortedA);


n = 10000;
a = randi([-10000,10000], 1, n);
repeatedTimes = 100;

tic
for i = 1:repeatedTimes
    sortedA = heap_sort(a);
end
runningTime_HS = toc/repeatedTimes;

tic
for i = 1:repeatedTimes
    sortedA = selection_sort(a);
end
runningTime_SS = toc/repeatedTimes;

tic
for i = 1:repeatedTimes
    sortedA = quick_sort(a);
end
runningTime_QS = toc/repeatedTimes;