/**BlockChain.java creates the basic variables needed to store the hash variables,
   blocks, and input data. The following class contains getter functions for the
   above data, and a constructor used to intialize a new block.*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class BlockChain{

    private int prevHash;
    private String[] data;
    private int blockHash;

    /**Constructor that creates a new block from input data*/
    public BlockChain(int prevHash, String[] data){
	
	/**Sets variables equal to input paramters*/
	this.prevHash = prevHash;
	this.data = data;

	/**Creates an array that stores a generated
	   has of input data, and stores previous
	   blocks hash value. Then generates a hash
	   for blockContents, and stores it in blockHash*/
	Object[] blockContents = {Arrays.hashCode(data), prevHash};
	this.blockHash = Arrays.hashCode(blockContents);
    }//end of BlockChain constructor
    

    /********************************************************/
    /**The following are getter functions for the input data*/
    /********************************************************/

    public int getPrevHash(){
	
	return prevHash;
    }//end of getPrevHash

    public String[] getData(){
	
	return data;
    }//end of getData

    public int getBlockHash(){
	
	return blockHash;
    }//end of getBlockHash
}//end of BlockChain