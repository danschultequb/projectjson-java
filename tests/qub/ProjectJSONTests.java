package qub;

public interface ProjectJSONTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(ProjectJSON.class, () ->
        {
            runner.test("constructor()", (Test test) ->
            {
                final ProjectJSON projectJSON = new ProjectJSON();
                test.assertNull(projectJSON.getPublisher());
                test.assertNull(projectJSON.getProject());
                test.assertNull(projectJSON.getVersion());
                test.assertNull(projectJSON.getJava());
            });

            runner.testGroup("setPublisher(String)", () ->
            {
                final Action1<String> setPublisherTest = (String publisher) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(publisher), (Test test) ->
                    {
                        final ProjectJSON projectJSON = new ProjectJSON();
                        test.<ProjectJSON>assertSame(projectJSON, projectJSON.setPublisher(publisher));
                        test.assertEqual(publisher, projectJSON.getPublisher());
                    });
                };

                setPublisherTest.run(null);
                setPublisherTest.run("");
                setPublisherTest.run("apples");
            });

            runner.testGroup("setProject(String)", () ->
            {
                final Action1<String> setProjectTest = (String project) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(project), (Test test) ->
                    {
                        final ProjectJSON projectJSON = new ProjectJSON();
                        test.<ProjectJSON>assertSame(projectJSON, projectJSON.setProject(project));
                        test.assertEqual(project, projectJSON.getProject());
                    });
                };

                setProjectTest.run(null);
                setProjectTest.run("");
                setProjectTest.run("apples");
            });

            runner.testGroup("setVersion(String)", () ->
            {
                final Action1<String> setVersionTest = (String version) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSON projectJSON = new ProjectJSON();
                        test.<ProjectJSON>assertSame(projectJSON, projectJSON.setVersion(version));
                        test.assertEqual(version, projectJSON.getVersion());
                    });
                };

                setVersionTest.run(null);
                setVersionTest.run("");
                setVersionTest.run("apples");
            });

            runner.testGroup("setJava()", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSON projectJSON = new ProjectJSON();
                    test.assertSame(projectJSON, projectJSON.setJava(null));
                    test.assertNull(projectJSON.getJava());
                });

                runner.test("with non-null", (Test test) ->
                {
                    final ProjectJSON projectJSON = new ProjectJSON();
                    final ProjectJSONJava java = new ProjectJSONJava();
                    test.assertSame(projectJSON, projectJSON.setJava(java));
                    test.assertSame(java, projectJSON.getJava());
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

                equalsTest.run(new ProjectJSON(), null, false);
                equalsTest.run(new ProjectJSON(), "hello", false);
                equalsTest.run(new ProjectJSON(), new ProjectJSON(), true);
                equalsTest.run(
                    new ProjectJSON().setPublisher("a"),
                    new ProjectJSON().setPublisher("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setProject("a"),
                    new ProjectJSON().setProject("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setVersion("a"),
                    new ProjectJSON().setVersion("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setJava(new ProjectJSONJava()),
                    new ProjectJSON(),
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

                equalsTest.run(new ProjectJSON(), null, false);
                equalsTest.run(new ProjectJSON(), new ProjectJSON(), true);
                equalsTest.run(
                    new ProjectJSON().setPublisher("a"),
                    new ProjectJSON().setPublisher("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setProject("a"),
                    new ProjectJSON().setProject("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setVersion("a"),
                    new ProjectJSON().setVersion("b"),
                    false);
                equalsTest.run(
                    new ProjectJSON().setJava(new ProjectJSONJava()),
                    new ProjectJSON(),
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

                parseTest.run("{}", new ProjectJSON());
                parseTest.run("{\"publisher\":\"a\"}", new ProjectJSON().setPublisher("a"));
                parseTest.run("{\"publisher\":5}", new ProjectJSON());
                parseTest.run("{\"project\":\"b\"}", new ProjectJSON().setProject("b"));
                parseTest.run("{\"project\":true}", new ProjectJSON());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSON().setVersion("c"));
                parseTest.run("{\"version\":10}", new ProjectJSON());
                parseTest.run("{\"version\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":{}}", new ProjectJSON().setJava(new ProjectJSONJava()));
                parseTest.run("{\"java\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":true}", new ProjectJSON());
                parseTest.run("{\"java\":false}", new ProjectJSON());
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
                parseErrorTest.run("", new PreConditionFailure("text cannot be empty."));
                parseErrorTest.run("[]", new PreConditionFailure("tokenizer.getCurrent() ([) must be {."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(text).await());
                    });
                };

                parseTest.run("{}", new ProjectJSON());
                parseTest.run("{\"publisher\":\"a\"}", new ProjectJSON().setPublisher("a"));
                parseTest.run("{\"publisher\":5}", new ProjectJSON());
                parseTest.run("{\"project\":\"b\"}", new ProjectJSON().setProject("b"));
                parseTest.run("{\"project\":true}", new ProjectJSON());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSON().setVersion("c"));
                parseTest.run("{\"version\":10}", new ProjectJSON());
                parseTest.run("{\"version\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":{}}", new ProjectJSON().setJava(new ProjectJSONJava()));
                parseTest.run("{\"java\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":true}", new ProjectJSON());
                parseTest.run("{\"java\":false}", new ProjectJSON());
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
                parseErrorTest.run("", new PreConditionFailure("characters cannot be empty."));
                parseErrorTest.run("[]", new PreConditionFailure("tokenizer.getCurrent() ([) must be {."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(Strings.iterable(text)).await());
                    });
                };

                parseTest.run("{}", new ProjectJSON());
                parseTest.run("{\"publisher\":\"a\"}", new ProjectJSON().setPublisher("a"));
                parseTest.run("{\"publisher\":5}", new ProjectJSON());
                parseTest.run("{\"project\":\"b\"}", new ProjectJSON().setProject("b"));
                parseTest.run("{\"project\":true}", new ProjectJSON());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSON().setVersion("c"));
                parseTest.run("{\"version\":10}", new ProjectJSON());
                parseTest.run("{\"version\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":{}}", new ProjectJSON().setJava(new ProjectJSONJava()));
                parseTest.run("{\"java\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":true}", new ProjectJSON());
                parseTest.run("{\"java\":false}", new ProjectJSON());
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
                parseErrorTest.run("", new PreConditionFailure("tokenizer.hasCurrent() cannot be false."));
                parseErrorTest.run("[]", new PreConditionFailure("tokenizer.getCurrent() ([) must be {."));

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(Strings.iterate(text)).await());
                    });
                };

                parseTest.run("{}", new ProjectJSON());
                parseTest.run("{\"publisher\":\"a\"}", new ProjectJSON().setPublisher("a"));
                parseTest.run("{\"publisher\":5}", new ProjectJSON());
                parseTest.run("{\"project\":\"b\"}", new ProjectJSON().setProject("b"));
                parseTest.run("{\"project\":true}", new ProjectJSON());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSON().setVersion("c"));
                parseTest.run("{\"version\":10}", new ProjectJSON());
                parseTest.run("{\"version\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":{}}", new ProjectJSON().setJava(new ProjectJSONJava()));
                parseTest.run("{\"java\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":true}", new ProjectJSON());
                parseTest.run("{\"java\":false}", new ProjectJSON());
            });

            runner.testGroup("parse(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSON.parse((JSONObject)null),
                        new PreConditionFailure("rootObject cannot be null."));
                });

                final Action2<String,ProjectJSON> parseTest = (String text, ProjectJSON expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(text), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSON.parse(JSON.parseObject(text).await()).await());
                    });
                };

                parseTest.run("{}", new ProjectJSON());
                parseTest.run("{\"publisher\":\"a\"}", new ProjectJSON().setPublisher("a"));
                parseTest.run("{\"publisher\":5}", new ProjectJSON());
                parseTest.run("{\"project\":\"b\"}", new ProjectJSON().setProject("b"));
                parseTest.run("{\"project\":true}", new ProjectJSON());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSON().setVersion("c"));
                parseTest.run("{\"version\":10}", new ProjectJSON());
                parseTest.run("{\"version\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":{}}", new ProjectJSON().setJava(new ProjectJSONJava()));
                parseTest.run("{\"java\":[]}", new ProjectJSON());
                parseTest.run("{\"java\":true}", new ProjectJSON());
                parseTest.run("{\"java\":false}", new ProjectJSON());
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

                parseTest.run(new ProjectJSON(), "{}");
                parseTest.run(new ProjectJSON().setPublisher("a"), "{\"publisher\":\"a\"}");
                parseTest.run(new ProjectJSON().setProject("b"), "{\"project\":\"b\"}");
                parseTest.run(new ProjectJSON().setVersion("c"), "{\"version\":\"c\"}");
                parseTest.run(new ProjectJSON().setJava(new ProjectJSONJava()), "{\"java\":{}}");
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

                parseTest.run(new ProjectJSON(), JSONFormat.consise, "{}");
                parseTest.run(new ProjectJSON().setPublisher("a"), JSONFormat.consise, "{\"publisher\":\"a\"}");
                parseTest.run(new ProjectJSON().setProject("b"), JSONFormat.consise, "{\"project\":\"b\"}");
                parseTest.run(new ProjectJSON().setVersion("c"), JSONFormat.consise, "{\"version\":\"c\"}");
                parseTest.run(new ProjectJSON().setJava(new ProjectJSONJava()), JSONFormat.consise, "{\"java\":{}}");

                parseTest.run(new ProjectJSON(), JSONFormat.pretty, "{}");
                parseTest.run(new ProjectJSON().setPublisher("a"), JSONFormat.pretty, "{\n  \"publisher\": \"a\"\n}");
                parseTest.run(new ProjectJSON().setProject("b"), JSONFormat.pretty, "{\n  \"project\": \"b\"\n}");
                parseTest.run(new ProjectJSON().setVersion("c"), JSONFormat.pretty, "{\n  \"version\": \"c\"\n}");
                parseTest.run(new ProjectJSON().setJava(new ProjectJSONJava()), JSONFormat.pretty, "{\n  \"java\": {}\n}");
            });
        });
    }
}
