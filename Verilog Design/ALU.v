
// This part is for verilog ALU.

module ALU(
input [17:0] inputone, //(source 1)this part is to store 18 bit data 
input [17:0] inputTwo, //(source 2)this part is to store 18 bit data 
input [1:0] choice, // choice function

output reg[17:0] result // the reason of that choice 'reg' instead of wire is that you plan to assign your output in sequential code.

);
always @(*) begin
case(choice)
      2'b00: result = inputone + inputTwo; // add  
      2'b01: result = inputone & inputTwo; // and 
      2'b10: result = inputone | inputTwo; // or  
      2'b11: result = inputone ^ inputTwo; // xor  

      default:result = inputone + inputTwo; // default u yazmay?nca hata veriyordu asl?nda bo?ta case yok.
      endcase 

end

endmodule
