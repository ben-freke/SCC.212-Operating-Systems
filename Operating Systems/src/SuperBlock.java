import java.io.IOException;
/**
 * Loads in and prints the contents of the superblock
 * @author Ben Freke;
 *
 *
 */
public class SuperBlock extends Ext2File {
	
	protected String volName = "";
	protected int magicNumber, inodesInSystem, blocksInSystem, blocksInGroup, inodesInGroup, sizeOfInode;
	
	/**
	 * Takes in the block offset and prints the Magic Number, Inodes in the System, Blocks in the System, Blocks in the Group, Inodes in the Group and the Size of Each Inode.
	 * @param blockOffset
	 */
	
	public SuperBlock(int blockOffset){
		super();
		try {
			
			fileChannel.read(fileBuffer, ((blockOffset)*1024));
			//Set the channel to begin reading from 2014 bits
			
			
			//Defines variables to store the data.
			for (int i = 0; i<16; i++){
		        volName = volName + ((char)fileBuffer.get(120 + i));
		        //Loops through the data stream to store volume name
			}
			
			magicNumber = fileBuffer.getInt(56);
			inodesInSystem = fileBuffer.getInt(0);
			blocksInSystem = fileBuffer.getInt(4);
			blocksInGroup = fileBuffer.getInt(32);
			inodesInGroup = fileBuffer.getInt(40);
			sizeOfInode = fileBuffer.getInt(88);
			//Stores the remaining bytes as integers (get Int returns 4 bytes)

			
		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
		
		this.fileClose();
			
	}
	
	/**
	 * Prints the content of the SuperBlock
	 */
	public void printContents(){
		
		System.out.println("Volume Name: " + volName);
		System.out.println("Magic Number: " + magicNumber);
		System.out.println("Total number of inodes in the file system: " + inodesInSystem);
		System.out.println("Total number of blocks in the file system: " + blocksInSystem);
		System.out.println("Number of blocks per group: " + blocksInGroup);
		System.out.println("Number of inodes per group: " + inodesInGroup);
		System.out.println("Size of each inode in bytes: " + sizeOfInode);

	}
	
	
}
