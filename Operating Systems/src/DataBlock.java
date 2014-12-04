import java.io.IOException;


public class DataBlock extends Ext2File{
	protected int blockAddress = 0;
	public DataBlock(int blockPointer){
		super();
		blockAddress = ((blockPointer)*1024);

		try {
			fileChannel.read(fileBuffer, blockAddress);
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void printBlockContent(){
		for (int i = 0; i<1024; i++){
			System.out.print((char)fileBuffer.get(i));
		}
	}
	
	
	public void getContents(int inodeSize){
		int nameLength = (int)fileBuffer.get(inodeSize+6);
		
		System.out.print((fileBuffer.getInt(inodeSize)) + ": ");

		
		
		for (int i = 0; i<nameLength; i++){
			System.out.print((char)(fileBuffer.get((inodeSize+8)+i)));
		}
		
		
		
		System.out.println("");
		
		if (((fileBuffer.getInt(inodeSize + 8 + nameLength ) != 0))) this.getContents((fileBuffer.getShort(inodeSize + 4))+inodeSize);

		
		

	}
	
}
