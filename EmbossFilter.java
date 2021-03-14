public class EmbossFilter implements Filter
{

public void filter(PixelImage pi)
  {
		Pixel[][] data = pi.getData();
			    
	    int[] pixelValues = new int[6]; 

	    for (int row = 1; row < pi.getHeight()-1; row++)
	    {
	      for (int col = 1; col < pi.getWidth()-1; col++)
	      {
	        pixelValues[0] = data[row][col].red;
	        pixelValues[1] = data[row][col].green;
	        pixelValues[2] = data[row][col].blue;
	        pixelValues[3] = data[row+1][col+1].red;
	        pixelValues[4] = data[row+1][col+1].green;
	        pixelValues[5] = data[row+1][col+1].blue;
	        
	        Pixel newPixel = new Pixel (Math.min(Math.abs((pixelValues[0]-pixelValues[3])+128),255), 
	        					     	Math.min(Math.abs((pixelValues[1]-pixelValues[4])+128),255), 
	        					    	Math.min(Math.abs((pixelValues[2]-pixelValues[5])+128),255));
	        data[row][col] = newPixel;
	      }
	    }

    pi.setData(data);

  }
}









