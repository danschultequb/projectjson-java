package qub;

public interface ProjectJSONJavaTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(ProjectJSONJava.class, () ->
        {
            runner.test("constructor()", (Test test) ->
            {
                final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                test.assertNull(projectJSONJava.getDependencies());
                test.assertNull(projectJSONJava.getMainClass());
                test.assertNull(projectJSONJava.getShortcutName());
                test.assertNull(projectJSONJava.getVersion());
                test.assertNull(projectJSONJava.getOutputFolder());
                test.assertNull(projectJSONJava.getMaximumErrors());
                test.assertNull(projectJSONJava.getMaximumWarnings());
                test.assertNull(projectJSONJava.getSourceFilePatterns());
                test.assertNull(projectJSONJava.getDependencies());
            });

            runner.testGroup("setMainClass(String)", () ->
            {
                final Action1<String> setMainClassTest = (String mainClass) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(mainClass), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMainClass(mainClass));
                        test.assertEqual(mainClass, projectJSONJava.getMainClass());
                    });
                };

                setMainClassTest.run(null);
                setMainClassTest.run("");
                setMainClassTest.run("hello");
            });

            runner.testGroup("setShortcutName(String)", () ->
            {
                final Action1<String> setShortcutNameTest = (String shortcutName) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(shortcutName), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setShortcutName(shortcutName));
                        test.assertEqual(shortcutName, projectJSONJava.getShortcutName());
                    });
                };

                setShortcutNameTest.run(null);
                setShortcutNameTest.run("");
                setShortcutNameTest.run("hello");
            });

            runner.testGroup("setVersion(String)", () ->
            {
                final Action1<String> setVersionTest = (String version) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setVersion(version));
                        test.assertEqual(version, projectJSONJava.getVersion());
                    });
                };

                setVersionTest.run(null);
                setVersionTest.run("");
                setVersionTest.run("hello");
            });

            runner.testGroup("setOutputFolder(String)", () ->
            {
                final Action1<String> setOutputFolderTest = (String outputFolder) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(outputFolder), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setOutputFolder(outputFolder));
                        test.assertEqual(outputFolder, projectJSONJava.getOutputFolder());
                    });
                };

                setOutputFolderTest.run(null);
                setOutputFolderTest.run("");
                setOutputFolderTest.run("hello");
            });

            runner.testGroup("setMaximumErrors(Integer)", () ->
            {
                final Action1<Integer> setMaximumErrorsTest = (Integer maximumErrors) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(maximumErrors), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMaximumErrors(maximumErrors));
                        test.assertEqual(maximumErrors, projectJSONJava.getMaximumErrors());
                    });
                };

                setMaximumErrorsTest.run(null);
                setMaximumErrorsTest.run(0);
                setMaximumErrorsTest.run(-1);
                setMaximumErrorsTest.run(1);
            });

            runner.testGroup("setMaximumWarnings(Integer)", () ->
            {
                final Action1<Integer> setMaximumWarningsTest = (Integer maximumWarnings) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(maximumWarnings), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMaximumWarnings(maximumWarnings));
                        test.assertEqual(maximumWarnings, projectJSONJava.getMaximumWarnings());
                    });
                };

                setMaximumWarningsTest.run(null);
                setMaximumWarningsTest.run(0);
                setMaximumWarningsTest.run(-1);
                setMaximumWarningsTest.run(1);
            });

            runner.testGroup("setSourceFilePatterns(Iterable<PathPattern>)", () ->
            {
                final Action1<Iterable<PathPattern>> setSourceFilePatternsTest = (Iterable<PathPattern> sourceFilePatterns) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(sourceFilePatterns), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setSourceFilePatterns(sourceFilePatterns));
                        test.assertEqual(sourceFilePatterns, projectJSONJava.getSourceFilePatterns());
                    });
                };

                setSourceFilePatternsTest.run(null);
                setSourceFilePatternsTest.run(Iterable.create());
                setSourceFilePatternsTest.run(Iterable.create(PathPattern.parse("*.java")));
            });

            runner.testGroup("setDependencies(Iterable<ProjectSignature>)", () ->
            {
                final Action1<Iterable<ProjectSignature>> setDependenciesTest = (Iterable<ProjectSignature> dependencies) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(dependencies), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                        final ProjectJSONJava setDependenciesResult = projectJSONJava.setDependencies(dependencies);
                        test.assertSame(projectJSONJava, setDependenciesResult);
                        test.assertEqual(dependencies, projectJSONJava.getDependencies());
                    });
                };

                setDependenciesTest.run(null);
                setDependenciesTest.run(Iterable.create());
                setDependenciesTest.run(Iterable.create(new ProjectSignature("a", "b", "c")));
            });

            runner.testGroup("getTransitiveDependencies(QubFolder)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                    test.assertThrows(() -> projectJSONJava.getTransitiveDependencies(null),
                        new PreConditionFailure("qubFolder cannot be null."));
                });

                runner.test("with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with unpublished dependency with invalid folder characters", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b?", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("a", "b?", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with unpublished dependency with no project.json file", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectVersionFolder("a", "b", "1").await().create().await();

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependency with no dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependency with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("a", "b", "1"),
                            new ProjectSignature("c", "d", "2")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1"),
                            new ProjectSignature("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            new ProjectSignature("x", "y", "z"),
                            new ProjectSignature("a", "b", "1"),
                            new ProjectSignature("c", "d", "2")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });
            });

            runner.testGroup("getTransitiveDependencyPaths(QubFolder)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava();
                    test.assertThrows(() -> projectJSONJava.getTransitiveDependencyPaths(null),
                        new PreConditionFailure("qubFolder cannot be null."));
                });

                runner.test("with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with unpublished dependency with invalid folder characters", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b?", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b?", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with unpublished dependency with no project.json file", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectVersionFolder("a", "b", "1").await().create().await();

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with no dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create())
                            .set(new ProjectSignature("c", "d", "2"), Iterable.create(
                                new ProjectSignature("a", "b", "1"))),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1"),
                            new ProjectSignature("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create())
                            .set(new ProjectSignature("c", "d", "2"), Iterable.create(
                                new ProjectSignature("a", "b", "1")))
                            .set(new ProjectSignature("x", "y", "z"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with dependencies that reference the same published dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1"),
                            new ProjectSignature("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());
                    qubFolder.getProjectJSONFile("x", "y", "z").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create(
                                    new ProjectSignature("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create())
                            .set(new ProjectSignature("c", "d", "2"), Iterable.create(
                                new ProjectSignature("a", "b", "1")))
                            .set(new ProjectSignature("x", "y", "z"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with empty dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = new ProjectJSONJava()
                        .setDependencies(Iterable.create(
                            new ProjectSignature("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = new InMemoryFileSystem(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.create(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(new ProjectJSON()
                            .setJava(new ProjectJSONJava()
                                .setDependencies(Iterable.create()))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(new ProjectSignature("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });
            });

            runner.testGroup("equals(Object)", () ->
            {
                final Action3<ProjectJSONJava,Object,Boolean> equalsTest = (ProjectJSONJava projectJSONJava, Object rhs, Boolean expected) ->
                {
                    runner.test("with " + projectJSONJava + " and " + rhs, (Test test) ->
                    {
                        test.assertEqual(expected, projectJSONJava.equals(rhs));
                    });
                };

                equalsTest.run(
                    new ProjectJSONJava(),
                    null,
                    false);
                equalsTest.run(
                    new ProjectJSONJava(),
                    "hello",
                    false);
                equalsTest.run(
                    new ProjectJSONJava(),
                    new ProjectJSONJava(),
                    true);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMainClass("a"),
                    new ProjectJSONJava()
                        .setMainClass("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setShortcutName("a"),
                    new ProjectJSONJava()
                        .setShortcutName("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setVersion("a"),
                    new ProjectJSONJava()
                        .setVersion("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setOutputFolder("a"),
                    new ProjectJSONJava()
                        .setOutputFolder("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMaximumErrors(1),
                    new ProjectJSONJava()
                        .setMaximumErrors(2),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMaximumWarnings(1),
                    new ProjectJSONJava()
                        .setMaximumWarnings(2),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setSourceFilePatterns(Iterable.create(PathPattern.parse("a"))),
                    new ProjectJSONJava()
                        .setSourceFilePatterns(Iterable.create(PathPattern.parse("b"))),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))),
                    new ProjectJSONJava()
                        .setDependencies(Iterable.create(new ProjectSignature("d", "e", "f"))),
                    false);
            });

            runner.testGroup("equals(ProjectJSONJava)", () ->
            {
                final Action3<ProjectJSONJava,ProjectJSONJava,Boolean> equalsTest = (ProjectJSONJava projectJSONJava, ProjectJSONJava rhs, Boolean expected) ->
                {
                    runner.test("with " + projectJSONJava + " and " + rhs, (Test test) ->
                    {
                        test.assertEqual(expected, projectJSONJava.equals(rhs));
                    });
                };

                equalsTest.run(
                    new ProjectJSONJava(),
                    null,
                    false);
                equalsTest.run(
                    new ProjectJSONJava(),
                    new ProjectJSONJava(),
                    true);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMainClass("a"),
                    new ProjectJSONJava()
                        .setMainClass("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setShortcutName("a"),
                    new ProjectJSONJava()
                        .setShortcutName("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setVersion("a"),
                    new ProjectJSONJava()
                        .setVersion("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setOutputFolder("a"),
                    new ProjectJSONJava()
                        .setOutputFolder("b"),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMaximumErrors(1),
                    new ProjectJSONJava()
                        .setMaximumErrors(2),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setMaximumWarnings(1),
                    new ProjectJSONJava()
                        .setMaximumWarnings(2),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setSourceFilePatterns(Iterable.create(PathPattern.parse("a"))),
                    new ProjectJSONJava()
                        .setSourceFilePatterns(Iterable.create(PathPattern.parse("b"))),
                    false);
                equalsTest.run(
                    new ProjectJSONJava()
                        .setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))),
                    new ProjectJSONJava()
                        .setDependencies(Iterable.create(new ProjectSignature("d", "e", "f"))),
                    false);
            });

            runner.testGroup("toString()", () ->
            {
                final Action2<ProjectJSONJava,String> toStringTest = (ProjectJSONJava projectJSONJava, String expected) ->
                {
                    runner.test("with " + projectJSONJava, (Test test) ->
                    {
                        test.assertEqual(expected, projectJSONJava.toString());
                    });
                };

                toStringTest.run(new ProjectJSONJava(), "{}");
                toStringTest.run(new ProjectJSONJava().setMainClass("a"), "{\"mainClass\":\"a\"}");
                toStringTest.run(new ProjectJSONJava().setShortcutName("b"), "{\"shortcutName\":\"b\"}");
                toStringTest.run(new ProjectJSONJava().setVersion("c"), "{\"version\":\"c\"}");
                toStringTest.run(new ProjectJSONJava().setMaximumErrors(20), "{\"maximumErrors\":20}");
                toStringTest.run(new ProjectJSONJava().setMaximumWarnings(30), "{\"maximumWarnings\":30}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create()), "{}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))), "{\"sourceFiles\":[\"*.java\"]}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create()), "{}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))), "{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}");
            });

            runner.testGroup("toString(JSONFormat)", () ->
            {
                final Action3<ProjectJSONJava,JSONFormat,String> toStringTest = (ProjectJSONJava projectJSONJava, JSONFormat format, String expected) ->
                {
                    runner.test("with " + projectJSONJava, (Test test) ->
                    {
                        test.assertEqual(expected, projectJSONJava.toString(format));
                    });
                };

                toStringTest.run(new ProjectJSONJava(), JSONFormat.consise, "{}");
                toStringTest.run(new ProjectJSONJava().setMainClass("a"), JSONFormat.consise, "{\"mainClass\":\"a\"}");
                toStringTest.run(new ProjectJSONJava().setShortcutName("b"), JSONFormat.consise, "{\"shortcutName\":\"b\"}");
                toStringTest.run(new ProjectJSONJava().setVersion("c"), JSONFormat.consise, "{\"version\":\"c\"}");
                toStringTest.run(new ProjectJSONJava().setMaximumErrors(20), JSONFormat.consise, "{\"maximumErrors\":20}");
                toStringTest.run(new ProjectJSONJava().setMaximumWarnings(30), JSONFormat.consise, "{\"maximumWarnings\":30}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create()), JSONFormat.consise, "{}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))), JSONFormat.consise, "{\"sourceFiles\":[\"*.java\"]}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create()), JSONFormat.consise, "{}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))), JSONFormat.consise, "{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}");

                toStringTest.run(new ProjectJSONJava(), JSONFormat.pretty, "{}");
                toStringTest.run(new ProjectJSONJava().setMainClass("a"), JSONFormat.pretty, "{\n  \"mainClass\": \"a\"\n}");
                toStringTest.run(new ProjectJSONJava().setShortcutName("b"), JSONFormat.pretty, "{\n  \"shortcutName\": \"b\"\n}");
                toStringTest.run(new ProjectJSONJava().setVersion("c"), JSONFormat.pretty, "{\n  \"version\": \"c\"\n}");
                toStringTest.run(new ProjectJSONJava().setMaximumErrors(20), JSONFormat.pretty, "{\n  \"maximumErrors\": 20\n}");
                toStringTest.run(new ProjectJSONJava().setMaximumWarnings(30), JSONFormat.pretty, "{\n  \"maximumWarnings\": 30\n}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create()), JSONFormat.pretty, "{}");
                toStringTest.run(new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))), JSONFormat.pretty, "{\n  \"sourceFiles\": [\n    \"*.java\"\n  ]\n}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create()), JSONFormat.pretty, "{}");
                toStringTest.run(new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))), JSONFormat.pretty, "{\n  \"dependencies\": [\n    {\n      \"publisher\": \"a\",\n      \"project\": \"b\",\n      \"version\": \"c\"\n    }\n  ]\n}");
            });

            runner.testGroup("parse(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSONJava.parse(null),
                        new PreConditionFailure("javaObject cannot be null."));
                });

                final Action2<String,ProjectJSONJava> parseTest = (String jsonString, ProjectJSONJava expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(jsonString), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSONJava.parse(JSON.parseObject(jsonString).await()).await());
                    });
                };

                parseTest.run("{}", new ProjectJSONJava());
                parseTest.run("{\"mainClass\":\"a\"}", new ProjectJSONJava().setMainClass("a"));
                parseTest.run("{\"mainClass\":false}", new ProjectJSONJava());
                parseTest.run("{\"shortcutName\":\"b\"}", new ProjectJSONJava().setShortcutName("b"));
                parseTest.run("{\"shortcutName\":50}", new ProjectJSONJava());
                parseTest.run("{\"version\":\"c\"}", new ProjectJSONJava().setVersion("c"));
                parseTest.run("{\"version\":200}", new ProjectJSONJava().setVersion("200"));
                parseTest.run("{\"version\":200.1}", new ProjectJSONJava().setVersion("200.1"));
                parseTest.run("{\"version\":null}", new ProjectJSONJava());
                parseTest.run("{\"maximumErrors\":20}", new ProjectJSONJava().setMaximumErrors(20));
                parseTest.run("{\"maximumErrors\":-1}", new ProjectJSONJava().setMaximumErrors(-1));
                parseTest.run("{\"maximumErrors\":\"hello\"}", new ProjectJSONJava());
                parseTest.run("{\"maximumWarnings\":30}", new ProjectJSONJava().setMaximumWarnings(30));
                parseTest.run("{\"maximumWarnings\":-2}", new ProjectJSONJava().setMaximumWarnings(-2));
                parseTest.run("{\"maximumWarnings\":null}", new ProjectJSONJava());
                parseTest.run("{\"sourceFiles\":[\"*.java\"]}", new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))));
                parseTest.run("{\"sourceFiles\":[\"\"]}", new ProjectJSONJava().setSourceFilePatterns(Iterable.create()));
                parseTest.run("{\"sourceFiles\":[null]}", new ProjectJSONJava().setSourceFilePatterns(Iterable.create()));
                parseTest.run("{\"sourceFiles\":[\"*.java\",{}]}", new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))));
                parseTest.run("{\"sourceFiles\":\"*.java\"}", new ProjectJSONJava().setSourceFilePatterns(Iterable.create(PathPattern.parse("*.java"))));
                parseTest.run("{\"sourceFiles\":\"\"}", new ProjectJSONJava());
                parseTest.run("{\"sourceFiles\":null}", new ProjectJSONJava());
                parseTest.run("{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}", new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))));
                parseTest.run("{\"dependencies\":[\"a/b@c\"]}", new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"))));
                parseTest.run("{\"dependencies\":[\"a/b@c\",{\"publisher\":\"d\",\"project\":\"e\",\"version\":\"f\"}]}", new ProjectJSONJava().setDependencies(Iterable.create(new ProjectSignature("a", "b", "c"), new ProjectSignature("d", "e", "f"))));
                parseTest.run("{\"dependencies\":[500]}", new ProjectJSONJava().setDependencies(Iterable.create()));
                parseTest.run("{\"dependencies\":false}", new ProjectJSONJava());
            });
        });
    }
}
