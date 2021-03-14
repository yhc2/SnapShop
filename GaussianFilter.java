
public class GaussianFilter implements Filter{


	public void filter(PixelImage pi) {
		
		// TODO Auto-generated method stub
		final double factor = 16.0;
		
		int [][] gauMatrix = new int[][] {{1,2,1},{2,4,2},{1,2,1}};
		
		Pixel[][] data = pi.getData();
		Pixel[][] newpi= new Pixel[pi.getHeight()][pi.getWidth()];
		
		newpi = pi.WeightedCompute(data,gauMatrix,factor);
		
		pi.setData(newpi);
		
		
	}

}
