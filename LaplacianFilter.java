
public class LaplacianFilter implements Filter{


	public void filter(PixelImage pi) {
		
		// TODO Auto-generated method stub
		final double factor = 1.0;
		
		int [][] lapMatrix = new int[][] {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
		
		Pixel[][]data = pi.getData();
		Pixel[][] newpi= new Pixel[pi.getHeight()][pi.getWidth()];
		
		newpi = pi.WeightedCompute(data,lapMatrix,factor);
		
		pi.setData(newpi);
		
		
	}

}
