import java.util.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {
        // 1. Create a new picture sized 400 x 400 pixels
        Picture picky = new Picture(400,400);
        // Color[][] pixels = picky.getPixels();
        //  picky.setPixels(pixels);
        divideCanvas(picky, 7);
        picky.save("newPic.png");

        // 2. Call divide divide canvas
       
        // 3. Save the image to display it
        
    }




    
    

    // TODO: Implement divideCanvas below using your 'fill' implementation
    // from the previous slide


    public static void divideCanvas(Picture p, int n) {
        Color[][] pixels = p.getPixels();
        divideHelper(pixels, n, 0, 0, p.width(), p.height());
        p.setPixels(pixels);
    }

    private static void divideHelper(Color[][] pixels, int n, int x1, int y1, int x2, int y2) {

        if (n == 0) {
            fill(pixels, x1 + 1,x2 - 1, y1 + 1,y2 - 1);

        }else{
            int widthH = x1 + (x2 - x1) / 2;
            int heightH = y1 + (y2 - y1) / 2;

            
            divideHelper(pixels, n - 1, x1, y1, widthH, heightH);
            divideHelper(pixels, n - 1, widthH, y1, x2, heightH);
            divideHelper(pixels, n - 1, x1, heightH, widthH, y2);
            divideHelper(pixels, n - 1, widthH, heightH, x2, y2);
        }
    }




    // TODO: Paste in 'fill' from the previous slide
    public static void fill(Color[][] pixels, int x1, int x2, int y1, int y2){
        for(int i = y1; i <y2; i++){
            for(int j = x1; j <x2; j++){
                pixels[i][j] = Color.WHITE;
            }
        }
    }
        
}