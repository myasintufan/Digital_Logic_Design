

/*
Mert ismail Eği  150115025
Malik Türkoğlu   150116044
Muhammed Yasin Tufan 150116013

 */
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
public class Assembler {
    public static void main (String[] args) throws IOException {
        //file input-output
        List<String> lines = new ArrayList<String>();
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");


        if(inputFile.exists()){
            try {
                lines = Files.readAllLines(inputFile.toPath(),Charset.defaultCharset());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if(lines.isEmpty())
                return;
        }

            String binaryFile = convertAssembler(lines);
            Files.write(outputFile.toPath(), binaryFile.getBytes());

    }


    public static String convertAssembler(List<String> lines){
        String[] lineArray = new String[lines.size()];
        lineArray= lines.toArray(lineArray);
        String[][] opCodeList=new String[lines.size()][lines.size()];
        String[] operationElement = null,dataElement = null;
        //getting components
        for(int a=0;a<lines.size();a++) {

            String row=lines.get(a);
            operationElement=row.split(" ");
            for(String y:operationElement) {
                dataElement= y.split(",");
                int b=1;
                for(String i:dataElement) {
                    opCodeList[a][b]=i;
                    b++;
                }
            }
            opCodeList[a][0]=operationElement[0];
        }
        String tempStringLine="",opcode;
        String result = "";
        //loop for all lines getting binary code
        for(int a=0;a<lines.size();a++) {
            opcode=opCodeList[a][0]; //assign opcode
            int count=0; // get length for new array
            for(int b=0;b<opCodeList[a].length;b++) {
                if(opCodeList[a][b]!=null) {count++;}
            }
            String[] elementArray = new String[count-1];
            for(int c=0;c<elementArray.length;c++) {elementArray[c]=opCodeList[a][c+1];}


            String immediateValue=null,oneOrZero=null,addressRegister=null,operation1=null,operation2=null;
            String destinationRegister=null,sourceRegister=null,sourceRegister1=null,sourceRegister2=null;
            String n=null,z=null,p=null;
                   //  This part is Instractions.
                    if (opcode.equalsIgnoreCase("ADD")) {
                        tempStringLine = tempStringLine.concat("0000");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        sourceRegister2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[2]))));
                        sourceRegister2 = getFourBits(sourceRegister2);
                        tempStringLine = tempStringLine.concat(sourceRegister2);
                        tempStringLine = tempStringLine.concat("" + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1));
                        // System.out.println("\nHİİİ: "+ destinationRegister);
                        tempStringLine = tempStringLine.concat("00"); // To complete 18 bit

                    }

                    if (opcode.equalsIgnoreCase("ADDI")) {
                        tempStringLine = tempStringLine.concat("0001");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        int immediateADDI = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        //  System.out.println("\nXXX: " + seperateRegisterAdress(elementArray[2]));
                        if (immediateADDI < 0) {
                            oneOrZero = "1";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString((128 - Math.abs(immediateADDI))));
                        } else {
                            oneOrZero = "0";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString(((immediateADDI))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        immediateValue = getSevenBits(immediateValue);
                        tempStringLine = tempStringLine.concat(immediateValue);

                    }

                    if (opcode.equalsIgnoreCase("AND")) {
                        tempStringLine = tempStringLine.concat("0010");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        sourceRegister2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[2]))));
                        sourceRegister2 = getFourBits(sourceRegister2);
                        tempStringLine = tempStringLine.concat(sourceRegister2);
                        tempStringLine = tempStringLine.concat("" + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1));
                        tempStringLine = tempStringLine.concat("00"); // To complete 18 bit

                    }

                    if (opcode.equalsIgnoreCase("ANDI")) {
                        tempStringLine = tempStringLine.concat("0011");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        int immediateANDI = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        if (immediateANDI < 0) {
                            oneOrZero = "1";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString((128 - Math.abs(immediateANDI))));
                        } else {
                            oneOrZero = "0";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString(((immediateANDI))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        immediateValue = getSevenBits(immediateValue);
                        tempStringLine = tempStringLine.concat(immediateValue);

                    }

                    if (opcode.equalsIgnoreCase("OR")) {
                        tempStringLine = tempStringLine.concat("0100");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        sourceRegister2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[2]))));
                        sourceRegister2 = getFourBits(sourceRegister2);
                        tempStringLine = tempStringLine.concat(sourceRegister2);
                        tempStringLine = tempStringLine.concat("" + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1));
                        tempStringLine = tempStringLine.concat("00"); // To complete 18 bit

                    }

                    if (opcode.equalsIgnoreCase("ORI")) {
                        tempStringLine = tempStringLine.concat("0101");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        int immediateORI = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        if (immediateORI < 0) {

                            oneOrZero = "1";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString((128 - Math.abs(immediateORI))));
                        } else {
                            oneOrZero = "0";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString(((immediateORI))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        immediateValue = getSevenBits(immediateValue);
                        tempStringLine = tempStringLine.concat(immediateValue);

                    }
                    if (opcode.equalsIgnoreCase("XOR")){

                    tempStringLine = tempStringLine.concat("0110");
                    destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                    destinationRegister = getFourBits(destinationRegister);
                    tempStringLine = tempStringLine.concat(destinationRegister);
                    sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                    sourceRegister1 = getFourBits(sourceRegister1);
                    tempStringLine = tempStringLine.concat(sourceRegister1);
                    sourceRegister2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[2]))));
                    sourceRegister2 = getFourBits(sourceRegister2);
                    tempStringLine = tempStringLine.concat(sourceRegister2);
                    tempStringLine = tempStringLine.concat("" + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1) + (int) (Math.random() * 1));
                    tempStringLine = tempStringLine.concat("00"); // To complete 18 bit

            }

                    if(opcode.equalsIgnoreCase("XORI")) {
                        tempStringLine = tempStringLine.concat("0111");
                        destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        destinationRegister = getFourBits(destinationRegister);
                        tempStringLine = tempStringLine.concat(destinationRegister);
                        sourceRegister1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        sourceRegister1 = getFourBits(sourceRegister1);
                        tempStringLine = tempStringLine.concat(sourceRegister1);
                        int immediateXORI = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        if (immediateXORI < 0) {
                            oneOrZero = "1";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString((128 - Math.abs(immediateXORI))));
                        } else {
                            oneOrZero = "0";
                            immediateValue = "" + "" + Integer.parseInt(Integer.toBinaryString(((immediateXORI))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        immediateValue = getSevenBits(immediateValue);
                        tempStringLine = tempStringLine.concat(immediateValue);

                    }
                if(opcode.equalsIgnoreCase("LD")) {
                    tempStringLine = tempStringLine.concat("1001");
                    destinationRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                    destinationRegister = getFourBits(destinationRegister);
                    tempStringLine = tempStringLine.concat(destinationRegister);
                    int addressLD = Integer.parseInt(seperateRegisterAdress(elementArray[1]));
                    if (addressLD < 0) {
                        oneOrZero = "1";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((1024 - Math.abs(addressLD))));
                    } else {
                        oneOrZero = "0";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressLD))));
                    }
                    tempStringLine = tempStringLine.concat(oneOrZero);
                    addressRegister = getTenBits(addressRegister);
                    tempStringLine = tempStringLine.concat(addressRegister);
                }

                if(opcode.equalsIgnoreCase("ST")) {
                    tempStringLine = tempStringLine.concat("1010");
                    sourceRegister = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                    sourceRegister = getFourBits(sourceRegister);
                    tempStringLine = tempStringLine.concat(sourceRegister);
                    int addressST = Integer.parseInt(seperateRegisterAdress(elementArray[1]));
                    if (addressST < 0) {
                        oneOrZero = "1";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((1024 - Math.abs(addressST))));
                    } else {
                        oneOrZero = "0";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressST))));
                    }
                    tempStringLine = tempStringLine.concat(oneOrZero);
                    addressRegister = getTenBits(addressRegister);
                    tempStringLine = tempStringLine.concat(addressRegister);

                }

                    if(opcode.equalsIgnoreCase("JUMP")) {
                        tempStringLine = tempStringLine.concat("1000");
                        int addressJUMP = Integer.parseInt(seperateRegisterAdress(elementArray[0]));
                    //    System.out.println("\nXXXX:"+ addressJUMP);
                        if (addressJUMP < 0) {
                            oneOrZero = "1";
                          //  System.out.println("Hİİİİİİİİİİİİİ");
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((1024 - Math.abs(addressJUMP))));
                        } else {
                            oneOrZero = "0";
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressJUMP))));
                        }

                        tempStringLine = tempStringLine.concat(oneOrZero);
                        addressRegister = getFourteenBits(addressRegister);
                        tempStringLine = tempStringLine.concat(addressRegister);

                    }

                    if(opcode.equalsIgnoreCase("BEQ")) {
                        tempStringLine = tempStringLine.concat("1111");
                        n="0";z="1";p="0";
                        operation1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        operation1 = getFourBits(operation1);
                        tempStringLine = tempStringLine.concat(operation1);
                        operation2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        operation2 = getFourBits(operation2);
                        tempStringLine = tempStringLine.concat(operation2);
                        int addressBEQ = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        if (addressBEQ < 0) {
                            oneOrZero = "1";
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((16 - Math.abs(addressBEQ))));
                        } else {

                            oneOrZero = "0";
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressBEQ))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        addressRegister = getFourBits(addressRegister);
                        tempStringLine = tempStringLine.concat(addressRegister);
                        tempStringLine = tempStringLine.concat(n+""+z+""+p);

                    }

                    if(opcode.equalsIgnoreCase("BLT")) {
                        n="1";z="0";p="0";
                        tempStringLine = tempStringLine.concat("1111");
                        operation1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                        operation1 = getFourBits(operation1);
                        tempStringLine = tempStringLine.concat(operation1);
                        operation2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                        operation2 = getFourBits(operation2);
                        tempStringLine = tempStringLine.concat(operation2);
                        int addressBLT = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                        if (addressBLT < 0) {
                            oneOrZero = "1";
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((16 - Math.abs(addressBLT))));
                        } else {
                            oneOrZero = "0";
                            addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressBLT))));
                        }
                        tempStringLine = tempStringLine.concat(oneOrZero);
                        addressRegister = getFourBits(addressRegister);
                        tempStringLine = tempStringLine.concat(addressRegister);
                        tempStringLine = tempStringLine.concat(n+z+p);

                    }
                if(opcode.equalsIgnoreCase("BGT")) {
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    n="0";z="0";p="1";
                    tempStringLine = tempStringLine.concat("1111");
                    operation1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                    operation1 = getFourBits(operation1);
                    tempStringLine = tempStringLine.concat(operation1);
                    operation2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                    operation2 = getFourBits(operation2);
                    tempStringLine = tempStringLine.concat(operation2);
                    int addressBGT = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                    if (addressBGT < 0) {
                        oneOrZero = "1";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((16 - Math.abs(addressBGT))));
                    } else {
                        oneOrZero = "0";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressBGT))));
                    }
                    tempStringLine = tempStringLine.concat(oneOrZero);
                    addressRegister = getFourBits(addressRegister);
                    tempStringLine = tempStringLine.concat(addressRegister);
                    tempStringLine = tempStringLine.concat(n+z+p);
                  //  System.out.println("\nKKKKKKKKKKKK: " + addressRegister.length());
                }
                if(opcode.equalsIgnoreCase("BLE")) {
                    n="1";z="1";p="0";
                    tempStringLine = tempStringLine.concat("1111");
                    operation1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                    operation1 = getFourBits(operation1);
                    tempStringLine = tempStringLine.concat(operation1);
                    operation2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                    operation2 = getFourBits(operation2);
                    tempStringLine = tempStringLine.concat(operation2);
                    int addressBLE = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                    if (addressBLE < 0) {
                        oneOrZero = "1";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((16 - Math.abs(addressBLE))));
                    } else {
                        oneOrZero = "0";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressBLE))));
                    }
                    tempStringLine = tempStringLine.concat(oneOrZero);
                    addressRegister = getFourBits(addressRegister);
                    tempStringLine = tempStringLine.concat(addressRegister);
                    tempStringLine = tempStringLine.concat(n+""+z+""+p);
                }
                if(opcode.equalsIgnoreCase("BGE")) {
                    n="0";z="1";p="1";
                    tempStringLine = tempStringLine.concat("1111");
                    operation1 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[0]))));
                    operation1 = getFourBits(operation1);
                    tempStringLine = tempStringLine.concat(operation1);
                    operation2 = "" + Integer.parseInt(Integer.toBinaryString(Integer.parseInt(seperateRegisterAdress(elementArray[1]))));
                    operation2 = getFourBits(operation2);
                    tempStringLine = tempStringLine.concat(operation2);
                    int addressBGE = Integer.parseInt(seperateRegisterAdress(elementArray[2]));
                    if (addressBGE < 0) {
                        oneOrZero = "1";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString((16 - Math.abs(addressBGE))));
                    } else {
                        oneOrZero = "0";
                        addressRegister = "" + "" + Integer.parseInt(Integer.toBinaryString(((addressBGE))));
                    }
                    tempStringLine = tempStringLine.concat(oneOrZero);
                    addressRegister = getFourBits(addressRegister);
                    tempStringLine = tempStringLine.concat(addressRegister);
                    tempStringLine = tempStringLine.concat(n+""+z+""+p);
                }


            result += convertBinaryToHexadecimal(tempStringLine);
          // System.out.println("\ndssfgdfgsghszhszgdhs: " + result);
            result = result.concat("\n");
            tempStringLine = "";
        }
        return result;
    }
//////////////////////////////////////////////////////////////////////
    public static String getFourBits(String string) {
        if(string.length()==1) {
            return "000"+string;
        }else if(string.length()==2) {
            return "00"+string;
        }else if(string.length()==3) {
            return "0"+string;
        }else {
            return string;
        }
    }

    public static String getSevenBits(String string) {
        if(string.length()==1) {
            return "000000"+string;
        }else if(string.length()==2) {
            return "00000"+string;
        }else if(string.length()==3) {
            return "0000"+string;
        }else if(string.length()==4) {
            return "000"+string;
        }else if(string.length()==5) {
            return "00"+string;
        }else if(string.length()==6) {
            return "0"+string;
        }else {
            return string;
        }
    }

    public static String getTenBits(String string) {
        if(string.length()==1) 		  {
            return "0000000000"+string;
        }else if(string.length()==2)  {
            return "000000000"+string;
        }else if(string.length()==3)  {
            return "00000000"+string;
        }else if(string.length()==4)  {
            return "0000000"+string;
        }else if(string.length()==5)  {
            return "000000"+string;
        }else if(string.length()==6)  {
            return "00000"+string;
        }else if(string.length()==7)  {
            return "0000"+string;
        }else if(string.length()==8)  {
            return "000"+string;
        }else if(string.length()==9)  {
            return "00"+string;
        }else if(string.length()==10) {
            return "0"+string;
        }else {
            return string;
        }
    }


    public static String getFourteenBits(String string) {
        if(string.length()==1) 		  {
            return "00000000000000"+string;
        }else if(string.length()==2)  {
            return "0000000000000"+string;
        }else if(string.length()==3)  {
            return "000000000000"+string;
        }else if(string.length()==4)  {
            return "00000000000"+string;
        }else if(string.length()==5)  {
            return "0000000000"+string;
        }else if(string.length()==6)  {
            return "000000000"+string;
        }else if(string.length()==7)  {
            return "00000000"+string;
        }else if(string.length()==8)  {
            return "0000000"+string;
        }else if(string.length()==9)  {
            return "000000"+string;
        }else if(string.length()==10) {
            return "00000"+string;
        }else if(string.length()==11) {
            return "0000"+string;
        }else if(string.length()==12) {
            return "000"+string;
        }else if(string.length()==13) {
            return "00"+string;
        }else if(string.length()==14) {
            return "0"+string;
        }else {
            return string;
        }
    }


    public static String seperateRegisterAdress(String register){
        String returnValue="";
     //   System.out.println("\nSSSSSSSSS: " + register);
        char firstChar = register.charAt(0);

       if( !Character.isDigit(firstChar) && firstChar !='-'){
          for(int i=1; i < register.length(); i++){
              returnValue +=register.charAt(i);
          }
       }

       else if(Character.isDigit(firstChar) || firstChar == '-'){
           for(int i=0; i < register.length(); i++){
               returnValue +=register.charAt(i);
           }
        }
     //   System.out.println("\nNNNNNNNNN : " + returnValue);
        return returnValue;

    }


    public static String convertBinaryToHexadecimal(String hexa){
        String reverse = "";
        String hexadecimal = "";
        for(int i = hexa.length() - 1; i >= 0; i--)
        {
            reverse = reverse + hexa.charAt(i);
        }
        int degree = 0;
        int temp = 0;
        String reverseHexa ="";
        for(int i = 0; i < reverse.length(); i++){
            if(degree == 4){

                reverseHexa += hexadecimalNumbers(temp);
                degree = 0;
                temp=0;
            }

            if(degree <4) {
                int index = Character.getNumericValue(reverse.charAt(i));
                temp += index*Math.pow(2, degree);
            }
            degree++;
        }
        if(temp !=0) {
            reverseHexa += hexadecimalNumbers(temp);
        }
        //   System.out.println("Reversehh: " + reverseHexa);
        String theLastString="";
        for(int i = reverseHexa.length() - 1; i >= 0; i--)
        {
            theLastString = theLastString + reverseHexa.charAt(i);
        }


        return theLastString;
    }



    public  static String hexadecimalNumbers(int number){
        String temp = "";
        if(number < 10){
            temp = Integer.toString(number);
        }

        if(number == 10){
            temp = "A";
        }
        if(number == 11){
            temp = "B";
        }
        if(number == 12){
            temp = "C";
        }
        if(number == 13){
            temp = "D";
        }
        if(number == 14){
            temp = "E";
        }
        if(number == 15){
            temp = "F";
        }
        return temp;
    }


}
