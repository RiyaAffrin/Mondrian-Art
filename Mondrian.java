import java.util.*;
import java.awt.*;

public class Mondrian {
    private Color getRandColor(int allX1, int allY1, int allX2, int allY2, int x1, int y1, int x2, int y2) {
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;
        int centerAllX = (allX1 + allX2) / 2;
        int centerAllY = (allY1 + allY2) / 2;

        
        double distanceToCenter = Math.sqrt(Math.pow(centerX - centerAllX, 2) + Math.pow(centerY - centerAllY, 2));
        double maxDistance = Math.sqrt(Math.pow(allX2 - centerAllX, 2) + Math.pow(allY2 - centerAllY, 2));

       
        double redProb = 0.5 * ((double) (centerAllX - centerX) / centerAllX + (double) (centerAllY - centerY) / centerAllY);
        double blueProb = 0.5 * ((double) (centerX - centerAllX) / centerAllX + (double) (centerY - centerAllY) / centerAllY);

        
        double totalProb = redProb + blueProb;
        redProb /= totalProb;
        blueProb /= totalProb;

        double randValue = rand.nextDouble();
        if (randValue < redProb) {
            return Color.RED;
        } else if (randValue < redProb + blueProb) {
            return Color.BLUE;
        } else {
            return colorArray[rand.nextInt(colorArray.length)]; 
        }
          
}
return colorArray[rand.nextInt(colorArray.length)];