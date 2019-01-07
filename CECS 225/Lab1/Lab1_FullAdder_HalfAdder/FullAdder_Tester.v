`timescale 1ns / 1ps

module FullAdder_Tester;

	// Inputs
	reg FA_A;
	reg FA_B;
	reg Cin;

	// Outputs
	wire FA_S;
	wire Cout;

	// Instantiate the Unit Under Test (UUT)
	FullAdder uut (
		.FA_A(FA_A), 
		.FA_B(FA_B), 
		.Cin(Cin), 
		.FA_S(FA_S), 
		.Cout(Cout)
	);

	initial begin
		// test case 0
		FA_A = 0;
		FA_B = 0;
		Cin = 0;
		#10;
		
		// test case 1
		FA_A = 0;
		FA_B = 1;
		Cin = 0;
		#10;
		
		// test case 2
		FA_A = 1;
		FA_B = 0;
		Cin = 0;
		#10;
		
		// test case 3
		FA_A = 1;
		FA_B = 1;
		Cin = 0;
		#10;
		
		// test case 4
		FA_A = 0;
		FA_B = 0;
		Cin = 1;
		#10;
		
		// test case 5
		FA_A = 0;
		FA_B = 1;
		Cin = 1;
		#10;
		
		// test case 6
		FA_A = 1;
		FA_B = 0;
		Cin = 1;
		#10;
		
		// test case 7
		FA_A = 1;
		FA_B = 1;
		Cin = 1;
		#10;
		$stop;
	end
      
endmodule

