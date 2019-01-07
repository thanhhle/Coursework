% n = 10^5
disp('n = 10^5');
n = 10^5;
a = randi([-1000,1000], 1, n);
sortedA = sort(a);
key = 5000;

% Calculate worst-case running time of LinearSearch function when n = 10^5
tic
    linearSearch(sortedA, key);
runningTimeLS = toc;
fprintf('runningTimeLS when n = 10^5: ');
disp(runningTimeLS);


% Calculate worst-case running time of BinarySearch function when n = 10^5
tic
    binarySearch(sortedA, key);
runningTimeBS = toc;
fprintf('runningTimeBS when n = 10^5: ');
disp(runningTimeBS);


disp('-----------------------------------------------------------------------');
% Calculate worst-case running time per step of BinarySearch function
runningTimePerStepLS = runningTimeLS/n;
fprintf('runningTimeLS for each step =');
disp(runningTimePerStepLS);


% Calculate worst-case running time per step of BinarySearch function
runningTimePerStepBS = runningTimeBS/log2(n);
fprintf('runningTimeBS for each step =');
disp(runningTimePerStepBS);


disp('-----------------------------------------------------------------------');
% Estimate the running time of BinarySearch function when n = 10^7
fprintf('estimatedRunningTimeLS when n = 10^7: ');
estimatedRunningTimeLS = runningTimePerStepLS * 10^7;
disp(estimatedRunningTimeLS);

fprintf('estimatedRunningTimeBS when n = 10^7: ');
estimatedRunningTimeBS = runningTimePerStepBS * log2(10^7);
disp(estimatedRunningTimeBS);


disp('-----------------------------------------------------------------------');
% n = 10^7
disp('n = 10^7');
n = 10^7;
a = randi([-1000,1000], 1, n);
sortedA = sort(a);
key = 5000;

% Calculate worst-case running time of LinearSearch function
tic
    linearSearch(sortedA, key);
runningTimeLS = toc;
fprintf('runningTimeLS when n = 10^7: ');
disp(runningTimeLS);

% Calculate worst-case running time of BinarySearch function
tic
    binarySearch(sortedA, key);
runningTimeBS = toc;
fprintf('runningTimeBS when n = 10^7: ');
disp(runningTimeBS);