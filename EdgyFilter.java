
public class EdgyFilter implements Filter{


	public void filter(PixelImage pi) {
		
		// TODO Auto-generated method stub
		final double factor = 1.0;
		
		int [][] edgyMatrix = new int[][] {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
		
		Pixel[][]data = pi.getData();
		Pixel[][] newpi= new Pixel[pi.getHeight()][pi.getWidth()];
		
		newpi = pi.WeightedCompute(data,edgyMatrix,factor);
		
		pi.setData(newpi);
		
		
	}

}
