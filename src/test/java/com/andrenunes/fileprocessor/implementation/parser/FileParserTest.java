package com.andrenunes.fileprocessor.implementation.parser;

import com.andrenunes.fileprocessor.model.Customer;
import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Seller;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FileParserTest {

    private FileParser fileParser;

    public FileParserTest() {
        this.fileParser = new FileParser();
    }

    @Test
    public void testParseValidLines() {
        List<Model> models = fileParser.parseLines(Collections.singletonList("001ç1234567891234çPedroç50000"));
        assertNotNull(models);
        assertEquals(1, models.size());
    }

    @Test
    public void testParseValidLinesIsInstanceOfCustomer() {
        List<Model> models = fileParser.parseLines(Collections.singletonList("001ç1234567891234çPedroç50000"));
        assertNotNull(models);
        assertEquals(1, models.size());
        assertTrue(models.get(0) instanceof Seller);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseInvalidIdentifier() {
        fileParser.parseLines(Collections.singletonList("00ç1234567891234çPedroç50000"));
    }
}
