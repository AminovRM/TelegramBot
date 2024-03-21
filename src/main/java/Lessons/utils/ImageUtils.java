package Lessons.utils;

import Lessons.commands.AppBotCommand;
import Lessons.utils.functions.FilterOperation;
import Lessons.utils.functions.ImageOperation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class ImageUtils {
    static public BufferedImage getImage(String part) throws IOException {
        final File file = new File(part);
        return ImageIO.read(file);
    }

    static public void saveImage(BufferedImage image, String part) throws IOException {
        ImageIO.write(image, "png", new File(part));
    }

    static float[] rgbIntToArray(int pixel) {
        Color color = new Color(pixel);
        return color.getRGBColorComponents(null);
    }

    static int arrayToRgbItn(float[] pixel) throws Exception {
        Color color = null;
        if (pixel.length == 3) {
            color = new Color(pixel[0], pixel[1], pixel[2]);
        } else if (pixel.length == 4) {
            color = new Color(pixel[0], pixel[1], pixel[2], pixel[3]);
        }
        if (color != null) {
            return color.getRGB();
        }
        throw new Exception("Invalide color");
    }

    public static ImageOperation getOperation(String operationName) {
        FilterOperation filterOperation = new FilterOperation();
        Method[] classMethods = filterOperation.getClass().getDeclaredMethods();
        for (Method method : classMethods) {
            if (method.isAnnotationPresent(AppBotCommand.class)) {
                AppBotCommand command = method.getAnnotation(AppBotCommand.class);
                if (command.name().equals(operationName)) {
                    return (f) -> (float[]) method.invoke(filterOperation, f);
                }
            }
        }
        return null;
    }
}
