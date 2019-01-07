`timescale 1ns / 1ps

module HalfAdder(A, B, Cout, S);
	input		A, B;
	output	Cout, S;
	
	assign	Cout = A & B;
	assign	S = A ^ B;

endmodule
