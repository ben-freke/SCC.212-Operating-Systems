import java.io.IOException;


public class InodeTable extends Ext2File{

	public InodeTable(int inodePointer){
		super();
		
			System.out.println("");
			int tableAddress = ((inodePointer)*1024)+128;
			try {
				
				fileChannel.read(fileBuffer, 86144);
				
				System.out.println(fileBuffer.getInt(40));
      

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
	
}
