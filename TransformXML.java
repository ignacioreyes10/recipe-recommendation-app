import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class TransformXML {

    public static void main(String[] args) throws Exception {

        TransformerFactory factory = TransformerFactory.newInstance();

        Source xslt = new StreamSource("src/main/resources/recipes.xsl");
        Transformer transformer = factory.newTransformer(xslt);

        Source xml = new StreamSource("src/main/resources/recipes.xml");

        transformer.transform(xml, new StreamResult("output.html"));

        System.out.println("HTML generated!");
    }
}
