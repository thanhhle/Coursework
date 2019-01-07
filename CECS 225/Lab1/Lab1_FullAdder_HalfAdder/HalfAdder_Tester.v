`timescale 1ns / 1ps

module HalfAdder_Tester;

	// Inputs
	reg A;
	reg B;

	// Outputs
	wire Cout;
	wire S;

	// Instantiate the Unit Under Test (UUT)
	HalfAdder uut (
		.A(A), 
		.B(B), 
		.Cout(Cout), 
		.S(S)
	);

	initial begin
		// test case 0
		A = 0;
		B = 0;
		#10;		//wait 10 time units

		A = 0;
		B = 1;
		#10;		//wait 10 time units
		
		A = 1;
		B = 0;
		#10;		//wait 10 time units
		
		A = 1;
		B = 1;
		#10;		//wait 10 time units
		$stop;		//eng the stimulation
	end
      
endmodule

