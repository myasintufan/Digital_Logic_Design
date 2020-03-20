module control_unit (
	input[3:0]  opcode,
        input clock,

  	 output reg[1:0] aluOp,
         output reg jump, memLoad, memSt ,memAlu,regWrite ,aluControl, immSignal
	  ,greater,less,equal,branchSig,beq,blt,bgt,ble,bge,branchMux ,
       PC_WE,IR_WE 
);

always @(posedge clock)
begin

	case(opcode) 

 	4'h0:  // ADD part 
 	  begin
		regWrite = 1'b1;
		aluControl =  2'b00;
	   end

	 4'h1:  // ADDI part
   	begin
		regWrite = 1'b1;
		immSignal = 1'b1;
		aluControl =  2'b00;
           end

         4'h2:  // AND part
         begin
                regWrite = 1'b1;
                aluControl =  2'b01;
           end

         4'h3:  // ANDI part 
         begin
              	regWrite = 1'b1;
		immSignal = 1'b1;
		aluControl =  2'b01;
   	end

	4'h4:  // OR part
  	 begin
		regWrite = 1'b1;
		aluControl =  2'b10;
  	 end
	
 	4'h5:  // ORI part
   	begin
		regWrite = 1'b1;
		immSignal = 1'b1;
		aluControl =  2'b10;
  	 end

	4'h6:  // XOR part
  	 begin
		regWrite = 1'b1;
		aluControl =  2'b11;
  	 end

	 4'h7:  // XORI part
 	  begin
		regWrite = 1'b1;
		immSignal = 1'b1;
		aluControl =  2'b11;
	   end

 	4'h8:  // JUMP part
	begin
  		jump = 1'b1;
 	  end

 	4'h9:  // LD part 
  	 begin
		regWrite = 1'b1;
		memLoad = 1'b1;
		memAlu = 1'b1;
     
   	end

	 4'ha:  // ST part
  	 begin
		regWrite = 1'b1;
		memSt = 1'b1;
		memAlu = 1'b1;
   	end

 	4'hb:  // beq part
  	 begin
	if(equal == 1'b1 )
	begin 
		branchSig =1'b1;
	end
   		regWrite = 1'b0; 
  		 branchMux = 1'b1; 
  	 end

 	4'hc:  // blt part
  	 begin
	if(less == 1'b1 )
	begin 
		branchSig =1'b1;
	end
		regWrite = 1'b0;
		branchMux = 1'b1; 
    end

 	4'hd:  // bgt part
  	 begin
	if(greater == 1'b1 )
	begin 
		branchSig =1'b1;
	end
 	  regWrite = 1'b0;
  	 branchMux = 1'b1; 
   end 

 4'he:  // ble part
   begin
if(equal == 1'b1 || less == 1'b1 )
	begin 
		branchSig =1'b1;
end
    		 regWrite = 1'b0;
   		  branchMux = 1'b1; 
   end
   
  4'hf:  // bge part
   begin
	if(equal == 1'b1 || greater == 1'b1 )
begin 
		branchSig =1'b1;
end
     regWrite = 1'b0;
     branchMux = 1'b1; 
   end 

 endcase
 end
             always @(posedge clock) begin
		PC_WE = 1'b1;
		IR_WE = 1'b0;
               end
		
	    always @( negedge clock) begin
		PC_WE = 1'b0;
		IR_WE = 1'b1;
              end
		


 

endmodule







