<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
<body>

<h2>Recipes</h2>

<xsl:for-each select="recipes/recipe">

    <div>
        <h3><xsl:value-of select="title"/></h3>

        <p>
            Cuisine:
            <xsl:for-each select="cuisine">
                <xsl:value-of select="."/> 
            </xsl:for-each>
        </p>

        <p>
            Difficulty:
            <xsl:choose>

                <xsl:when test="difficulty='Beginner'">
                    <span style="color:green">Beginner</span>
                </xsl:when>

                <xsl:when test="difficulty='Intermediate'">
                    <span style="color:orange">Intermediate</span>
                </xsl:when>

                <xsl:otherwise>
                    <span style="color:red">Advanced</span>
                </xsl:otherwise>

            </xsl:choose>
        </p>

    </div>

</xsl:for-each>

</body>
</html>

</xsl:template>

</xsl:stylesheet>
