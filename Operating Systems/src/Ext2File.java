import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class Ext2File{
	
	protected int size = 0;
	protected ByteBuffer fileBuffer = null;
	protected FileChannel fileChannel = null;
	protected RandomAccessFile file = null;
	
	public Ext2File(){
		try {
			file = new RandomAccessFile("src/ext2fs","r");
			//Open a file called "file" from the string passed to the constructor, and open it for reading only.
			fileChannel = file.getChannel();
			//FileChannel is a 'seekable byte channel' meaning that the structure can begin reading from a memory point
			//The channel is created from the Random Access File created above. It returns the FileChannel of "file"
			fileBuffer = ByteBuffer.allocate(1024);
			//Created ByteBuffer of the byteSize which is defined above
			fileBuffer.order(ByteOrder.LITTLE_ENDIAN);
			//Set the structure of the ByteBuffer to Little Endian
			
			
		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
			
	}

	
	public void fileClose(){
		
			
	        try {
				fileChannel.close();
		        file.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
		}
	
	

	
}
