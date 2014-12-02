import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Volume{
	 private static final int byteSize = 1024;

	public Volume(String volLocation){
		SuperBlock superBlock = new SuperBlock(1);
		GroupDescriptor groupDescriptor = new GroupDescriptor(2048);

	}
	
}