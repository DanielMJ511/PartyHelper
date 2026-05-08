package org.helper.partyhelper.service;

import java.io.InputStream;

public interface OcrService  {
    String extractText(InputStream input);
}
