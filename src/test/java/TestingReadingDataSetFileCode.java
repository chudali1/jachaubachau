
import com.cab.jachaubachau.app.ReadingDataSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestingReadingDataSetFileCode {
    ReadingDataSet readingDataSet=null;

    @Before
    public void testFileNotFound(){
        readingDataSet=new ReadingDataSet();
        assertEquals("success",readingDataSet.readingDataSet("Book1.xlsx"));
    }

    @Test
    public void testStringConversionOfArray(){
        readingDataSet.classifyTheSymptom(new String[]{"itching","adult","male"});
    }
}

