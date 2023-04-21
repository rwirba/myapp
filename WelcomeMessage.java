import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WelcomeMessage {
    public static void main(String[] args) throws IOException {
        // Load background image
        BufferedImage backgroundImage = ImageIO.read(new File("/opt/myapp/background.png"));

        // Create a new image with the same size as the background image
        BufferedImage image = new BufferedImage(backgroundImage.getWidth(), backgroundImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        // Get the graphics object of the new image
        Graphics g = image.getGraphics();

        // Draw the background image on the new image
        g.drawImage(backgroundImage, 0, 0, null);

        // Set font properties
        Font font = new Font("Arial", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.WHITE);

        // Get the width and height of the text
        String text = "WELCOME TO M.I TECH.";
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textHeight = g.getFontMetrics().getHeight();

        // Calculate the x and y coordinates to center the text
        int x = (image.getWidth() - textWidth) / 2;
        int y = (image.getHeight() - textHeight) / 2;

        // Draw the text on the image
        g.drawString(text, x, y);

        // Load image to add to the bottom of the text
        BufferedImage imageToDisplay = ImageIO.read(new File("/opt/myapp/image.png"));

        // Draw the image at the bottom of the text
        int imageX = (image.getWidth() - imageToDisplay.getWidth()) / 2;
        int imageY = y + textHeight + 20;
        g.drawImage(imageToDisplay, imageX, imageY, null);

        // Save the new image
        ImageIO.write(image, "png", new File("/opt/myapp/output.png"));

        // Print a message to the console
        System.out.println("Java application executed successfully!");
    }
}
