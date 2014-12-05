import java.io.IOException;

/**
 * Reads in data from the Ext2 File System
 * @author benfreke
 *
 */

public class DataBlock extends Ext2File{
	protected int blockAddress = 0;
	
	/**
	 * Reads in data from the point defined in Block Pointer, and stores it into File Channel
	 * @param blockPointer
	 */
	
	public DataBlock(int blockPointer){
		super();
		blockAddress = ((blockPointer)*1024);
		//Finds the address of the block
		try {
			fileChannel.read(fileBuffer, blockAddress);
			//Reads in this information to the Byte Buffer

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Print the contents of a block
	 */
	
	public void printBlockContent(){
		for (int i = 0; i<1024; i++){
			System.out.print((char)fileBuffer.get(i));
			//Each block is 2014 bytes, so print out each byte by casting it to a Character.
		}
	}
	
	/**
	 * A recursive function that lists any files defined in the inode table of the datablock, by taking in the Inode Size from the SuperBlock.
	 * @param inodeSize
	 * Takes in the the size of the inode
	 */
	public void getFiles(int inodeSize){

		int nameLength = (int)fileBuffer.get(inodeSize+6);
		//Get the length of the file name 
		
		for (int i = 0; i<nameLength; i++){
			System.out.print((char)(fileBuffer.get((inodeSize+8)+i)));
			//Print out this name using the name length
		}
		
		System.out.println("");
		//Print a new line 
		
		if (((fileBuffer.getInt(inodeSize + 8 + nameLength ) != 0))) this.getFiles((fileBuffer.getShort(inodeSize + 4))+inodeSize);
		//If the next set of data is not zero, more files require printing so call the function.
		
		

	}
	
}
