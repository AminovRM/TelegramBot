package Lessons.utils;

import Lessons.utils.functions.ImageOperation;

import java.awt.image.BufferedImage;

public class RgbMaster {

    private BufferedImage image;
    private int width;
    private int height;
    private boolean hasAlfaChannel;
    private int[] pixels;

    public RgbMaster(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        hasAlfaChannel = image.getAlphaRaster() != null;
        pixels = image.getRGB(0, 0, width, height, null, 0, width);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void changeImage(ImageOperation operation) throws Exception{
        for (int i = 0; i < pixels.length; i++){
            float[] pixel = ImageUtils.rgbIntToArray(pixels[i]);
            float[] newPixel = operation.execute(pixel);
            pixels[i] = ImageUtils.arrayToRgbItn(newPixel);

        }

        image.setRGB(0,0,width, height, pixels, 0,width);
    }
}

