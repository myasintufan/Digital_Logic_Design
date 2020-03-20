module 18_Bit_XOR
(
 input[17:0] a,
 input[17:0] b,
 output[17:0] result
);
 wire bit0;
 wire bit1;
 wire bit2;
 wire bit3;
 wire bit4;
 wire bit5;
 wire bit6;
 wire bit7;
 wire bit8;
 wire bit9;
 wire bit10;
 wire bit11;
 wire bit12;
 wire bit13;
 wire bit14;
 wire bit15;
 wire bit16;
 wire bit17;
 
 xor A0 (bit0,A[0], B[0]);
 xor A1 (bit1,A[1], B[1]);
 xor A2 (bit2,A[2], B[2]);
 xor A3 (bit3,A[3], B[3]);
 xor A4 (bit4,A[4], B[4]);
 xor A5 (bit5,A[5], B[5]);
 xor A6 (bit6,A[6], B[6]);
 xor A7 (bit7,A[7], B[7]);
 xor A8 (bit8,A[8], B[8]);
 xor A9 (bit9,A[9], B[09]);
 xor A10 (bit10,A[10], B[10]);
 xor A11 (bit11,A[11], B[11]);
 xor A12 (bit12,A[12], B[12]);
 xor A13 (bit13,A[13], B[13]);
 xor A14 (bit14,A[14], B[14]);
 xor A15 (bit15,A[15], B[15]);
 xor A16 (bit16,A[16], B[16]);
 xor A17 (bit17,A[17], B[17]);

endmodule

