import java.io.IOException;

public class SuperBlock extends Ext2File {

	public SuperBlock(int blockOffset){
		super();
		try {
			
			fileChannel.read(fileBuffer, ((blockOffset)*1024));
			//Set the channel to begin reading from 2014 bits
			
			String volName = "";
			int magicNumber, inodesInSystem, blocksInSystem, blocksInGroup, inodesInGroup, sizeOfInode;
			
			for (int i = 0; i<16; i++){
		        volName = volName + ((char)fileBuffer.get(120 + i));
			}
			
			magicNumber = fileBuffer.getInt(56);
			inodesInSystem = fileBuffer.getInt(0);
			blocksInSystem = fileBuffer.getInt(4);
			blocksInGroup = fileBuffer.getInt(32);
			inodesInGroup = fileBuffer.getInt(40);
			sizeOfInode = fileBuffer.getInt(88);

			System.out.println("Volume Name: " + volName);
			System.out.println("Magic Number: " + magicNumber);
			System.out.println("Total number of inodes in the file system: " + inodesInSystem);
			System.out.println("Total number of blocks in the file system: " + blocksInSystem);
			System.out.println("Number of blocks per group: " + blocksInGroup);
			System.out.println("Number of inodes per group: " + inodesInGroup);
			System.out.println("Size of each inode in bytes: " + sizeOfInode);

		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
		
		this.fileClose();
			
	}
	
	
	
}
