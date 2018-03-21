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
import java.util.Arrays;

public class Main{

    public static void main(String[] args){

	/**This must be created regardless of other data. When having
	   a block chain, you must have previous hash of previous block
	   in the contents of the new block. This will ensure that the 
	   previous hash of any new block will be a constant, and that 
	   a beginning block and hash exist.*/
	String[] initialData = {"This is the first block - containing no data"};
	BlockChain initialBlock = new BlockChain(0, initialData);
	
	System.out.println("Initial block: ");
	System.out.println("Data: ");
	System.out.println(initialBlock.getData());
	System.out.println("Current hash: "); 
	System.out.println(initialBlock.getBlockHash());
	System.out.println("Previous hash: ");
	System.out.println(initialBlock.getPrevHash());
    }//end of main
}//end of Main