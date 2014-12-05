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
	 * @param pointerNumber
	 */
	
	public InodeTable(int inodePointer, int inodeNumber, int blockNumber){
		super();
		
			int tableAddress = ((inodePointer)*1024)+(128*(inodeNumber-1));
			try {
				
				fileChannel.read(fileBuffer, tableAddress);
				
				dataPointer = (fileBuffer.getInt(40+(blockNumber*4)));

				
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
