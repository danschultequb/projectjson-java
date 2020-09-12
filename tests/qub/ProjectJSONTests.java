package qub;

public interface ProjectJSONTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(ProjectJSON.class, () ->
        {
            runner.test("constructor()", (Test test) ->
            {
                final ProjectJSON projectJSON = ProjectJSON.create();
                test.assertNull(projectJSON.getPublisher());
                test.assertNull(projectJSON.getProject());
                test.assertNull(projectJSON.getVersion());
                test.assertNull(projectJSON.getJava());
            });

            runner.testGroup("setPublisher(String)", () ->
            {
                final Action2<String,Throwable> setPublisherErrorTest = (String publisher, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(publisher), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.assertThrows(() -> projectJSON.setPublisher(publisher), expected);
                        test.assertNull(projectJSON.getPublisher());
                    });
                };

                setPublisherErrorTest.run(null, new PreConditionFailure("publisher cannot be null."));
                setPublisherErrorTest.run("", new PreConditionFailure("publisher cannot be empty."));

                final Action1<String> setPublisherTest = (String publisher) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(publisher), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.<ProjectJSON>assertSame(projectJSON, projectJSON.setPublisher(publisher));
                        test.assertEqual(publisher, projectJSON.getPublisher());
                    });
                };

                setPublisherTest.run("apples");
                setPublisherTest.run("mangoes");
            });

            runner.testGroup("setProject(String)", () ->
            {
                final Action2<String,Throwable> setProjectErrorTest = (String project, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(project), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.assertThrows(() -> projectJSON.setProject(project), expected);
                        test.assertNull(projectJSON.getProject());
                    });
                };

                setProjectErrorTest.run(null, new PreConditionFailure("project cannot be null."));
                setProjectErrorTest.run("", new PreConditionFailure("project cannot be empty."));

                final Action1<String> setProjectTest = (String project) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(project), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.<ProjectJSON>assertSame(projectJSON, projectJSON.setProject(project));
                        test.assertEqual(project, projectJSON.getProject());
                    });
                };

                setProjectTest.run("apples");
                setProjectTest.run("bananas");
            });

            runner.testGroup("setVersion(String)", () ->
            {
                final Action2<String,Throwable> setVersionErrorTest = (String version, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.assertThrows(() -> projectJSON.setVersion(version), expected);
                        test.assertNull(projectJSON.getVersion());
                    });
                };

                setVersionErrorTest.run(null, new PreConditionFailure("version cannot be null."));
                setVersionErrorTest.run("", new PreConditionFailure("version cannot be empty."));

                final Action1<String> setVersionTest = (String version) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        final ProjectJSON setVersionResult = projectJSON.setVersion(version);
                        test.assertSame(projectJSON, setVersionResult);
                        test.assertEqual(version, projectJSON.getVersion().toString());
                    });
                };

                setVersionTest.run("apples");
                setVersionTest.run("apricots");
            });

            runner.testGroup("setVersion(VersionNumber)", () ->
            {
                final Action2<VersionNumber,Throwable> setVersionErrorTest = (VersionNumber version, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        test.assertThrows(() -> projectJSON.setVersion(version), expected);
                        test.assertNull(projectJSON.getVersion());
                    });
                };

                setVersionErrorTest.run(null, new PreConditionFailure("version cannot be null."));
                setVersionErrorTest.run(VersionNumber.create(), new PreConditionFailure("version cannot be empty."));

                final Action1<VersionNumber> setVersionTest = (VersionNumber version) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSON projectJSON = ProjectJSON.create();
                        final ProjectJSON setVersionResult = projectJSON.setVersion(version);
                        test.assertSame(projectJSON, setVersionResult);
                        test.assertEqual(version, projectJSON.getVersion());
                    });
                };

                setVersionTest.run(VersionNumber.create().addParts(1, 2, 3));
                setVersionTest.run(VersionNumber.create().setSuffix("apricots"));
            });

            runner.testGroup("setJava()", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSON projectJSON = ProjectJSON.create();
                    test.assertThrows(() -> projectJSON.setJava(null),
                        new PreConditionFailure("java cannot be null."));
                    test.assertNull(projectJSON.getJava());
                });

                runner.test("with non-null", (Test test) ->
                {
                    final ProjectJSON projectJSON = ProjectJSON.create();
                    final ProjectJSONJava java = ProjectJSONJava.create();
                    test.assertSame(projectJSON, projectJSON.setJava(java));
                    test.assertEqual(java, projectJSON.getJava());
                });
            });

            runner.testGroup("equals(Object)", () ->
            {
                final Action3<ProjectJSON,Object,Boolean> equalsTest = (ProjectJSON projectJson, Object rhs, Boolean expected) ->
                {
                    runner.test("with " + projectJson + " and " + rhs, (Test test) ->
                    {
                        test.assertEqual(expected, projectJson.equals(rhs));
                    });
                };

                equalsTest.run(ProjectJSON.create(), null, false);
                equalsTest.run(ProjectJSON.create(), "hello", false);
                equalsTest.run(ProjectJSON.create(), ProjectJSON.create(), true);
                equalsTest.run(
                    ProjectJSON.create().setPublisher("a"),
                    ProjectJSON.create().setPublisher("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setProject("a"),
                    ProjectJSON.create().setProject("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setVersion("a"),
                    ProjectJSON.create().setVersion("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setJava(ProjectJSONJava.create()),
                    ProjectJSON.create(),
                    false);
            });

            runner.testGroup("equals(ProjectJSON)", () ->
            {
                final Action3<ProjectJSON,ProjectJSON,Boolean> equalsTest = (ProjectJSON projectJson, ProjectJSON rhs, Boolean expected) ->
                {
                    runner.test("with " + projectJson + " and " + rhs, (Test test) ->
                    {
                        test.assertEqual(expected, projectJson.equals(rhs));
                    });
                };

                equalsTest.run(ProjectJSON.create(), null, false);
                equalsTest.run(ProjectJSON.create(), ProjectJSON.create(), true);
                equalsTest.run(
                    ProjectJSON.create().setPublisher("a"),
                    ProjectJSON.create().setPublisher("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setProject("a"),
                    ProjectJSON.create().setProject("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setVersion("a"),
                    ProjectJSON.create().setVersion("b"),
                    false);
                equalsTest.run(
                    ProjectJSON.create().setJava(ProjectJSONJava.create()),
                    ProjectJSON.create(),
                    false);
            });

            runner.testGroup("parse(File)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSON.parse((File)null),
                        new PreConditionFailure("projectJsonFile cannot be null."));
                });

                runner.test("with file that doesn't exist", (Test test) ->
                {
                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final File file = fileSystem.getFile("/file.txt").await();
                    test.assertThrows(() -> ProjectJSON.parse(file).await(),
                        new FileNotFoundException("/file.txt"));
                });

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                        fileSystem.createRoot("/").await();
                        final File file = fileSystem.createFile("/file.txt").await();
                        file.setContentsAsString(text).await();
                        test.assertEqual(expected, ProjectJSON.parse(file).await());
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSON.create());
                parseTest.run(
                    "{\"publisher\":\"a\"}",
                    ProjectJSON.create().setPublisher("a"));
                parseTest.run(
                    "{\"publisher\":5}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("publisher", 5)));
                parseTest.run(
                    "{\"project\":\"b\"}",
                    ProjectJSON.create().setProject("b"));
                parseTest.run(
                    "{\"project\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("project", true)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSON.create().setVersion("c"));
                parseTest.run(
                    "{\"version\":10}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("version", 10)));
                parseTest.run(
                    "{\"version\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("version", Iterable.create())));
                parseTest.run(
                    "{\"java\":{}}",
                    ProjectJSON.create()
                        .setJava(ProjectJSONJava.create()));
                parseTest.run(
                    "{\"java\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("java", Iterable.create())));
                parseTest.run(
                    "{\"java\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", true)));
                parseTest.run(
                    "{\"java\":false}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", false)));
            });

            runner.testGroup("parse(String)", () ->
            {
                final Action2<String,Throwable> parseErrorTest = (String text, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertThrows(() -> ProjectJSON.parse(text).await(),
                            expected);
                    });
                };

                parseErrorTest.run(null, new PreConditionFailure("text cannot be null."));
                parseErrorTest.run("", new ParseException("Missing object left curly bracket ('{')."));
                parseErrorTest.run("[]", new ParseException("Expected object left curly bracket ('{')."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(text).await());
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSON.create());
                parseTest.run(
                    "{\"publisher\":\"a\"}",
                    ProjectJSON.create().setPublisher("a"));
                parseTest.run(
                    "{\"publisher\":5}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("publisher", 5)));
                parseTest.run(
                    "{\"project\":\"b\"}",
                    ProjectJSON.create().setProject("b"));
                parseTest.run(
                    "{\"project\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("project", true)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSON.create().setVersion("c"));
                parseTest.run(
                    "{\"version\":10}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("version", 10)));
                parseTest.run(
                    "{\"version\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("version", Iterable.create())));
                parseTest.run(
                    "{\"java\":{}}",
                    ProjectJSON.create()
                        .setJava(ProjectJSONJava.create()));
                parseTest.run(
                    "{\"java\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("java", Iterable.create())));
                parseTest.run(
                    "{\"java\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", true)));
                parseTest.run(
                    "{\"java\":false}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", false)));
            });

            runner.testGroup("parse(Iterable<Character>)", () ->
            {
                final Action2<String,Throwable> parseErrorTest = (String text, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertThrows(() -> ProjectJSON.parse(text == null ? null : Strings.iterable(text)).await(),
                            expected);
                    });
                };

                parseErrorTest.run(null, new PreConditionFailure("characters cannot be null."));
                parseErrorTest.run("", new ParseException("Missing object left curly bracket ('{')."));
                parseErrorTest.run("[]", new ParseException("Expected object left curly bracket ('{')."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(Strings.iterable(text)).await());
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSON.create());
                parseTest.run(
                    "{\"publisher\":\"a\"}",
                    ProjectJSON.create().setPublisher("a"));
                parseTest.run(
                    "{\"publisher\":5}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("publisher", 5)));
                parseTest.run(
                    "{\"project\":\"b\"}",
                    ProjectJSON.create().setProject("b"));
                parseTest.run(
                    "{\"project\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("project", true)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSON.create().setVersion("c"));
                parseTest.run(
                    "{\"version\":10}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("version", 10)));
                parseTest.run(
                    "{\"version\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("version", Iterable.create())));
                parseTest.run(
                    "{\"java\":{}}",
                    ProjectJSON.create()
                        .setJava(ProjectJSONJava.create()));
                parseTest.run(
                    "{\"java\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("java", Iterable.create())));
                parseTest.run(
                    "{\"java\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", true)));
                parseTest.run(
                    "{\"java\":false}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", false)));
            });

            runner.testGroup("parse(Iterator<Character>)", () ->
            {
                final Action2<String,Throwable> parseErrorTest = (String text, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertThrows(() -> ProjectJSON.parse(text == null ? null : Strings.iterate(text)).await(),
                            expected);
                    });
                };

                parseErrorTest.run(null, new PreConditionFailure("characters cannot be null."));
                parseErrorTest.run("", new ParseException("Missing object left curly bracket ('{')."));
                parseErrorTest.run("[]", new ParseException("Expected object left curly bracket ('{')."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(Strings.iterate(text)).await());
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSON.create());
                parseTest.run(
                    "{\"publisher\":\"a\"}",
                    ProjectJSON.create().setPublisher("a"));
                parseTest.run(
                    "{\"publisher\":5}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("publisher", 5)));
                parseTest.run(
                    "{\"project\":\"b\"}",
                    ProjectJSON.create().setProject("b"));
                parseTest.run(
                    "{\"project\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("project", true)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSON.create().setVersion("c"));
                parseTest.run(
                    "{\"version\":10}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("version", 10)));
                parseTest.run(
                    "{\"version\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("version", Iterable.create())));
                parseTest.run(
                    "{\"java\":{}}",
                    ProjectJSON.create()
                        .setJava(ProjectJSONJava.create()));
                parseTest.run(
                    "{\"java\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("java", Iterable.create())));
                parseTest.run(
                    "{\"java\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", true)));
                parseTest.run(
                    "{\"java\":false}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", false)));
            });

            runner.testGroup("create(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSON.create((JSONObject)null),
                        new PreConditionFailure("rootObject cannot be null."));
                });

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.create(JSON.parseObject(text).await()));
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSON.create());
                parseTest.run(
                    "{\"publisher\":\"a\"}",
                    ProjectJSON.create().setPublisher("a"));
                parseTest.run(
                    "{\"publisher\":5}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("publisher", 5)));
                parseTest.run(
                    "{\"project\":\"b\"}",
                    ProjectJSON.create().setProject("b"));
                parseTest.run(
                    "{\"project\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("project", true)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSON.create().setVersion("c"));
                parseTest.run(
                    "{\"version\":10}",
                    ProjectJSON.create(JSONObject.create()
                        .setNumber("version", 10)));
                parseTest.run(
                    "{\"version\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("version", Iterable.create())));
                parseTest.run(
                    "{\"java\":{}}",
                    ProjectJSON.create()
                        .setJava(ProjectJSONJava.create()));
                parseTest.run(
                    "{\"java\":[]}",
                    ProjectJSON.create(JSONObject.create()
                        .setArray("java", Iterable.create())));
                parseTest.run(
                    "{\"java\":true}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", true)));
                parseTest.run(
                    "{\"java\":false}",
                    ProjectJSON.create(JSONObject.create()
                        .setBoolean("java", false)));
            });

            runner.testGroup("toString()", () ->
            {
                final Action2<ProjectJSON,String> parseTest = (ProjectJSON projectJson, String expected) ->
                {
                    runner.test("with " + projectJson, (Test test) ->
                    {
                        test.assertEqual(expected, projectJson.toString());
                    });
                };

                parseTest.run(ProjectJSON.create(), "{}");
                parseTest.run(ProjectJSON.create().setPublisher("a"), "{\"publisher\":\"a\"}");
                parseTest.run(ProjectJSON.create().setProject("b"), "{\"project\":\"b\"}");
                parseTest.run(ProjectJSON.create().setVersion("c"), "{\"version\":\"c\"}");
                parseTest.run(ProjectJSON.create().setJava(ProjectJSONJava.create()), "{\"java\":{}}");
            });

            runner.testGroup("toString(JSONFormat)", () ->
            {
                final Action3<ProjectJSON,JSONFormat,String> parseTest = (ProjectJSON projectJson, JSONFormat format, String expected) ->
                {
                    runner.test("with " + projectJson, (Test test) ->
                    {
                        test.assertEqual(expected, projectJson.toString(format));
                    });
                };

                parseTest.run(ProjectJSON.create(), JSONFormat.consise, "{}");
                parseTest.run(ProjectJSON.create().setPublisher("a"), JSONFormat.consise, "{\"publisher\":\"a\"}");
                parseTest.run(ProjectJSON.create().setProject("b"), JSONFormat.consise, "{\"project\":\"b\"}");
                parseTest.run(ProjectJSON.create().setVersion("c"), JSONFormat.consise, "{\"version\":\"c\"}");
                parseTest.run(ProjectJSON.create().setJava(ProjectJSONJava.create()), JSONFormat.consise, "{\"java\":{}}");

                parseTest.run(ProjectJSON.create(), JSONFormat.pretty, "{}");
                parseTest.run(ProjectJSON.create().setPublisher("a"), JSONFormat.pretty, "{\n  \"publisher\": \"a\"\n}");
                parseTest.run(ProjectJSON.create().setProject("b"), JSONFormat.pretty, "{\n  \"project\": \"b\"\n}");
                parseTest.run(ProjectJSON.create().setVersion("c"), JSONFormat.pretty, "{\n  \"version\": \"c\"\n}");
                parseTest.run(ProjectJSON.create().setJava(ProjectJSONJava.create()), JSONFormat.pretty, "{\n  \"java\": {}\n}");
            });
        });
    }
}
