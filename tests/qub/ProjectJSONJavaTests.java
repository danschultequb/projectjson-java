package qub;

public interface ProjectJSONJavaTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(ProjectJSONJava.class, () ->
        {
            runner.test("constructor()", (Test test) ->
            {
                final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                test.assertNull(projectJSONJava.getMainClass());
                test.assertNull(projectJSONJava.getShortcutName());
                test.assertNull(projectJSONJava.getVersion());
                test.assertNull(projectJSONJava.getOutputFolder());
                test.assertNull(projectJSONJava.getMaximumErrors());
                test.assertNull(projectJSONJava.getMaximumWarnings());
                test.assertEqual(Iterable.create(), projectJSONJava.getSourceFiles());
                test.assertEqual(Iterable.create(), projectJSONJava.getDependencies());
            });

            runner.testGroup("setMainClass(String)", () ->
            {
                final Action2<String,Throwable> setMainClassErrorTest = (String mainClass, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(mainClass), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setMainClass(mainClass), expected);
                        test.assertNull(projectJSONJava.getMainClass());
                    });
                };

                setMainClassErrorTest.run(null, new PreConditionFailure("mainClass cannot be null."));
                setMainClassErrorTest.run("", new PreConditionFailure("mainClass cannot be empty."));

                final Action1<String> setMainClassTest = (String mainClass) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(mainClass), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMainClass(mainClass));
                        test.assertEqual(mainClass, projectJSONJava.getMainClass());
                    });
                };

                setMainClassTest.run("hello");
            });

            runner.testGroup("setShortcutName(String)", () ->
            {
                final Action2<String,Throwable> setShortcutNameErrorTest = (String shortcutName, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(shortcutName), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setShortcutName(shortcutName), expected);
                        test.assertNull(projectJSONJava.getShortcutName());
                    });
                };

                setShortcutNameErrorTest.run(null, new PreConditionFailure("shortcutName cannot be null."));
                setShortcutNameErrorTest.run("", new PreConditionFailure("shortcutName cannot be empty."));

                final Action1<String> setShortcutNameTest = (String shortcutName) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(shortcutName), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setShortcutName(shortcutName));
                        test.assertEqual(shortcutName, projectJSONJava.getShortcutName());
                    });
                };

                setShortcutNameTest.run("hello");
            });

            runner.testGroup("setVersion(String)", () ->
            {
                final Action2<String,Throwable> setVersionErrorTest = (String version, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setVersion(version), expected);
                        test.assertNull(projectJSONJava.getVersion());
                    });
                };

                setVersionErrorTest.run(null, new PreConditionFailure("version cannot be null."));
                setVersionErrorTest.run("", new PreConditionFailure("version cannot be empty."));

                final Action1<String> setVersionTest = (String version) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(version), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setVersion(version));
                        test.assertEqual(version, projectJSONJava.getVersion());
                    });
                };

                setVersionTest.run("hello");
            });

            runner.testGroup("setOutputFolder(String)", () ->
            {
                final Action2<String,Throwable> setOutputFolderErrorTest = (String outputFolder, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(outputFolder), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setOutputFolder(outputFolder), expected);
                        test.assertNull(projectJSONJava.getOutputFolder());
                    });
                };

                setOutputFolderErrorTest.run(null, new PreConditionFailure("outputFolder cannot be null."));
                setOutputFolderErrorTest.run("", new PreConditionFailure("outputFolder cannot be empty."));

                final Action1<String> setOutputFolderTest = (String outputFolder) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(outputFolder), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setOutputFolder(outputFolder));
                        test.assertEqual(outputFolder, projectJSONJava.getOutputFolder());
                    });
                };

                setOutputFolderTest.run("hello");
            });

            runner.testGroup("setMaximumErrors(Integer)", () ->
            {
                final Action1<Integer> setMaximumErrorsTest = (Integer maximumErrors) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(maximumErrors), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMaximumErrors(maximumErrors));
                        test.assertEqual(maximumErrors, projectJSONJava.getMaximumErrors());
                    });
                };

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
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setMaximumWarnings(maximumWarnings));
                        test.assertEqual(maximumWarnings, projectJSONJava.getMaximumWarnings());
                    });
                };

                setMaximumWarningsTest.run(0);
                setMaximumWarningsTest.run(-1);
                setMaximumWarningsTest.run(1);
            });

            runner.testGroup("getSourceFiles()", () ->
            {
                final Action2<ProjectJSONJava,Iterable<PathPattern>> getSourceFilesTest = (ProjectJSONJava projectJsonJava, Iterable<PathPattern> expected) ->
                {
                    runner.test("with " + projectJsonJava, (Test test) ->
                    {
                        test.assertEqual(expected, projectJsonJava.getSourceFiles());
                    });
                };

                getSourceFilesTest.run(
                    ProjectJSONJava.create(),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setNull("sourceFiles")),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setNumber("sourceFiles", 5)),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setString("sourceFiles", "")),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setString("sourceFiles", "hello")),
                    Iterable.create(
                        PathPattern.parse("hello")));
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setObject("sourceFiles", JSONObject.create())),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create())),
                    Iterable.create());
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(
                            JSONString.get("apples")))),
                    Iterable.create(
                        PathPattern.parse("apples")));
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(
                            JSONString.get("apples"),
                            JSONString.get(""),
                            JSONString.get("bananas")))),
                    Iterable.create(
                        PathPattern.parse("apples"),
                        PathPattern.parse("bananas")));
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(
                            JSONString.get("apples"),
                            JSONNull.segment,
                            JSONString.get("bananas")))),
                    Iterable.create(
                        PathPattern.parse("apples"),
                        PathPattern.parse("bananas")));
                getSourceFilesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(
                            JSONBoolean.falseSegment))),
                    Iterable.create());
            });

            runner.testGroup("setSourceFiles(Iterable<PathPattern>)", () ->
            {
                final Action2<Iterable<PathPattern>,Throwable> setSourceFilesErrorTest = (Iterable<PathPattern> sourceFilePatterns, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(sourceFilePatterns), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setSourceFiles(sourceFilePatterns), expected);
                        test.assertEqual(Iterable.create(), projectJSONJava.getSourceFiles());
                    });
                };

                setSourceFilesErrorTest.run(null, new PreConditionFailure("sourceFiles cannot be null."));

                final Action1<Iterable<PathPattern>> setSourceFilesTest = (Iterable<PathPattern> sourceFilePatterns) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(sourceFilePatterns), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.<ProjectJSONJava>assertSame(projectJSONJava, projectJSONJava.setSourceFiles(sourceFilePatterns));
                        test.assertEqual(sourceFilePatterns, projectJSONJava.getSourceFiles());
                    });
                };

                setSourceFilesTest.run(Iterable.create());
                setSourceFilesTest.run(Iterable.create(PathPattern.parse("*.java")));
            });

            runner.testGroup("getDependencies()", () ->
            {
                final Action2<ProjectJSONJava,Iterable<ProjectSignature>> getDependenciesTest = (ProjectJSONJava projectJsonJava, Iterable<ProjectSignature> expected) ->
                {
                    runner.test("with " + projectJsonJava, (Test test) ->
                    {
                        test.assertEqual(expected, projectJsonJava.getDependencies());
                    });
                };

                getDependenciesTest.run(
                    ProjectJSONJava.create(),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setNull("dependencies")),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setNumber("dependencies", 5)),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setObject("dependencies", JSONObject.create())),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create())),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            ProjectJSONJava.projectSignatureToJson(ProjectSignature.create("a", "b", "1"))))),
                    Iterable.create(
                        ProjectSignature.create("a", "b", "1")));
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONString.get("a/b@1")))),
                    Iterable.create(
                        ProjectSignature.create("a", "b", "1")));
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONString.get("hello")))),
                    Iterable.create());
                getDependenciesTest.run(
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONBoolean.falseSegment))),
                    Iterable.create());
            });

            runner.testGroup("setDependencies(Iterable<ProjectSignature>)", () ->
            {
                final Action2<Iterable<ProjectSignature>,Throwable> setDependenciesErrorTest = (Iterable<ProjectSignature> dependencies, Throwable expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(dependencies), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        test.assertThrows(() -> projectJSONJava.setDependencies(dependencies), expected);
                        test.assertEqual(Iterable.create(), projectJSONJava.getDependencies());
                    });
                };

                setDependenciesErrorTest.run(null, new PreConditionFailure("dependencies cannot be null."));

                final Action1<Iterable<ProjectSignature>> setDependenciesTest = (Iterable<ProjectSignature> dependencies) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(dependencies), (Test test) ->
                    {
                        final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                        final ProjectJSONJava setDependenciesResult = projectJSONJava.setDependencies(dependencies);
                        test.assertSame(projectJSONJava, setDependenciesResult);
                        test.assertEqual(dependencies, projectJSONJava.getDependencies());
                    });
                };

                setDependenciesTest.run(Iterable.create());
                setDependenciesTest.run(Iterable.create(ProjectSignature.create("a", "b", "c")));
            });

            runner.testGroup("getTransitiveDependencies(QubFolder)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                    test.assertThrows(() -> projectJSONJava.getTransitiveDependencies(null),
                        new PreConditionFailure("qubFolder cannot be null."));
                });

                runner.test("with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with unpublished dependency with invalid folder characters", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b?", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("a", "b?", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with unpublished dependency with no project.json file", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectVersionFolder("a", "b", "1").await().create().await();

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependency with no dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("a", "b", "1")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependency with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("c", "d", "2")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("x", "y", "z"),
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("c", "d", "2")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });

                runner.test("with published dependencies under versions folder", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Iterable.create(
                            ProjectSignature.create("x", "y", "z"),
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("c", "d", "2")),
                        projectJSONJava.getTransitiveDependencies(qubFolder));
                });
            });

            runner.testGroup("getTransitiveDependencyPaths(QubFolder)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create();
                    test.assertThrows(() -> projectJSONJava.getTransitiveDependencyPaths(null),
                        new PreConditionFailure("qubFolder cannot be null."));
                });

                runner.test("with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with unpublished dependency with invalid folder characters", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b?", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b?", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with unpublished dependency with no project.json file", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectVersionFolder("a", "b", "1").await().create().await();

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with no dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with unpublished dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create())
                            .set(ProjectSignature.create("c", "d", "2"), Iterable.create(
                                ProjectSignature.create("a", "b", "1"))),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create())
                            .set(ProjectSignature.create("c", "d", "2"), Iterable.create(
                                ProjectSignature.create("a", "b", "1")))
                            .set(ProjectSignature.create("x", "y", "z"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with dependencies that reference the same published dependency", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1"),
                            ProjectSignature.create("x", "y", "z")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());
                    qubFolder.getProjectJSONFile("x", "y", "z").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create(
                                    ProjectSignature.create("c", "d", "2"))))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create())
                            .set(ProjectSignature.create("c", "d", "2"), Iterable.create(
                                ProjectSignature.create("a", "b", "1")))
                            .set(ProjectSignature.create("x", "y", "z"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with empty dependencies", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create()))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create()),
                        projectJSONJava.getTransitiveDependencyPaths(qubFolder));
                });

                runner.test("with published dependency with empty dependencies under versions folder", (Test test) ->
                {
                    final ProjectJSONJava projectJSONJava = ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "1")));

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create(test.getClock());
                    fileSystem.createRoot("/").await();
                    final QubFolder qubFolder = QubFolder.get(fileSystem.getFolder("/").await());
                    qubFolder.getProjectJSONFile("a", "b", "1").await()
                        .setContentsAsString(ProjectJSON.create()
                            .setJava(ProjectJSONJava.create()
                                .setDependencies(Iterable.create()))
                            .toString());

                    test.assertEqual(
                        Map.<ProjectSignature,Iterable<ProjectSignature>>create()
                            .set(ProjectSignature.create("a", "b", "1"), Iterable.create()),
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
                    ProjectJSONJava.create(),
                    null,
                    false);
                equalsTest.run(
                    ProjectJSONJava.create(),
                    "hello",
                    false);
                equalsTest.run(
                    ProjectJSONJava.create(),
                    ProjectJSONJava.create(),
                    true);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMainClass("a"),
                    ProjectJSONJava.create()
                        .setMainClass("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setShortcutName("a"),
                    ProjectJSONJava.create()
                        .setShortcutName("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setVersion("a"),
                    ProjectJSONJava.create()
                        .setVersion("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setOutputFolder("a"),
                    ProjectJSONJava.create()
                        .setOutputFolder("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMaximumErrors(1),
                    ProjectJSONJava.create()
                        .setMaximumErrors(2),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMaximumWarnings(1),
                    ProjectJSONJava.create()
                        .setMaximumWarnings(2),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(PathPattern.parse("a"))),
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(PathPattern.parse("b"))),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(ProjectSignature.create("a", "b", "c"))),
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(ProjectSignature.create("d", "e", "f"))),
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
                    ProjectJSONJava.create(),
                    null,
                    false);
                equalsTest.run(
                    ProjectJSONJava.create(),
                    ProjectJSONJava.create(),
                    true);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMainClass("a"),
                    ProjectJSONJava.create()
                        .setMainClass("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setShortcutName("a"),
                    ProjectJSONJava.create()
                        .setShortcutName("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setVersion("a"),
                    ProjectJSONJava.create()
                        .setVersion("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setOutputFolder("a"),
                    ProjectJSONJava.create()
                        .setOutputFolder("b"),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMaximumErrors(1),
                    ProjectJSONJava.create()
                        .setMaximumErrors(2),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setMaximumWarnings(1),
                    ProjectJSONJava.create()
                        .setMaximumWarnings(2),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(PathPattern.parse("a"))),
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(PathPattern.parse("b"))),
                    false);
                equalsTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(ProjectSignature.create("a", "b", "c"))),
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(ProjectSignature.create("d", "e", "f"))),
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

                toStringTest.run(
                    ProjectJSONJava.create(),
                    "{}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMainClass("a"),
                    "{\"mainClass\":\"a\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setShortcutName("b"),
                    "{\"shortcutName\":\"b\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setVersion("c"),
                    "{\"version\":\"c\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumErrors(20),
                    "{\"maximumErrors\":20}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumWarnings(30),
                    "{\"maximumWarnings\":30}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create()),
                    "{\"sourceFiles\":[]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(
                            PathPattern.parse("*.java"))),
                    "{\"sourceFiles\":[\"*.java\"]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create()),
                    "{\"dependencies\":[]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "c"))),
                    "{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}");
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

                toStringTest.run(
                    ProjectJSONJava.create(),
                    JSONFormat.consise,
                    "{}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMainClass("a"),
                    JSONFormat.consise,
                    "{\"mainClass\":\"a\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setShortcutName("b"),
                    JSONFormat.consise,
                    "{\"shortcutName\":\"b\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setVersion("c"),
                    JSONFormat.consise,
                    "{\"version\":\"c\"}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumErrors(20),
                    JSONFormat.consise,
                    "{\"maximumErrors\":20}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumWarnings(30),
                    JSONFormat.consise,
                    "{\"maximumWarnings\":30}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create()),
                    JSONFormat.consise,
                    "{\"sourceFiles\":[]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(
                            PathPattern.parse("*.java"))),
                    JSONFormat.consise,
                    "{\"sourceFiles\":[\"*.java\"]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create()),
                    JSONFormat.consise,
                    "{\"dependencies\":[]}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "c"))),
                    JSONFormat.consise,
                    "{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}");

                toStringTest.run(
                    ProjectJSONJava.create(),
                    JSONFormat.pretty,
                    "{}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMainClass("a"),
                    JSONFormat.pretty,
                    "{\n  \"mainClass\": \"a\"\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setShortcutName("b"),
                    JSONFormat.pretty,
                    "{\n  \"shortcutName\": \"b\"\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setVersion("c"),
                    JSONFormat.pretty,
                    "{\n  \"version\": \"c\"\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumErrors(20),
                    JSONFormat.pretty,
                    "{\n  \"maximumErrors\": 20\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setMaximumWarnings(30),
                    JSONFormat.pretty,
                    "{\n  \"maximumWarnings\": 30\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create()),
                    JSONFormat.pretty,
                    "{\n  \"sourceFiles\": []\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(
                            PathPattern.parse("*.java"))),
                    JSONFormat.pretty,
                    "{\n  \"sourceFiles\": [\n    \"*.java\"\n  ]\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create()),
                    JSONFormat.pretty,
                    "{\n  \"dependencies\": []\n}");
                toStringTest.run(
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "c"))),
                    JSONFormat.pretty,
                    "{\n  \"dependencies\": [\n    {\n      \"publisher\": \"a\",\n      \"project\": \"b\",\n      \"version\": \"c\"\n    }\n  ]\n}");
            });

            runner.testGroup("create(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSONJava.create(null),
                        new PreConditionFailure("jsonObject cannot be null."));
                });

                final Action2<String,ProjectJSONJava> parseTest = (String jsonString, ProjectJSONJava expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(jsonString), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSONJava.create(JSON.parseObject(jsonString).await()));
                    });
                };

                parseTest.run(
                    "{}",
                    ProjectJSONJava.create());
                parseTest.run(
                    "{\"mainClass\":\"a\"}",
                    ProjectJSONJava.create()
                        .setMainClass("a"));
                parseTest.run(
                    "{\"mainClass\":false}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setBoolean("mainClass", false)));
                parseTest.run(
                    "{\"shortcutName\":\"b\"}",
                    ProjectJSONJava.create()
                        .setShortcutName("b"));
                parseTest.run(
                    "{\"shortcutName\":50}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNumber("shortcutName", 50)));
                parseTest.run(
                    "{\"version\":\"c\"}",
                    ProjectJSONJava.create()
                        .setVersion("c"));
                parseTest.run(
                    "{\"version\":200}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNumber("version", 200)));
                parseTest.run(
                    "{\"version\":200.1}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNumber("version", 200.1)));
                parseTest.run(
                    "{\"version\":null}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNull("version")));
                parseTest.run(
                    "{\"maximumErrors\":20}",
                    ProjectJSONJava.create()
                        .setMaximumErrors(20));
                parseTest.run(
                    "{\"maximumErrors\":-1}",
                    ProjectJSONJava.create()
                        .setMaximumErrors(-1));
                parseTest.run(
                    "{\"maximumErrors\":\"hello\"}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setString("maximumErrors", "hello")));
                parseTest.run(
                    "{\"maximumWarnings\":30}",
                    ProjectJSONJava.create()
                        .setMaximumWarnings(30));
                parseTest.run(
                    "{\"maximumWarnings\":-2}",
                    ProjectJSONJava.create()
                        .setMaximumWarnings(-2));
                parseTest.run(
                    "{\"maximumWarnings\":null}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNull("maximumWarnings")));
                parseTest.run(
                    "{\"sourceFiles\":[\"*.java\"]}",
                    ProjectJSONJava.create()
                        .setSourceFiles(Iterable.create(PathPattern.parse("*.java"))));
                parseTest.run(
                    "{\"sourceFiles\":[\"\"]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(JSONString.get("")))));
                parseTest.run(
                    "{\"sourceFiles\":[null]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(JSONNull.segment))));
                parseTest.run(
                    "{\"sourceFiles\":[\"*.java\",{}]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("sourceFiles", Iterable.create(
                            JSONString.get("*.java"),
                            JSONObject.create()))));
                parseTest.run(
                    "{\"sourceFiles\":\"*.java\"}",
                    ProjectJSONJava.create().setSourceFiles(PathPattern.parse("*.java")));
                parseTest.run(
                    "{\"sourceFiles\":\"\"}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setString("sourceFiles", "")));
                parseTest.run(
                    "{\"sourceFiles\":null}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setNull("sourceFiles")));
                parseTest.run(
                    "{\"dependencies\":[{\"publisher\":\"a\",\"project\":\"b\",\"version\":\"c\"}]}",
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "c"))));
                parseTest.run(
                    "{\"dependencies\":[\"a/b@c\"]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONString.get("a/b@c")))));
                parseTest.run(
                    "{\"dependencies\":[\"a/b@c\",{\"publisher\":\"d\",\"project\":\"e\",\"version\":\"f\"}]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONString.get("a/b@c"),
                            JSONObject.create()
                                .setString("publisher", "d")
                                .setString("project", "e")
                                .setString("version", "f")))));
                parseTest.run(
                    "{\"dependencies\":[500]}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setArray("dependencies", Iterable.create(
                            JSONNumber.get(500)))));
                parseTest.run(
                    "{\"dependencies\":false}",
                    ProjectJSONJava.create(JSONObject.create()
                        .setBoolean("dependencies", false)));
            });
        });
    }
}
