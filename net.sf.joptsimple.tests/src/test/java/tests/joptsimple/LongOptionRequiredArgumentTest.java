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
public class LongOptionRequiredArgumentTest extends AbstractOptionParserFixture {
    @BeforeEach
    public final void initializeParser() {
        parser.accepts( "quiet" ).withRequiredArg();
        parser.accepts( "a" ).withOptionalArg();
        parser.accepts( "y" ).withRequiredArg();
    }

    @Test
    public void argumentSeparate() {
        OptionSet options = parser.parse( "--quiet", "23" );

        assertOptionDetected( options, "quiet" );
        assertEquals( singletonList( "23" ), options.valuesOf( "quiet" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void argumentFollowedByLegalOption() {
        OptionSet options = parser.parse( "--quiet", "-a" );

        assertOptionDetected( options, "quiet" );
        assertOptionNotDetected( options, "a" );
        assertEquals( singletonList( "-a" ), options.valuesOf( "quiet" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void argumentTogether() {
        OptionSet options = parser.parse( "--quiet=23" );

        assertOptionDetected( options, "quiet" );
        assertEquals( singletonList( "23" ), options.valuesOf( "quiet" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void argumentMissing() {
        var exception = assertThrows( OptionException.class, () -> parser.parse( "--quiet" ) );
        assertTrue( exception.options().contains( "quiet" ) );
    }

    @Test
    public void shortOptionSpecifiedAsLongOptionWithArgument() {
        OptionSet options = parser.parse( "--y=bar" );

        assertOptionDetected( options, "y" );
        assertEquals( singletonList( "bar" ), options.valuesOf( "y" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }

    @Test
    public void whenEndOfOptionsMarkerIsInPlaceOfRequiredArgument() {
        OptionSet options = parser.parse( "--quiet", "--", "-y", "foo", "-a" );

        assertOptionDetected( options, "quiet" );
        assertOptionDetected( options, "y" );
        assertOptionDetected( options, "a" );
        assertEquals( singletonList( "--" ), options.valuesOf( "quiet" ) );
        assertEquals( singletonList( "foo" ), options.valuesOf( "y" ) );
        assertEquals( emptyList(), options.nonOptionArguments() );
    }
}
