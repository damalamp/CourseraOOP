package Course1.Week4.Part2;

import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class Solutions {
    public static void saveCopyAsGrayscale(ImageResource pic) {
        ImageResource copyPic = makeGray(pic);
        saveCopy(copyPic,"copy-", pic.getFileName());
    }


    public static ImageResource makeGray(ImageResource pic) {
        ImageResource copyPic = new ImageResource(pic.getWidth(),pic.getHeight());
        for (Pixel pixy : copyPic.pixels()){
            Pixel inPixy = pic.getPixel(pixy.getX(),pixy.getY());
            int avePix = (inPixy.getBlue() + inPixy.getGreen() + inPixy.getRed())/3;
            pixy.setBlue(avePix);
            pixy.setGreen(avePix);
            pixy.setRed(avePix);
        }
        return copyPic;
    }

    public static void saveCopy(ImageResource pic, String prefix, String originalName) {
        pic.setFileName(prefix + originalName);
        pic.save();
    }


    public static void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource originalPic = new ImageResource(f);
            saveCopyAsGrayscale(originalPic);
        }
    }

    public static void saveCopyAsInversion(ImageResource pic) {
        ImageResource copyPic = invert(pic);
        saveCopy(copyPic,"invert-",pic.getFileName());
    }

    public static ImageResource invert(ImageResource pic) {
        ImageResource copyPic = new ImageResource(pic.getWidth(),pic.getHeight());
        for (Pixel pixy : copyPic.pixels()){
            Pixel inPixy = pic.getPixel(pixy.getX(),pixy.getY());
            pixy.setBlue(255-inPixy.getBlue());
            pixy.setGreen(255-inPixy.getGreen());
            pixy.setRed(255-inPixy.getRed());
        }
        return copyPic;
    }

    public static void selectAndInvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource originalPic = new ImageResource(f);
            saveCopyAsInversion(originalPic);
        }
    }

}