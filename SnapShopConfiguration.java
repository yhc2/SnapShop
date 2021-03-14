// Write your short report here (-2 if there is no report)

/**
 * A class to configure the SnapShop application
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("/Users/maggie/Desktop/billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
    theShop.addFilter(new NegativeFilter(), "Negative");
    theShop.addFilter(new GaussianFilter(), "Gaussian");
    theShop.addFilter(new EdgyFilter(), "Edgy");
    theShop.addFilter(new UnsharpMaskingFilter(), "Unsharp Masking");
    theShop.addFilter(new LaplacianFilter(), "Laplacian");
    theShop.addFilter(new RedScaleFilter(), "RedScale");
    theShop.addFilter(new GreenScaleFilter(), "GreenScale");
    theShop.addFilter(new BlueScaleFilter(), "BlueScale");
    theShop.addFilter(new DebossFilter(), "Deboss");



    // add your other filters below
  }
}