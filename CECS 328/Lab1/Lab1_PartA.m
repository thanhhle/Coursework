n = input('Enter a positive integer');
a = randi([-1000,1000], 1, n);
sortedA = sort(a);
repeatedTimes = 500;

% Calculate average-running time of LinearSearch function
tic
for i = 1:repeatedTimes
    key = sortedA(randi(length(sortedA)));
    linearSearch(sortedA, key);
end
averageRunningTimeLS = toc/500;
fprintf('averageRunningTimeLS =');
disp(averageRunningTimeLS);

% Calculate average-running time of BinarySearch function
tic
for i = 1:repeatedTimes
    key = sortedA(randi(length(sortedA)));
    binarySearch(sortedA, key);
end
averageRunningTimeBS = toc/500;
fprintf('averageRunningTimeBS =');
disp(averageRunningTimeBS);