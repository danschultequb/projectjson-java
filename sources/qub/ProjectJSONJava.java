package qub;

public class ProjectJSONJava
{
    public final static String mainClassPropertyName = "mainClass";
    public final static String shortcutNamePropertyName = "shortcutName";
    public final static String versionPropertyName = "version";
    public final static String outputFolderPropertyName = "outputFolder";
    public final static String sourceFilesPropertyName = "sourceFiles";
    public final static String maximumErrorsPropertyName = "maximumErrors";
    public final static String maximumWarningsPropertyName = "maximumWarnings";
    public final static String dependenciesPropertyName = "dependencies";

    public final static String projectSignaturePublisherPropertyName = "publisher";
    public final static String projectSignatureProjectPropertyName = "project";
    public final static String projectSignatureVersionPropertyName = "version";

    private final JSONObject jsonObject;

    private ProjectJSONJava(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "jsonObject");

        this.jsonObject = jsonObject;
    }

    /**
     * Create a ProjectJSONJava object from the provided JSON object.
     * @param jsonObject The JSON object to wrap.
     * @return The ProjectJSONJava object that wraps the provided JSON object.
     */
    public static ProjectJSONJava create(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "jsonObject");

        return new ProjectJSONJava(jsonObject);
    }

    /**
     * Create a ProjectJSONJava object around an empty JSON object.
     * @return The ProjectJSONJava object that wraps an empty JSON object.
     */
    public static ProjectJSONJava create()
    {
        return ProjectJSONJava.create(JSONObject.create());
    }

    private String getString(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        return this.jsonObject.getString(propertyName)
            .catchError()
            .await();
    }

    private ProjectJSONJava setString(String propertyName, String propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");
        PreCondition.assertNotNullAndNotEmpty(propertyValue, "propertyValue");

        this.jsonObject.setString(propertyName, propertyValue);
        return this;
    }

    private Integer getInteger(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        final Double number = this.jsonObject.getNumber(propertyName)
            .catchError()
            .await();
        return number == null ? null : number.intValue();
    }

    private ProjectJSONJava setInteger(String propertyName, int propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        this.jsonObject.setNumber(propertyName, propertyValue);
        return this;
    }

    /**
     * Get the main class.
     * @return The main class.
     */
    public String getMainClass()
    {
        return this.getString(ProjectJSONJava.mainClassPropertyName);
    }

    /**
     * Set the main class.
     * @param mainClass The main class.
     */
    public ProjectJSONJava setMainClass(String mainClass)
    {
        PreCondition.assertNotNullAndNotEmpty(mainClass, "mainClass");

        return this.setString(ProjectJSONJava.mainClassPropertyName, mainClass);
    }

    /**
     * Get the shortcut name.
     * @return The shortcut name.
     */
    public String getShortcutName()
    {
        return this.getString(ProjectJSONJava.shortcutNamePropertyName);
    }

    /**
     * Set the shortcut name.
     * @param shortcutName The shortcut name.
     */
    public ProjectJSONJava setShortcutName(String shortcutName)
    {
        PreCondition.assertNotNullAndNotEmpty(shortcutName, "shortcutName");

        return this.setString(ProjectJSONJava.shortcutNamePropertyName, shortcutName);
    }

    /**
     * Get the Java version to use when building source files.
     * @return The Java version to use when building source files.
     */
    public String getVersion()
    {
        return this.getString(ProjectJSONJava.versionPropertyName);
    }

    /**
     * Set the Java version to use when building source files.
     * @param version The Java version to use when building source files.
     */
    public ProjectJSONJava setVersion(String version)
    {
        PreCondition.assertNotNullAndNotEmpty(version, "version");

        return this.setString(ProjectJSONJava.versionPropertyName, version);
    }

    /**
     * Get the name of the outputFolder.
     * @return The name of the outputFolder.
     */
    public String getOutputFolder()
    {
        return this.getString(ProjectJSONJava.outputFolderPropertyName);
    }

    /**
     * Set the name of the outputFolder.
     * @param outputFolder The name of the outputFolder.
     */
    public ProjectJSONJava setOutputFolder(String outputFolder)
    {
        PreCondition.assertNotNullAndNotEmpty(outputFolder, "outputFolder");

        return this.setString(ProjectJSONJava.outputFolderPropertyName, outputFolder);
    }

    /**
     * Set the maximum number of errors that the compiler should report before halting compilation.
     * If nothing is specified (maximumErrors is null), then the default (100) will be used.
     * @param maximumErrors The maximum number of errors that the compiler should report before
     *                      halting compilation.
     * @return This object for method chaining.
     */
    public ProjectJSONJava setMaximumErrors(int maximumErrors)
    {
        return this.setInteger(ProjectJSONJava.maximumErrorsPropertyName, maximumErrors);
    }

    /**
     * Get the maximum number of errors that the compiler should report before halting compilation.
     * If nothing is specified (maximumErrors is null), then the default (100) will be used.
     * @return The maximum number of errors that the compiler should report before halting
     * compilation.
     */
    public Integer getMaximumErrors()
    {
        return this.getInteger(ProjectJSONJava.maximumErrorsPropertyName);
    }

    /**
     * Set the maximum number of warnings that the compiler should report. If nothing is specified
     * (maximumWarnings is null), then the default (100) will be used.
     * @param maximumWarnings The maximum number of warnings that the compiler should report.
     * @return This object for method chaining.
     */
    public ProjectJSONJava setMaximumWarnings(int maximumWarnings)
    {
        return this.setInteger(ProjectJSONJava.maximumWarningsPropertyName, maximumWarnings);
    }

    /**
     * Get the maximum number of warnings that the compiler should report. If nothing is specified
     * (maximumWarnings is null), then the default (100) will be used.
     * @return The maximum number of warnings that the compiler should report.
     */
    public Integer getMaximumWarnings()
    {
        return this.getInteger(ProjectJSONJava.maximumWarningsPropertyName);
    }

    public Iterable<PathPattern> getSourceFiles()
    {
        final List<PathPattern> result = List.create();

        this.jsonObject.getString(ProjectJSONJava.sourceFilesPropertyName)
                .then((String sourceFilesPattern) ->
                {
                    if (!Strings.isNullOrEmpty(sourceFilesPattern))
                    {
                        result.add(PathPattern.parse(sourceFilesPattern));
                    }
                })
                .catchError(WrongTypeException.class, () ->
                {
                    this.jsonObject.getArray(ProjectJSONJava.sourceFilesPropertyName)
                        .then((JSONArray sourceFilesArray) ->
                        {
                            result.addAll(sourceFilesArray
                                .instanceOf(JSONString.class)
                                .map(JSONString::getValue)
                                .where(value -> !Strings.isNullOrEmpty(value))
                                .map(PathPattern::parse));
                        })
                        .await();
                })
                .catchError()
                .await();

        return result;
    }

    public ProjectJSONJava setSourceFiles(PathPattern sourceFilePattern)
    {
        PreCondition.assertNotNull(sourceFilePattern, "sourceFilePattern");

        this.jsonObject.setString(ProjectJSONJava.sourceFilesPropertyName, sourceFilePattern.toString());
        return this;
    }

    public ProjectJSONJava setSourceFiles(Iterable<PathPattern> sourceFiles)
    {
        PreCondition.assertNotNull(sourceFiles, "sourceFiles");

        this.jsonObject.setArray(ProjectJSONJava.sourceFilesPropertyName, sourceFiles.map(PathPattern::toString).map(JSONString::get));
        return this;
    }

    /**
     * Get the dependencies for this project.
     * @return The dependencies for this project.
     */
    public Iterable<ProjectSignature> getDependencies()
    {
        Iterable<ProjectSignature> result;

        final JSONArray dependenciesArray = this.jsonObject.getArray(ProjectJSONJava.dependenciesPropertyName)
            .catchError()
            .await();
        if (dependenciesArray == null)
        {
            result = Iterable.create();
        }
        else
        {
            result = dependenciesArray.map((JSONSegment dependencyElement) ->
                {
                    ProjectSignature dependency = null;
                    if (dependencyElement instanceof JSONString)
                    {
                        dependency = ProjectSignature.parse(((JSONString)dependencyElement).getValue())
                            .catchError()
                            .await();
                    }
                    else if (dependencyElement instanceof JSONObject)
                    {
                        dependency = ProjectJSONJava.parseProjectSignature((JSONObject)dependencyElement)
                            .catchError()
                            .await();
                    }
                    return dependency;
                })
                .where(java.util.Objects::nonNull);
        }
        return result;
    }

    /**
     * Get the transitive dependencies for this project (this project's dependencies, plus their
     * dependencies, etc.).
     * @param qubFolder The Qub folder where project's are published.
     * @return The transitive dependencies for this project.
     */
    public Iterable<ProjectSignature> getTransitiveDependencies(QubFolder qubFolder)
    {
        PreCondition.assertNotNull(qubFolder, "qubFolder");

        final Iterable<ProjectSignature> dependencies = this.getDependencies();
        return Iterable.traverse(dependencies, (ProjectSignature dependency) ->
        {
            Iterable<ProjectSignature> dependencyDependencies = null;
            final String publisher = dependency.getPublisher();
            final String project = dependency.getProject();
            final String version = dependency.getVersion();
            final File dependencyProjectJsonFile = qubFolder.getProjectJSONFile(publisher, project, version)
                .catchError()
                .await();
            if (dependencyProjectJsonFile != null)
            {
                final ProjectJSON dependencyProjectJson = ProjectJSON.parse(dependencyProjectJsonFile)
                    .catchError()
                    .await();
                if (dependencyProjectJson != null)
                {
                    final ProjectJSONJava dependencyProjectJsonJava = dependencyProjectJson.getJava();
                    if (dependencyProjectJsonJava != null)
                    {
                        dependencyDependencies = dependencyProjectJsonJava.getDependencies();
                    }
                }
            }
            if (dependencyDependencies == null)
            {
                dependencyDependencies = Iterable.create();
            }
            return dependencyDependencies;
        });
    }

    /**
     * Get the transitive dependencies for this project (this project's dependencies, plus their
     * dependencies, etc.) with their dependency paths.
     * @param qubFolder The Qub folder where project's are published.
     * @return The transitive dependencies for this project with their dependency paths.
     */
    public Map<ProjectSignature,Iterable<ProjectSignature>> getTransitiveDependencyPaths(QubFolder qubFolder)
    {
        PreCondition.assertNotNull(qubFolder, "qubFolder");

        final MutableMap<ProjectSignature,Iterable<ProjectSignature>> result = Map.create();
        final Iterable<ProjectSignature> dependencies = this.getDependencies();
        ProjectJSONJava.collectTransitiveDependencyPaths(qubFolder, dependencies, result, List.create());

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    private static void collectTransitiveDependencyPaths(QubFolder qubFolder, Iterable<ProjectSignature> dependencies, MutableMap<ProjectSignature,Iterable<ProjectSignature>> resultMap, List<ProjectSignature> currentPath)
    {
        PreCondition.assertNotNull(qubFolder, "qubFolder");
        PreCondition.assertNotNullAndNotEmpty(dependencies, "dependencies");
        PreCondition.assertNotNull(resultMap, "resultMap");
        PreCondition.assertNotNull(currentPath, "currentPath");

        for (final ProjectSignature dependency : dependencies)
        {
            if (!resultMap.containsKey(dependency))
            {
                resultMap.set(dependency, currentPath.toArray());

                final String publisher = dependency.getPublisher();
                final String project = dependency.getProject();
                final String version = dependency.getVersion();
                final File dependencyProjectJsonFile = qubFolder.getProjectJSONFile(publisher, project, version)
                    .catchError()
                    .await();
                if (dependencyProjectJsonFile != null)
                {
                    final ProjectJSON dependencyProjectJson = ProjectJSON.parse(dependencyProjectJsonFile)
                        .catchError()
                        .await();
                    if (dependencyProjectJson != null)
                    {
                        final ProjectJSONJava dependencyProjectJsonJava = dependencyProjectJson.getJava();
                        if (dependencyProjectJsonJava != null)
                        {
                            final Iterable<ProjectSignature> nextDependencies = dependencyProjectJsonJava.getDependencies();
                            if (!Iterable.isNullOrEmpty(nextDependencies))
                            {
                                currentPath.add(dependency);
                                ProjectJSONJava.collectTransitiveDependencyPaths(qubFolder, nextDependencies, resultMap, currentPath);
                                currentPath.removeLast();
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Set the dependencies for this project.
     * @param dependencies The dependencies for this project.
     */
    public ProjectJSONJava setDependencies(Iterable<ProjectSignature> dependencies)
    {
        PreCondition.assertNotNull(dependencies, "dependencies");

        this.jsonObject.setArray(ProjectJSONJava.dependenciesPropertyName, dependencies.map(ProjectJSONJava::projectSignatureToJson));
        return this;
    }

    @Override
    public boolean equals(Object rhs)
    {
        return rhs instanceof ProjectJSONJava && this.equals((ProjectJSONJava)rhs);
    }

    public boolean equals(ProjectJSONJava rhs)
    {
        return rhs != null &&
            this.jsonObject.equals(rhs.jsonObject);
    }

    @Override
    public String toString()
    {
        return this.toString(JSONFormat.consise);
    }

    public String toString(JSONFormat format)
    {
        PreCondition.assertNotNull(format, "format");

        return this.toJson().toString(format);
    }

    public JSONObject toJson()
    {
        return this.jsonObject;
    }

    public static JSONObject projectSignatureToJson(ProjectSignature projectSignature)
    {
        PreCondition.assertNotNull(projectSignature, "projectSignature");

        return JSONObject.create()
            .setString(ProjectJSONJava.projectSignaturePublisherPropertyName, projectSignature.getPublisher())
            .setString(ProjectJSONJava.projectSignatureProjectPropertyName, projectSignature.getProject())
            .setString(ProjectJSONJava.projectSignatureVersionPropertyName, projectSignature.getVersion());
    }

    public static Result<ProjectSignature> parseProjectSignature(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "jsonObject");

        return Result.create(() ->
        {
            final String publisher = jsonObject.getString(ProjectJSONJava.projectSignaturePublisherPropertyName).await();
            final String project = jsonObject.getString(ProjectJSONJava.projectSignatureProjectPropertyName).await();
            final String version = jsonObject.getString(ProjectJSONJava.projectSignatureVersionPropertyName).await();
            return new ProjectSignature(publisher, project, version);
        });
    }
}
