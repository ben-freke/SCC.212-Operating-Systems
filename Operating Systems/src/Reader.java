import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Reader extends Ext2File{
	public Reader(long dataPointer){
	
		try {
			
			fileChannel.read(fileBuffer, dataPointer);
			
			for (int i = 0; i<1024; i++)
            	//Loop whilst there's data remaining in the file buffer to read
            {
                System.out.print(fileBuffer.get(i));
                //Convert each item in the fileBuffer to char and print it
            }
            
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	            
	        
	       
		
	}
}