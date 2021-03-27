package qub;

public interface ProjectJSONJavaTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(ProjectJSONJava.class, () ->
        {
            runner.test("create()", (Test test) ->
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

            runner.testGroup("create(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> ProjectJSONJava.create(null),
                        new PreConditionFailure("json cannot be null."));
                });

                final Action2<JSONObject,ProjectJSONJava> createTest = (JSONObject json, ProjectJSONJava expected) ->
                {
                    runner.test("with " + Strings.escapeAndQuote(json), (Test test) ->
                    {
                        test.assertEqual(expected, ProjectJSONJava.create(json));
                    });
                };

                createTest.run(
                    JSONObject.create(),
                    ProjectJSONJava.create());
                createTest.run(
                    JSONObject.create()
                        .setString("mainClass", "a"),
                    ProjectJSONJava.create()
                        .setMainClass("a"));
                createTest.run(
                    JSONObject.create()
                        .setString("shortcutName", "b"),
                    ProjectJSONJava.create()
                        .setShortcutName("b"));
                createTest.run(
                    JSONObject.create()
                        .setString("version", "c"),
                    ProjectJSONJava.create()
                        .setVersion("c"));
                createTest.run(
                    JSONObject.create()
                        .setNumber("maximumErrors", 20),
                    ProjectJSONJava.create()
                        .setMaximumErrors(20));
                createTest.run(
                    JSONObject.create()
                        .setNumber("maximumErrors", -1),
                    ProjectJSONJava.create()
                        .setMaximumErrors(-1));
                createTest.run(
                    JSONObject.create()
                        .setNumber("maximumWarnings", 30),
                    ProjectJSONJava.create()
                        .setMaximumWarnings(30));
                createTest.run(
                    JSONObject.create()
                        .setNumber("maximumWarnings", -2),
                    ProjectJSONJava.create()
                        .setMaximumWarnings(-2));
                createTest.run(
                    JSONObject.create()
                        .setArray("sourceFiles", JSONArray.create()),
                    ProjectJSONJava.create()
                        .setSourceFiles());
                createTest.run(
                    JSONObject.create()
                        .setString("sourceFiles", "*.java"),
                    ProjectJSONJava.create()
                        .setSourceFiles(PathPattern.parse("*.java")));
                createTest.run(
                    JSONObject.create()
                        .setArray("dependencies", JSONArray.create()
                            .add(JSONObject.create()
                                .setString("publisher", "a")
                                .setString("project", "b")
                                .setString("version", "c"))),
                    ProjectJSONJava.create()
                        .setDependencies(Iterable.create(
                            ProjectSignature.create("a", "b", "c"))));
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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

                    final InMemoryFileSystem fileSystem = InMemoryFileSystem.create();
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
        });
    }
}
