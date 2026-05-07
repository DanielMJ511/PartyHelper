package org.helper.partyhelper.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


@Component
public class TesseractOcrService implements OcrService{

    Tesseract tesseract = new Tesseract();
    @Override
    public String extractText(InputStream input) throws IOException, TesseractException {
        BufferedImage bufferedImage = ImageIO.read(input);
        tesseract.setLanguage("eng+spa");
        return tesseract.doOCR(bufferedImage);
    }


}
