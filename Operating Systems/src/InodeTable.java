import java.io.IOException;

/**
 * Functions relating to the Inode Table
 * @author benfreke
 *
 */

public class InodeTable extends Ext2File{
	protected int dataPointer = 0;
	
	/**
	 * Takes in the pointer to the inode table, the the inode number to read and the number of the block to get the data pointer
	 * @param inodePointer
	 * @param inodeNumber
	 * @param blockNumber
	 */
	
	public InodeTable(int inodePointer, int inodeNumber, int blockNumber){
		super();
		
			int tableAddress = ((inodePointer)*1024)+(128*(inodeNumber-1));
			/*
			 * Calculates the address of the table by:
			 * 	Reading in the pointer to the table
			 * 	Multiplying it by 1024 to get the address
			 * 	Adding the Inode to read by:
			 * 		Reading in the inode number
			 * 		Minusing one (as the first inode is always zero
			 * 		Multiplying this by the size of an inode
			 */
			try {
				
				
				fileChannel.read(fileBuffer, tableAddress);
				
				//Stores this information into the Byte Buffer
				
				dataPointer = (fileBuffer.getInt(40+(blockNumber*4)));
				
				/*
				 * Reads the pointer to the data from the byte buffer, then stores it into a variaable.
				 * The pointer to the first block (of 12) is always stored in Block 1, which starts at the 40th byte in the buffer
				 * Each pointer is 4 bytes, so to get a specific pointer the user can pass in a number
				 */
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	/**
	 * Returns the pointer to the data from the inode table
	 * @return dataPointer
	 */
	
	public int getPointer(){
		return dataPointer;
	}
	
}
