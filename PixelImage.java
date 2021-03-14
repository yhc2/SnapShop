import java.awt.image.*;

/**
 * Provides an interface to a picture as an array of Pixels
 */
public class PixelImage
{
  private BufferedImage myImage;
  private int width;
  private int height;

  /**
   * Map this PixelImage to a real image
   * @param bi The image
   */
  public PixelImage(BufferedImage bi)
  {
    // initialise instance variables
    this.myImage = bi;
    this.width = bi.getWidth();
    this.height = bi.getHeight();
  }

  /**
   * Return the width of the image
   */
  public int getWidth()
  {
    return this.width;
  }

  /**
   * Return the height of the image
   */
  public int getHeight()
  {
    return this.height;
  }

  /**
   * Return the BufferedImage of this PixelImage
   */
  public BufferedImage getImage()
  {
    return this.myImage;
  }

  /**
   * Return the image's pixel data as an array of Pixels.  The
   * first coordinate is the x-coordinate, so the size of the
   * array is [width][height], where width and height are the
   * dimensions of the array
   * @return The array of pixels
   */
  public Pixel[][] getData()
  {
    Raster r = this.myImage.getRaster();
    Pixel[][] data = new Pixel[r.getHeight()][r.getWidth()];
    int[] samples = new int[3];

    for (int row = 0; row < r.getHeight(); row++)
    {
      for (int col = 0; col < r.getWidth(); col++)
      {
        samples = r.getPixel(col, row, samples);
        Pixel newPixel = new Pixel(samples[0], samples[1], samples[2]);
        data[row][col] = newPixel;
      }
    }

    return data;
  }

  /**
   * Set the image's pixel data from an array.  This array matches
   * that returned by getData().  It is an error to pass in an
   * array that does not match the image's dimensions or that
   * has pixels with invalid values (not 0-255)
   * @param data The array to pull from
   */
  public void setData(Pixel[][] data)
  {
    int[] pixelValues = new int[3];     // a temporary array to hold r,g,b values
    WritableRaster wr = this.myImage.getRaster();

    if (data.length != wr.getHeight())
    {
      throw new IllegalArgumentException("Array size does not match");
    }
    else if (data[0].length != wr.getWidth())
    {
      throw new IllegalArgumentException("Array size does not match");
    }

    for (int row = 0; row < wr.getHeight(); row++)
    {
      for (int col = 0; col < wr.getWidth(); col++)
      {
        pixelValues[0] = data[row][col].red;
        pixelValues[1] = data[row][col].green;
        pixelValues[2] = data[row][col].blue;
        wr.setPixel(col, row, pixelValues);
      }
    }
  }
  public Pixel[][] WeightedCompute(Pixel[][] data, int[][] weight, double factor) {
	  
	  Raster r = this.myImage.getRaster();
	  int[] color = new int[3];
	  Pixel[][] temp = new Pixel[r.getHeight()][r.getWidth()];
	  
	  for(int i = 0; i <= r.getHeight()-1; i++) {
		  for(int j = 0; j <= r.getWidth()-1; j++ ) {
			  temp[i][j] = data[i][j];
		  }
	  }
	  
	  for(int row = 1; row < data.length - 1; row++) {
		  
		  for(int col = 1; col < data[row].length - 1; col++) {
			  int rsum, gsum, bsum, rnew, gnew, bnew;
			  rsum = 0;
			  gsum = 0;
			  bsum = 0;
			  
			  rsum = data[row-1][col-1].red * weight[0][0] + data[row-1][col].red * weight[0][1] +
					  data[row-1][col+1].red * weight[0][2] + data[row][col-1].red * weight[1][0] +
					  data[row][col].red * weight[1][1] + data[row][col+1].red * weight[1][2] + 
					  data[row+1][col-1].red * weight[2][0] + data[row+1][col].red * weight[2][1] + 
					  data[row+1][col+1].red * weight[2][2];
			  rnew = (int)(rsum/factor);
			  
			  if (rnew < 0) {
				  rnew = 0;
			  }
			  if (rnew > 255) {
				  rnew = 255;
			  }
			  
			  gsum = data[row-1][col-1].green * weight[0][0] + data[row-1][col].green * weight[0][1] +
					  data[row-1][col+1].green * weight[0][2] + data[row][col-1].green * weight[1][0] +
					  data[row][col].green * weight[1][1] + data[row][col+1].green * weight[1][2] + 
					  data[row+1][col-1].green * weight[2][0] + data[row+1][col].green * weight[2][1] + 
					  data[row+1][col+1].green * weight[2][2];
			  gnew = (int)(gsum/factor);
			  
			  if (gnew < 0) {
				  gnew = 0;
			  }
			  if (gnew > 255) {
				  gnew = 255;
			  }
			  
			  bsum = data[row-1][col-1].blue * weight[0][0] + data[row-1][col].blue * weight[0][1] +
					  data[row-1][col+1].blue * weight[0][2] + data[row][col-1].blue * weight[1][0] +
					  data[row][col].blue * weight[1][1] + data[row][col+1].blue * weight[1][2] + 
					  data[row+1][col-1].blue * weight[2][0] + data[row+1][col].blue * weight[2][1] + 
					  data[row+1][col+1].blue * weight[2][2];
			  bnew = (int)(bsum/factor);
			  
			  if (bnew < 0) {
				  bnew = 0;
			  }
			  if (bnew > 255) {
				  bnew = 255;
			  }
			  color[0] = rnew;
			  color[1] = gnew;
			  color[2] = bnew;
			  
			  Pixel newpixel = new Pixel(color[0], color[1], color[2]);
			  temp[row][col] = newpixel;
					  
		  }
		  
	  }
	 data = temp;
	 return data;
  }
  // add a method to compute a new image given weighted averages
}