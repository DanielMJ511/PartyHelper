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

    private final Tesseract tesseract;

    public TesseractOcrService(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    @Override
    public String extractText(InputStream input) {
        try{
            BufferedImage bufferedImage = ImageIO.read(input);
            return tesseract.doOCR(bufferedImage);
        }catch(IOException | TesseractException e){
            throw new RuntimeException("OCR extraction failed", e);

        }
    }

}
