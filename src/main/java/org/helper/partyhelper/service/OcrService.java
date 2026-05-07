package org.helper.partyhelper.service;

import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;
import java.io.InputStream;

public interface OcrService  {
    String extractText(InputStream input) throws IOException, TesseractException;
}
