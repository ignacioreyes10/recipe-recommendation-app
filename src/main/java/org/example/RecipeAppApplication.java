package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

public class RecipeAppApplication {

    public static void main(String[] args) throws Exception {

        // load recipes XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document recipesDoc = builder.parse("src/main/resources/recipes.xml");

        // load users XML
        Document usersDoc = builder.parse("src/main/resources/users.xml");

        // create XPath
        XPath xpath = XPathFactory.newInstance().newXPath();

        // get user skill
        String skill = xpath.compile("//user/skill/text()")
                .evaluate(usersDoc);

        // get user cuisine
        String cuisine = xpath.compile("//user/preferredCuisine/text()")
                .evaluate(usersDoc);

        System.out.println("User skill: " + skill);
        System.out.println("Preferred cuisine: " + cuisine);

        // MAIN QUERY (IMPORTANTE)
        String expression = "//recipe[difficulty='" + skill + "' and cuisine='" + cuisine + "']";

        NodeList nodes = (NodeList) xpath.compile(expression)
                .evaluate(recipesDoc, XPathConstants.NODESET);

        System.out.println("\nRecommended recipes:");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element recipe = (Element) nodes.item(i);
            String title = recipe.getElementsByTagName("title")
                    .item(0).getTextContent();
            System.out.println("- " + title);
        }
    }
}
