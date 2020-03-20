module 18_Bit_AND
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
 
 and A0 (bit0,A[0], B[0]);
 and A1 (bit1,A[1], B[1]);
 and A2 (bit2,A[2], B[2]);
 and A3 (bit3,A[3], B[3]);
 and A4 (bit4,A[4], B[4]);
 and A5 (bit5,A[5], B[5]);
 and A6 (bit6,A[6], B[6]);
 and A7 (bit7,A[7], B[7]);
 and A8 (bit8,A[8], B[8]);
 and A9 (bit9,A[9], B[09]);
 and A10 (bit10,A[10], B[10]);
 and A11 (bit11,A[11], B[11]);
 and A12 (bit12,A[12], B[12]);
 and A13 (bit13,A[13], B[13]);
 and A14 (bit14,A[14], B[14]);
 and A15 (bit15,A[15], B[15]);
 and A16 (bit16,A[16], B[16]);
 and A17 (bit17,A[17], B[17]);


endmodule

