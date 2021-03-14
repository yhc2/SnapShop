import java.awt.image.*;

public class NegativeFilter implements Filter
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
	        
	        Pixel newPixel = new Pixel(255 - pixelValues[0], 255 - pixelValues[1], 255 - pixelValues[2]);
	        data[row][col] = newPixel;
	      }
	    }

    pi.setData(data);
  }
}