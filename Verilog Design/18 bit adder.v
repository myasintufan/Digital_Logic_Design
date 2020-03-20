module 18_bit_adder
(
  input [17:0] a,
  input [17:0] b,
  output [17:0] sum,
  output carry
);

  
  wire carry0,
  wire carry1,
  wire carry2,
  wire carry3,
  wire carry4,
  wire carry5,
  wire carry6,
  wire carry7,
  wire carry8,
  wire carry9,
  wire carry10,
  wire carry11,
  wire carry12,
  wire carry13, 
  wire carry14,
  wire carry15,
  wire carry16,
  wire carry17;
  

  // The first carry is 0
  assign carry0 = 1'b0;

  
  half_adder op1 (A[0], B[0], carry0, sum[0]);
  full_adder op2 (A[1], B[1], carry1, sum[1], carry2);
  full_adder op3 (A[2], B[2], carry2, sum[2], carry3);
  full_adder op4 (A[3], B[3], carry3, sum[3], carry4);
  full_adder op5 (A[4], B[4], carry4, sum[4], carry5);
  full_adder op6 (A[5], B[5], carry5, sum[5], carry6);
  full_adder op7 (A[6], B[6], carry6, sum[6], carry7);
  full_adder op8 (A[7], B[7], carry7, sum[7], carry8);
  full_adder op9 (A[8], B[8], carry8, sum[8], carry9);
  full_adder op10 (A[9], B[9], carry9, sum[9], carry10);
  full_adder op11 (A[10], B[10], carry10, sum[10], carry11);
  full_adder op12 (A[11], B[11], carry11, sum[11], carry12);
  full_adder op13 (A[12], B[12], carry12, sum[12], carry13);
  full_adder op14 (A[13], B[13], carry13, sum[13], carry14);
  full_adder op15 (A[14], B[14], carry14, sum[14], carry15);
  full_adder op16 (A[15], B[15], carry15, sum[15], carry16);
  full_adder op17 (A[16], B[16], carry16, sum[16], carry17);
 
  
endmodule


module half_adder(
 output c_out,   //carry-out
 output s,   //sum
 input a,
 input b
);
 xor(S,a,b);
 and(C,a,b);
endmodule


module full_adder(
 output sum,
 output c_out,
 input a,
 input b,
 input c_in);

  wire wire_0,
  wire wire_1,
  wire wire_2;
  
  xor  (wire_0, a, b);
  xor  (sum, wire_0, c_in);
  
  and  (wire_1, wire_0, c_in);
  and  (wire_2, a, b);
  or  (c_out, wire_1, wire_2);


endmodule


