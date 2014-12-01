import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;

public class Driver{
	public static void main(String[] args){
		
		Volume  vol = new Volume("src/ext2fs");
		/*
        Ext2File  f = new Ext2File (vol, "/home/acs/myfile.txt");
        byte buf[ ] = f.read(0L, f.size);
        System.out.format ("%s\n", new String(buf)); */
		
		//Reader testRead = new Reader("src/test.txt");
		
		
	}
}