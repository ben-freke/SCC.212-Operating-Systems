import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;

public class Driver{
	public static void main(String[] args){
		
		Volume  vol = new Volume("src/ext2fs");
		SuperBlock superBlock = new SuperBlock(1);
		GroupDescriptor groupDescriptor = new GroupDescriptor(2048);
		InodeTable mainTable = new InodeTable(groupDescriptor.getTablePointer(), 2, 0);
		DataBlock temp = new DataBlock(mainTable.getPointer());
		temp.getFiles(0);
		
		printTwoCities(groupDescriptor);
		
		
		
	}
	
	static public void printTwoCities(GroupDescriptor groupDescriptor){
		
		InodeTable twoCitiesTable = new InodeTable(groupDescriptor.getTablePointer(), 12, 0);
		DataBlock twoCities = new DataBlock(twoCitiesTable.getPointer());
		twoCities.printBlockContent();
		InodeTable twoCitiesTable1 = new InodeTable(groupDescriptor.getTablePointer(), 12, 1);
		DataBlock block2 = new DataBlock(twoCitiesTable1.getPointer());
		block2.printBlockContent();
		
	}
}