import java.io.IOException;


public class GroupDescriptor extends Ext2File {
	protected int inodeTablePointer = 0;
	public GroupDescriptor(){
		super();
		try {
			
			fileChannel.read(fileBuffer, 2048);
			//Set the channel to begin reading from 2014 bits
			
			
			inodeTablePointer = fileBuffer.getInt(8);
		
		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
		
		this.fileClose();
	}

	public int getTablePointer(){
		return inodeTablePointer;
	}
	
}
