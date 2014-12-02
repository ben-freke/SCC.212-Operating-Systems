import java.io.IOException;


public class DataBlock extends Ext2File{
	protected int blockAddress = 0;
	public DataBlock(int blockPointer){
		blockAddress = ((blockPointer)*1024);

		try {
			fileChannel.read(fileBuffer, blockAddress);
			
			this.getContents(0);
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getContents(int inodeSize){
		int nameLength = (int)fileBuffer.get(inodeSize+6);

		for (int i = 0; i<nameLength; i++){
			System.out.print((char)(fileBuffer.get((inodeSize+8)+i)));
		}
		System.out.println("");
		
		this.getContents((fileBuffer.getShort(inodeSize + 4))+inodeSize);
		

	}
	
}
