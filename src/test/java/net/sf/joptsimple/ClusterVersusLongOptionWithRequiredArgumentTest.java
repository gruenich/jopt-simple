/*
 The MIT License

 Copyright (c) 2004-2021 Paul R. Holser, Jr.

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package net.sf.joptsimple;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class ClusterVersusLongOptionWithRequiredArgumentTest extends AbstractOptionParserFixture {
    @BeforeEach
    public final void initializeParser() {
        parser.accepts( "fox" );
        parser.accepts( "f" );
        parser.accepts( "o" );
        parser.accepts( "x" ).withRequiredArg();
    }

    @Test
    public void resolvesToLongOptionEvenWithMatchingShortOptions() {
        OptionSet options = parser.parse( "--fox" );
        assertTrue( options.has( "fox" ) );
        assertFalse( options.has( "f" ) );
        assertFalse( options.has( "o" ) );
        assertFalse( options.has( "x" ) );
    }

    @Test
    public void resolvesToLongOptionWithSingleDashEvenWithMatchingShortOptions() {
        OptionSet options = parser.parse( "-fox" );
        assertTrue( options.has( "fox" ) );
        assertFalse( options.has( "f" ) );
        assertFalse( options.has( "o" ) );
        assertFalse( options.has( "x" ) );
    }

    @Test
    public void resolvesAbbreviationToLongOption() {
        OptionSet options = parser.parse( "-fo" );
        assertTrue( options.has( "fox" ) );
        assertFalse( options.has( "f" ) );
        assertFalse( options.has( "o" ) );
    }

    @Test
    public void resolvesShortOptionToShortOption() {
        OptionSet options = parser.parse( "-f" );
        assertFalse( options.has( "fox" ) );
        assertTrue( options.has( "f" ) );
    }

    @Test
    public void resolvesShortOptionToShortOptionEvenWithDoubleHyphen() {
        OptionSet options = parser.parse( "--f" );
        assertFalse( options.has( "fox" ) );
        assertTrue( options.has( "f" ) );
    }

    @Test
    public void resolvesToShortOptionsWithArgumentFollowingX() {
        OptionSet options = parser.parse( "-foxbar" );
        assertFalse( options.has( "fox" ) );
        assertTrue( options.has( "f" ) );
        assertTrue( options.has( "o" ) );
        assertTrue( options.has( "x" ) );
        assertEquals( singletonList( "bar" ), options.valuesOf( "x" ) );
    }

    @Test
    public void shortOptionsInDifferentOrder() {
        OptionSet options = parser.parse( "-fxo" );
        assertFalse( options.has( "fox" ) );
        assertTrue( options.has( "f" ) );
        assertFalse( options.has( "o" ) );
        assertTrue( options.has( "x" ) );
        assertEquals( singletonList( "o" ), options.valuesOf( "x" ) );
    }

    @Test
    public void longOptionWithMessedUpOrder() {
        assertThrows( OptionException.class, () -> parser.parse( "--fxo" ));
    }

    @Test
    public void withArgumentComingAfterCluster() {
        OptionSet options = parser.parse( "-fox", "bar" );

        assertTrue( options.has( "fox" ) );
        assertFalse( options.has( "f" ) );
        assertFalse( options.has( "o" ) );
        assertFalse( options.has( "x" ) );
        assertEquals( singletonList( "bar" ), options.nonOptionArguments() );
    }
}
