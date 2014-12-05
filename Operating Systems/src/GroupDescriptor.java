import java.io.IOException;
/**
 * Loads in and prints out the contents of the Group Descriptor
 * @author benfreke
 *
 */

public class GroupDescriptor extends Ext2File {
	
	protected int inodeTablePointer = 0;
	
/**
 * Takes in the byte reference to begin reading the Group Descriptor. 
 * @param byteReference
 */
	public GroupDescriptor(int byteReference){
		super();
		try {
			
			fileChannel.read(fileBuffer, byteReference);
			//Set the channel to begin reading from 2014 bits
			
			
			inodeTablePointer = fileBuffer.getInt(8);

		
		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
		
		this.fileClose();
	}

	/** 
	 * Returns the pointer to the Inode Table in the file system
	 * @return inodeTablePointer
	 */
	
	public int getTablePointer(){
		return inodeTablePointer;
	}
	
}
