# Change Log

## Changes in version 6.0

* Renamed main package to net.sf.joptsimple
* Added Java module support
* Adopted Gradle
* Update Java baseline to 17
* Resolved [gh-96](https://github.com/pholser/jopt-simple/issues/96) so that help formatter descriptions for options whose arguments have default values can use `ValueConverter.revert()` on the result of `OptionDescriptor.converter()` to display the default values in a manner other than their `toString()` representations.
* Resolved [gh-101](https://github.com/pholser/jopt-simple/issues/101) by adding `OptionSet.valueOfOptional()` and `OptionSpec.valueOptional()`.

## Changes in version 5.0.4

* Resolved [gh-122](https://github.com/pholser/jopt-simple/issues/122) so that long options ending with an equals will have an empty value.

## Changes in version 5.0.3

* Resolved [gh-96](https://github.com/pholser/jopt-simple/issues/96) so that options that take an argument but don't change the argument type from `String` still show a `String` type indicator in the default option help.
* Resolved [gh-104](https://github.com/pholser/jopt-simple/issues/104) so that `EnumConverter` performs case-insensitive matching against arguments of options. Thanks to Martin Paljak for this.

## Changes in version 5.0.2

* Made some package-private abstract classes become public classes with package-private constructors. This makes it possible to call some methods from Kotlin that were previously inaccessible. Thanks to Mirko Friedenhagen for this.

## Changes in version 5.0.1

* Resolved [gh-92](https://github.com/pholser/jopt-simple/issues/92) so that in the event that `printHelpOn()` is called more than once, the output is not duplicated.

## Changes in version 5.0

* Abandoning JDKs prior to 7. All source is Java 7-compatible, and bytecode is compiled to 1.7 version.
* Resolved [gh-51](https://github.com/pholser/jopt-simple/issues/51) by adding `OptionSpecBuilder.availableIf()` and `OptionSpecBuilder.availableUnless()`. Thanks to Christian Ohr for this.
* Resolved [gh-70](https://github.com/pholser/jopt-simple/issues/70) by adding `EnumConverter` and `PathConverter`. Thanks to Christian Ohr for this.
* Resolved [gh-88](https://github.com/pholser/jopt-simple/issues/88) by adding an `OptionParser` constructor to allow suppression of option abbreviations. Thanks to Louis Bergelson for this.

## Changes in version 4.10

* Resolved [gh-85](https://github.com/pholser/jopt-simple/issues/85) by correcting the description column width consumption of the built-in help formatter.

# Change Log

## Changes in version 4.9

* Resolved [gh-79](https://github.com/pholser/jopt-simple/issues/79) by correcting the behavior of `OptionException.multipleOptionString` when handling options with synonyms.
* Resolved [gh-72](https://github.com/pholser/jopt-simple/issues/72) by externalizing some of the literal strings in `BuiltinHelpFormatter` into resource bundles.
* Resolved [gh-76](ttps://github.com/pholser/jopt-simple/issues/76) by modifying the behavior of `OptionalArgumentOptionSpec` so that if the argument following the option does not "look like" an option but can be converted to the option argument's type, treat the argument as the argument of the option.
* Resolved [gh-68](https://github.com/pholser/jopt-simple/issues/68) by modifying `BuiltinHelpFormatter` to be more extensible and documenting the behavior of the newly accessible methods.
* Resolved [gh-73](https://github.com/pholser/jopt-simple/issues/73) by correcting the behavior of `OptionSet.specs()` to remove all instances of the non-option argument spec.

## Changes in version 4.8

* Resolved [gh-65](https://github.com/pholser/jopt-simple/issues/65) by modifying the build file to create a JAR with OSGi metadata.
* Resolved [gh-63](https://github.com/pholser/jopt-simple/issues/63) by externalizing exception messages into resource bundles. Currently, we ship only with messages for locale "en_US". Translations for other locales are more than welcome.
* Resolved [gh-58](https://github.com/pholser/jopt-simple/issues/58) by rewriting exception messaging to clarify synonymous options. Synonyms are separated by slashes (/); lists of distinct options will be separated by commas (,) in square brackets ([]).

## Changes in version 4.7

* Resolved [gh-57](https://github.com/pholser/jopt-simple/issues/57) by admitting the underscore as a legal option character.
* Resolved [gh-53](https://github.com/pholser/jopt-simple/issues/53) by correcting `OptionSet.hasOptions()` to answer correctly for no switches.
* Resolved [gh-56](https://github.com/pholser/jopt-simple/issues/56) by correcting the default help formatting not to use a `Set` for rows of output, but `List`.
* Resolved [gh-59](https://github.com/pholser/jopt-simple/issues/59) by relaxing the return type of `ValueConverter.valueType()`.

## Changes in version 4.6

* Resolved [gh-31](https://github.com/pholser/jopt-simple/issues/31) by offering `OptionSpecBuilder.requiredUnless()`. Thanks to Christian Ohr for this.
* Resolved [gh-38](https://github.com/pholser/jopt-simple/issues/38) by offering `OptionParser.recognizedOptions()`. Thanks to Antoine Neveux for this.
* Resolved [gh-35](https://github.com/pholser/jopt-simple/issues/35) by offering `OptionSet.asMap()`. Thanks to Brian Oxley for this.

## Changes in version 4.5

* Resolved [gh-17](https://github.com/pholser/jopt-simple/issues/17) by offering `OptionParser.nonOptions()` and `NonOptionArgumentSpec`.
* Resolved [gh-27](https://github.com/pholser/jopt-simple/issues/27) by offering `OptionParser.allowsUnrecognizedOptions()`. Thanks to Erik Broes for this.

## Changes in version 4.4

* Resolved [gh-16](https://github.com/pholser/jopt-simple/issues/16) by offering `BuiltinHelpFormatter` that allows configuration of overall row width and column separator width. Thanks to Ryan Breidenbach for contributing code to this.
* Resolved [gh-12](https://github.com/pholser/jopt-simple/issues/12) by offering `OptionSpecBuilder.requiredIf()`.
* Resolved [gh-22](https://github.com/pholser/jopt-simple/issues/22). Thanks to El Kodus for this.
* Resolved [gh-19](https://github.com/pholser/jopt-simple/issues/19). Thanks to El Kodus for this.
* Resolved [gh-14](https://github.com/pholser/jopt-simple/issues/14) by offering `AbstractOptionSpec.forHelp()`.
* Resolved [gh-13](https://github.com/pholser/jopt-simple/issues/13) by offering `ArgumentAcceptingOptionSpec.withValuesSeparatedBy(String)`.
* Added `InetAddressValueConverter`. Thanks to Raymund Fülöp for this.

## Changes in version 4.3

* Resolved [gh-9](https://github.com/pholser/jopt-simple/issues/9) by offering `OptionSet.specs()`, which gives a list of the specs corresponding to the options detected on a parse, in the order in which the options occurred on the command line.

## Changes in version 4.2

* Resolved [gh-8](https://github.com/pholser/jopt-simple/issues/8) by offering `ArgumentAcceptingOptionSpec.defaultsTo(V[])` in addition to `ArgumentAcceptingOptionSpec.defaultsTo(V, V...)`.
* Removing some internal unused classes and methods.

## Changes in version 4.1

* Resolved [gh-7](https://github.com/pholser/jopt-simple/issues/7) by allowing short option clusters to contain options which can accept arguments. When such an option is encountered, the remaining characters in the cluster are treated as the argument to the option. Thanks to Alan van Dam for this.
* Resolved [gh-6](https://github.com/pholser/jopt-simple/issues/6) with general improvements to the project's site. Thanks to Michael Osipov for this.

## Changes in version 4.0

* Resolved [gh-4](https://github.com/pholser/jopt-simple/issues/4) by adding method `OptionParser.formatHelpWith(HelpFormatter)` to allow programmers to influence what help is printed with `OptionParser.printHelpOn()`. A `HelpFormatter` is handed a map, keyed by option text, whose values are `OptionDescriptor`s that describe the options the parser has been configured with.
* Added method `OptionSet.hasOptions()`. Thanks to Michael Osipov for this.
* Resolved [gh-3](https://github.com/pholser/jopt-simple/issues/3) by using `SimpleDateFormat.toPattern()` rather than `SimpleDateFormat.toLocalizedPattern()` in `DateConverter`. Thanks to Michael Osipov for this.
* Resolved [gh-5](https://github.com/pholser/jopt-simple/issues/5) by allowing primitive `Class` objects whose wrapper types are considered "value types" for purposes of `ArgumentAcceptingOptionSpec.ofType()` in place of the wrapper classes. Thanks to Daniel Yokomizo for suggesting this.

## Changes in version 3.3

* Resolved [gh-1](https://github.com/pholser/jopt-simple/issues/1) by adding method `required()` to class `ArgumentAcceptingOptionSpec`, to allow callers to indicate that a given option must be present on the command line. Thanks to Emils Solmanis for adding this.

## Changes in version 3.2

* Added method `defaultsTo()` to class `ArgumentAcceptingOptionSpec`, to allow callers to specify default values for arguments of options. These influence the return values of `OptionSpec.value(s)()` and `OptionSet.value(s)Of()`. Default values also show up in the help screen entries for their options. This serves to resolve feature request 2484524.
* Fixed a problem whereby the empty string, a string consisting solely of whitespace, or a string with embedded whitespace weren't being properly recognized as arguments of options when they should have.
* Resolved feature request 2793762, having to do with improving the behavior of embedded newlines in option descriptions in help screens.

## Changes in version 3.1

* Added method `withValuesConvertedBy()` to class `ArgumentAcceptingOptionSpec`, to allow callers to specify converters or validators that transform arguments of options into instances of specific Java types. This is useful for types which do not meet the requirements of `ofType()`.
* Added classes `DateConverter` and `RegexMatcher` as examples of useful argument converters.

## Changes in version 3.0.1

* Dependency on Ant more appropriately test-scoped in the Maven POM. That way, if you use JOpt Simple with Maven, you don't download Ant unnecessarily.

## Changes in version 3.0

* Version 3.0 supports Java 5 and greater only. If you need to use JOpt Simple in a pre-Java-5 environment, use the latest 2.x release.
* Where appropriate, existing API calls have been updated to use Java generics.
* Extracted and surfaced interface `OptionSpec`. `OptionSpec`s returned by the fluent interface methods can be used to retrieve arguments of the options they represent in a type-safe manner.
* Removed all previously deprecated methods.
* Added methods to `OptionSet` to allow detection of options and retrieval of option arguments using instances of `OptionSpec`.
* Converted tests to JUnit 4.
* Switched to MIT License.
* Relaxing some `List` parameter types and return types of methods to `Collection`.
* `OptionArgumentConversionException` no longer drops the original cause on the floor; hence `OptionException` can now be created with a cause.
* Maven-ized the project web site.
* Overhauled the examples page.

## Changes in version 2.4.1

* Fixed bug 2018262.

## Changes in version 2.4

* Added the `acceptsAll()` method to class `OptionParser`. Options passed to a given invocation of this method are treated as synonymous, so that each gives the same answer when given as the argument to the methods `has()`, `valuesOf()`, etc. on `OptionSet`.
* Surfaced the class `KeyValuePair`. This class can be very handy as a value type for arguments whose values take on the form `key=value`, such as the `-D` arguments to JVMs.
* Fixed bug 1932577.
* Added method `withValuesSeparatedBy()` to class `ArgumentAcceptingOptionSpec`, to allow callers to specify multiple values for an option as a single argument with values separated by a given character.
* Method `ofType()` on class `ArgumentAcceptingOptionSpec` now returns self rather than `void`.
* Deprecated another "get for get's sake": `OptionParser.setPosixlyCorrect()`. It is replaced with a less Java-beany-looking method.
* Cleaned up the help screens produced by `OptionParser.printHelpOn()` so they are rendered as two 40-character columns, with long space-broken values split across lines as needed.
* Fixed bug 1956418.

## Changes in version 2.3.6

* No changes to code; just getting Maven to do releases with its plugins.

## Changes in version 2.3.3

* Deprecated method `OptionSet.wasDetected()` in favor of `OptionSet.has()` -- the new name seems to read better.
* `OptionException`s now override `getMessage()` sensibly, so that if a caller wants to handle the exception by catching it and displaying a message from the exception, she can do so and get satisfactory results.
* Maven-ized project's build.
* Minor internal changes.

## Changes in version 2.3.2

* Minor internal changes.

## Changes in version 2.3.1

* Fixed a bug with POSIX-ly correct parsers. It was previously thought that POSIX-ly correct parsers should signal end of options when they detect an argument that does not lexically look like an option and could not be an argument of a previous option, required or optional. Such parsers now signal end of options when they detect an argument that does not lexically look like an option, and is not an argument of a previous option with a required argument. If you want such an argument to be treated as the argument of a preceding option whose argument is optional, you can still get this behavior by appending the argument to the option, either with abutting syntax (`-d/tmp`) or key-value syntax (`-d=/tmp`).

## Changes in version 2.3

* No feature changes in this release; but this release can now be used with JDK 1.3. Previous releases could be used only with JDK 1.4 or newer.

## Changes in version 2.2

* Removed all previously deprecated methods.
* Re-clarified the contract of the one-arg `String` constructor of `OptionParser`: the constructor now raises `NullPointerException` if its argument is `null`. This is the convention for Java library methods which receive illegal `null` parameters.

## Changes in version 2.1

* Introduced a facility for `OptionParser`s to print a help screen, which describes the options they accept.
* Added the ability to provide descriptions of options and their arguments when configuring an `OptionParser`. These descriptions are printed in the aforementioned help screens.
* Clarified the contract of the one-arg `String` constructor of `OptionParser`: the constructor raises `IllegalArgumentException` if its argument is `null`.
* Deprecated `OptionParser.noArg()`, `OptionParser.requiredArg()`, and `OptionParser.optionalArg()`.
* Deprecated some "gets for gets' sake": `OptionException.getOption()`, `OptionSet.getNonOptionArguments()`. They are replaced with less Java-beany-looking methods.

## Changes in version 2.0

* Introduced a "fluent interface" API for specifying options for an `OptionParser` to recognize. The old methods for option specification still work--you need not convert to the new methods.
* Added the ability to specify that option arguments should be converted to specific types. You can do this either with the old option specification methods or with the new fluent interface API.
* Deprecated `OptionParser.requiresArg()` in favor of `OptionParser.requiredArg()` -- the new name seems to read better.

## Version 1.0

* First major release.
* Includes concrete classes `OptionParser` and `OptionSet`.
* Supports POSIX `getopt()` and GNU `getopt_long()` command line syntax.
* No type conversion on option arguments, they are all treated as `String`s.
* Methods `noArg()`, `requiredArg()`, and `optionalArg()` tell an `OptionParser` what options to recognize.