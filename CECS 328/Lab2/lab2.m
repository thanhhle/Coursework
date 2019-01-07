n = input('Enter a positive integer');
a = randi([-7000,7000], 1, n);
sortedInsertion = insertion_sort(a);
sortedQuick = quick_sort(a);

% Calculate average-running time of insertion_sort(a) and quick_sort(a) function when n = 10000
n = 26500;
a = randi([-7000,7000], 1, n);
repeatedTimes = 100;

tic
for i = 1:repeatedTimes
    sortedA = insertion_sort(a);
end
averageRunningTimeIS = toc/repeatedTimes;
fprintf('averageRunningTimeIS when n = 10000:');
disp(averageRunningTimeIS);

tic
for i = 1:repeatedTimes
    sortedA = quick_sort(a);
end
averageRunningTimeQS = toc/repeatedTimes;
fprintf('averageRunningTimeQS when n = 10000:');
disp(averageRunningTimeQS);

% Calculate number of instructions the mechine can run in 1s, T(n) of InsertionSort = n^2
runningTimePerStepIS = averageRunningTimeIS/(n^2); 
numOfInstruction = floor(sqrt(1/runningTimePerStepIS));
fprintf('Number of instructions the machine can run in 1s using the running time of Insertion Sort:');
disp(numOfInstruction);