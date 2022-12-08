package net.sf.cb2xml.example;

import com.google.gson.Gson;
import net.sf.cb2xml.def.Cb2xmlConstants;
import net.sf.cb2xml.jaxb.Condition;
import net.sf.cb2xml.jaxb.Copybook;
import net.sf.cb2xml.jaxb.Item;
import net.sf.cb2xml.parse.CobolParser;
import net.sf.cb2xml.sablecc.lexer.LexerException;
import net.sf.cb2xml.sablecc.parser.ParserException;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;


/**
 * This program will "Pretty Print" a Cobol copybook;
 *
 * @author Bruce Martin
 */
public class GenerateJsonRepresentation {

    public static final int PIC_POS = 46;


    String spaces = "                                                                                                            "
            + "                                                                                                            ";

    HashMap<String, String> fieldMap = new HashMap<String, String>(150);
    HashMap<String, String> usageMap = new HashMap<String, String>(150);

    public GenerateJsonRepresentation(String input) throws IOException, JAXBException, ParserException, LexerException, XMLStreamException {
        this(new File(input), new OutputStreamWriter(System.out));
    }

    public GenerateJsonRepresentation(String input, String ouput) throws IOException, JAXBException, ParserException, LexerException, XMLStreamException {
        this(new File(input), new FileWriter(ouput));
    }

    public GenerateJsonRepresentation(File in, Writer w) throws IOException, JAXBException, ParserException, LexerException, XMLStreamException {
        this(new FileReader(in), in.getName(), w);
    }

    /**
     * "Obfuscate" a Cobol copybook;
     *
     * @param copybookReader Cobopl Copybook
     * @param copybookname   name of the copybook
     * @param copybookWriter output for "Obfuscated" Copybook
     * @throws IOException
     * @throws JAXBException
     * @throws ParserException
     * @throws LexerException
     * @throws XMLStreamException
     */
    public GenerateJsonRepresentation(Reader copybookReader, String copybookname, Writer copybookWriter) throws IOException, JAXBException, ParserException, LexerException, XMLStreamException {
        Copybook copybook = CobolParser.newParser()
                .parseCobol(copybookReader, copybookname, Cb2xmlConstants.USE_LONG_LINE);
        List<Item> items = copybook.getItem();

        copybookReader.close();
        String json = new Gson().toJson(items);
        System.out.println(json);

        copybookWriter.close();
    }


    /**
     * @param w
     * @param indent
     * @param b
     * @throws IOException
     */
    private void printCurrentLine(BufferedWriter w, int indentAmount,
                                  StringBuilder b) throws IOException {
        w.write(b.toString());
        w.newLine();
        b.setLength(indentAmount);
        for (int i = 0; i < indentAmount; i++) {
            b.setCharAt(i, ' ');
        }
    }

    public static void main(String[] args) throws IOException, JAXBException, ParserException, LexerException, XMLStreamException {
        if (args == null || args.length == 0) {

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            String absolutePath = Paths.get(classloader.getResource("BitOfEverything.cbl").getFile()).toString();
            new GenerateJsonRepresentation(absolutePath);
        } else if (args.length == 1) {
            new GenerateJsonRepresentation(args[0]);
        } else {
            new GenerateJsonRepresentation(args[0], args[1]);
        }

    }

}
