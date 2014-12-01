import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Reader{
	 private static final int byteSize = 1024;
	public Reader(String f){
		try {
			RandomAccessFile file = new RandomAccessFile(f,"r");
			//Open a file called "file" from the string passed to the constructor, and open it for reading only.
			FileChannel fileChannel = file.getChannel();
			//FileChannel is a 'seekable byte channel' meaning that the structure can begin reading from a memory point
			//The channel is created from the Random Access File created above. It returns the FileChannel of "file"
			ByteBuffer fileBuffer = ByteBuffer.allocate(byteSize);
			//Created ByteBuffer of the byteSize which is defined above
			while(fileChannel.read(fileBuffer) > 0)
	        {
				fileBuffer.flip();
				//Flips the byte buffer by setting the limit to the current position and setting the current position to the begining
				//This essentially turns it from 'writing' to 'reading' mode
	            while(fileBuffer.hasRemaining())
	            	//Loop whilst there's data remaining in the file buffer to read
	            {
	                System.out.print((char) fileBuffer.get());
	                //Convert each item in the fileBuffer to char and print it
	            }
	            
	        }
	        fileChannel.close();
	        file.close();
	        
	        
		} catch (FileNotFoundException e1) {
			System.out.println("File not found.");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input/Output Exception:");
			e.printStackTrace();
		}
		
		
		
	}
}