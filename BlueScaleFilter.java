public class BlueScaleFilter implements Filter
{

public void filter(PixelImage pi)
  {
		Pixel[][] data = pi.getData();
			    
	    int[] pixelValues = new int[3]; 

	    for (int row = 0; row < pi.getHeight(); row++)
	    {
	      for (int col = 0; col < pi.getWidth(); col++)
	      {
	        pixelValues[0] = data[row][col].red;
	        pixelValues[1] = data[row][col].green;
	        pixelValues[2] = data[row][col].blue;
	        
	        Pixel newPixel = new Pixel(0, 0, pixelValues[2]);
	        data[row][col] = newPixel;
	      }
	    }

    pi.setData(data);
  }
}