import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

public class MultithreadingExample {

    private static final int WIDTH = 256;
    private static final int HEIGHT = 32;
    private static final int THREADS = 4;

    private static Vector<BufferedImage> biArr = new Vector<BufferedImage>();
    private static final double STARTX = -1.5;
    private static final double ENDX = 0.5;
    private static final double STARTY = -1;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Instant start = Instant.now();
        double width = ENDX - STARTX;
        double height = width * ((double)HEIGHT/WIDTH) * 2.0;

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        List<Future<List<List<Double>>>> futures = new ArrayList<>();

        for (int thread = 0; thread < THREADS; thread++) {
            double threadStartY = STARTY + thread * height;
            double threadEndY = STARTY + (thread+1) * height;
            futures.add(executorService.submit(new Mandelbrot(WIDTH, HEIGHT, STARTX, ENDX, threadStartY, threadEndY)));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        List<List<List<Double>>> allMandelbrots = new ArrayList<>();
        for (Future<List<List<Double>>> future : futures) {
            allMandelbrots.add(future.get());
        }
        drawMandelbrots(allMandelbrots);

        //new code
        int heightCurr = 0;
        BufferedImage concatImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2d = concatImage.createGraphics();
        for(int j = 0; j < biArr.size(); j++) {
            g2d.drawImage(biArr.get(j), 0, heightCurr, null);
            heightCurr += biArr.get(j).getHeight();
        }
        g2d.dispose();

        try {
            ImageIO.write(concatImage, "PNG", new File("SeeMe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new code end

        System.out.println("Took " + start.until(Instant.now(), ChronoUnit.MILLIS) + "ms");
    }

    private static void drawMandelbrots(List<List<List<Double>>> allMandelbrots) {
        double minIntensity = calcMin(allMandelbrots);
        double maxIntensity = calcMax(allMandelbrots);

        //new code

        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D g2d = bi.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        int colorPalette[] = {0xFFFFFF, 0x0033EE, 0x0000ff, 0x0000cc, 0x0000aa, 0x000088, 0x000066, 0x777700, 0x999900};

        //new code end

        final String[] palette = " .:*|VFNM".split("");
        for (List<List<Double>> pixels : allMandelbrots) {
            for (int y = 0; y < pixels.size(); y++) {
                StringBuilder output = new StringBuilder();
                List<Double> xs = pixels.get(y);
                for (int x = 0; x < xs.size(); x++) {
                    double intensity = (xs.get(x) - minIntensity) / (maxIntensity - minIntensity);
                    int idx = Math.min(palette.length - 1, (int) (palette.length * intensity));
                    output.append(palette[idx]);
                    //new code
                    bi.setRGB(x, y, colorPalette[idx]);
                    //new code end
                }
                System.out.println(output.toString());
            }

            biArr.add(bi);
        }
    }

    private static double calcMin(List<List<List<Double>>> allMandelbrots) {
        double minIntensity = 1;
        for (List<List<Double>> pixels : allMandelbrots) {
            for (List<Double> row : pixels) {
                for (double col : row) {
                    minIntensity = Math.min(minIntensity, col);
                }
            }
        }
        return minIntensity;
    }

    private static double calcMax(List<List<List<Double>>> allMandelbrots) {
        double maxIntensity = 1;
        for (List<List<Double>> pixels : allMandelbrots) {
            for (List<Double> row : pixels) {
                for (double col : row) {
                    maxIntensity = Math.max(maxIntensity, col);
                }
            }
        }
        return maxIntensity;
    }
}