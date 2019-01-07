n = input('Enter a positive integer');
a = randi([-100,100], 1, n);
maxSum = MSS(a);
maxSum_nlogn = MSS_nlogn(a);
disp(maxSum);
disp(maxSum_nlogn);
