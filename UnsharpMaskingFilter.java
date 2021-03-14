
public class UnsharpMaskingFilter implements Filter{


	public void filter(PixelImage pi) {
		
		// TODO Auto-generated method stub
		final double factor = 16.0;
		
		int [][] usmMatrix = new int[][] {{-1,-2,-1},{-2,28,-2},{-1,-2,-1}};
		
		Pixel[][]data = pi.getData();
		Pixel[][] newpi= new Pixel[pi.getHeight()][pi.getWidth()];
		
		newpi = pi.WeightedCompute(data,usmMatrix,factor);
		
		pi.setData(newpi);
		
		
	}

}
