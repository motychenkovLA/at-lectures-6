package extension;

import io.qameta.allure.Allure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class AllurePrintStream extends PrintStream {
    private final String LOG_NAME;

    public AllurePrintStream(String logName) throws UnsupportedEncodingException {
        super(new ByteArrayOutputStream(), false, "UTF-8");
        this.LOG_NAME = logName;
    }

    @Override
    public void println(String x) {Allure.addAttachment(LOG_NAME, x);}

}
