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

package tests.joptsimple;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import joptsimple.OptionException;
import joptsimple.OptionSet;

/**
 * @author <a href="mailto:pholser@alumni.rice.edu">Paul Holser</a>
 */
public class ShortOptionsOptionalArgumentTest extends AbstractOptionParserFixture {
    @BeforeEach
    public final void initializeParser() {
        parser.accepts( "f" ).withOptionalArg();
        parser.accepts( "g" ).withOptionalArg();
        parser.accepts( "bar" ).withOptionalArg();
    }

    @Test
    public void optionWithOptionalArgumentNotPresent() {
        OptionSet options = parser.parse( "-f" );

        assertOptionDetected( options, "f" );
        assertEquals( emptyList(), options.valuesOf( "f" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void optionWithOptionalArgumentPresent() {
        OptionSet options = parser.parse( "-f", "bar" );

        assertOptionDetected( options, "f" );
        assertEquals( singletonList( "bar" ), options.valuesOf( "f" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void optionWithOptionalArgumentThatLooksLikeAnInvalidOption() {
        var exception = assertThrows( OptionException.class, () -> parser.parse( "-f", "--biz" ) );
        assertTrue( exception.options().contains( "biz" ) );
    }

    @Test
    public void optionWithOptionalArgumentThatLooksLikeAValidOption() {
        OptionSet options = parser.parse( "-f", "--bar" );

        assertOptionDetected( options, "f" );
        assertOptionDetected( options, "bar" );
        assertEquals( emptyList(), options.valuesOf( "f" ) );
        assertEquals( emptyList(), options.valuesOf( "bar" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void optionWithOptionalArgumentFollowedByLegalOption() {
        OptionSet options = parser.parse( "-f", "-g" );

        assertOptionDetected( options, "f" );
        assertOptionDetected( options, "g" );
        assertEquals( emptyList(), options.valuesOf( "f" ) );
        assertEquals( emptyList(), options.valuesOf( "g" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void multipleOfSameOptionSomeWithArgsAndSomeWithout() {
        OptionSet options = parser.parse( "-f", "-f", "foo", "-f", "-f", "bar", "-f" );

        assertEquals( asList( "foo", "bar" ), options.valuesOf( "f" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }
}
