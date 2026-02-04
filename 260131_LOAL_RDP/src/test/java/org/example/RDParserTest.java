package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RDParserTest {

    @Test
    void evaluatesRightAssociativeExponent() throws RDParserException {
        RDParser parser = new RDParser("2^3^2");
        assertEquals(512.0, parser.evaluate(), 1e-9);
    }

    @Test
    void respectsPowerPriorityInMixedExpression() throws RDParserException {
        RDParser parser = new RDParser("4+5*2^2");
        assertEquals(24.0, parser.evaluate(), 1e-9);
    }

    @Test
    void handlesParenthesizedBases() throws RDParserException {
        RDParser parser = new RDParser("(2+1)^2");
        assertEquals(9.0, parser.evaluate(), 1e-9);
    }

    @Test
    void resolvesVariablesFromProvidedMap() throws RDParserException {
        Map<String, Double> vars = new HashMap<>();
        vars.put("x", 3.0);
        RDParser parser = new RDParser("x^2", vars);
        assertEquals(9.0, parser.evaluate(), 1e-9);
    }

    @Test
    void usesBuiltInConstants() throws RDParserException {
        RDParser parser = new RDParser("pi+e");
        assertEquals(Math.PI + Math.E, parser.evaluate(), 1e-9);
    }
}
