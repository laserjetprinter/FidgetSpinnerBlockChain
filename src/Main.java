/**Main.java carries out the functions of the block chain. The class takes in data
   from a file, and creates resulting blocks. The main will print out the hash of 
   the initialized blocks, and the data - to demonstrate that the data is being
   properly stored.*/

/***************************************************/
/**The following definitions describe the variables:*/
/**  Hash: digital signature of the block. The hash 
           will change value depending on the input
           data and the data of the previous block.

     Block: contains list of input data, hash of 
            previous block, and hash of current
            block.
*/
/***************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileNotFoundException;

public class Main{

    public static void main(String[] args){

	/**This must be created regardless of other data. When having
	   a block chain, you must have previous hash of previous block
	   in the contents of the new block. This will ensure that the 
	   previous hash of any new block will be a constant, and that 
	   a beginning block and hash exist.*/
	String[] initialData = {"This is the first block - containing no data"};
	BlockChain initialBlock = new BlockChain(0, initialData);
	BlockChain holding = initialBlock; //allows file to retrieve previous hash of initial 

	/**Prints values of the current block*/
	System.out.println("Initial block: ");
	System.out.print("Data: ");
	System.out.println(Arrays.toString(initialData));
	System.out.print("Current hash: "); 
	System.out.println(initialBlock.getBlockHash());
	System.out.print("Previous hash: ");
	System.out.println(initialBlock.getPrevHash());
	System.out.println("");

	/**Reads the input.txt file contents line by line*/
	try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
		String line;
      		int count = 1;
		BlockChain inputBlock;
		while ((line = br.readLine()) != null) {

		    String[] inputData = {line}; //creates input data from file
		    inputBlock = new BlockChain(holding.getBlockHash(), inputData); //creates block

		    /**Prints values of the current block*/
		    System.out.println("Input block " + count + ": ");
		    System.out.print("Data: ");
		    System.out.println(Arrays.toString(inputData));
		    System.out.print("Current hash: ");
		    System.out.println(inputBlock.getBlockHash());
		    System.out.print("Previous hash: ");
		    System.out.println(inputBlock.getPrevHash());
		    System.out.println();

		    holding = inputBlock; //sets temp block to current, so next iteration has access to prev hash
		    count++; 
		}//end of while
	    }//end of try
	catch(FileNotFoundException e){
	}//end of catch
	catch(IOException e){
	}//end of catch
    }//end of main
}//end of Main