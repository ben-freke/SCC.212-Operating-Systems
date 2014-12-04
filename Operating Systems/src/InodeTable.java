import java.io.IOException;


public class InodeTable extends Ext2File{
	protected int dataPointer = 0;
	public InodeTable(int inodePointer, int inodeNumber, int pointerNumber){
		super();
		
			int tableAddress = ((inodePointer)*1024)+(128*(inodeNumber-1));
			try {
				
				fileChannel.read(fileBuffer, tableAddress);
				
				dataPointer = (fileBuffer.getInt(40+(pointerNumber*4)));

				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public int getPointer(){
		return dataPointer;
	}
	
}
