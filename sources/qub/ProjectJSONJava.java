package qub;

public class ProjectJSONJava extends JSONObjectWrapperBase
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

    private ProjectJSONJava(JSONObject json)
    {
        super(json);
    }

    /**
     * Create a ProjectJSONJava object from the provided JSON object.
     * @param jsonObject The JSON object to wrap.
     * @return The ProjectJSONJava object that wraps the provided JSON object.
     */
    public static ProjectJSONJava create(JSONObject jsonObject)
    {
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

        return this.json.getString(propertyName)
            .catchError()
            .await();
    }

    private ProjectJSONJava setString(String propertyName, String propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");
        PreCondition.assertNotNullAndNotEmpty(propertyValue, "propertyValue");

        this.json.setString(propertyName, propertyValue);
        return this;
    }

    private Integer getInteger(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        return this.json.getInteger(propertyName).catchError().await();
    }

    private ProjectJSONJava setInteger(String propertyName, int propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        this.json.setNumber(propertyName, propertyValue);
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

        this.json.getString(ProjectJSONJava.sourceFilesPropertyName)
                .then((String sourceFilesPattern) ->
                {
                    if (!Strings.isNullOrEmpty(sourceFilesPattern))
                    {
                        result.add(PathPattern.parse(sourceFilesPattern));
                    }
                })
                .catchError(WrongTypeException.class, () ->
                {
                    this.json.getArray(ProjectJSONJava.sourceFilesPropertyName)
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

    public ProjectJSONJava setSourceFiles(PathPattern... sourceFilePattern)
    {
        PreCondition.assertNotNull(sourceFilePattern, "sourceFilePattern");

        return this.setSourceFiles(Iterable.create(sourceFilePattern));
    }

    public ProjectJSONJava setSourceFiles(Iterable<PathPattern> sourceFiles)
    {
        PreCondition.assertNotNull(sourceFiles, "sourceFiles");

        if (sourceFiles.getCount() == 1)
        {
            this.json.setString(ProjectJSONJava.sourceFilesPropertyName, sourceFiles.first().toString());
        }
        else
        {
            this.json.setArray(ProjectJSONJava.sourceFilesPropertyName, sourceFiles.map(PathPattern::toString).map(JSONString::get));
        }

        return this;
    }

    /**
     * Get the dependencies for this project.
     * @return The dependencies for this project.
     */
    public Iterable<ProjectSignature> getDependencies()
    {
        Iterable<ProjectSignature> result;

        final JSONArray dependenciesArray = this.json.getArray(ProjectJSONJava.dependenciesPropertyName)
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
     * Set the dependencies for this project.
     * @param dependencies The dependencies for this project.
     */
    public ProjectJSONJava setDependencies(Iterable<ProjectSignature> dependencies)
    {
        PreCondition.assertNotNull(dependencies, "dependencies");

        this.json.setArray(ProjectJSONJava.dependenciesPropertyName, dependencies.map(ProjectJSONJava::projectSignatureToJson));
        return this;
    }

    public static JSONObject projectSignatureToJson(ProjectSignature projectSignature)
    {
        PreCondition.assertNotNull(projectSignature, "projectSignature");

        return JSONObject.create()
            .setString(ProjectJSONJava.projectSignaturePublisherPropertyName, projectSignature.getPublisher())
            .setString(ProjectJSONJava.projectSignatureProjectPropertyName, projectSignature.getProject())
            .setString(ProjectJSONJava.projectSignatureVersionPropertyName, projectSignature.getVersion().toString());
    }

    public static Result<ProjectSignature> parseProjectSignature(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "jsonObject");

        return Result.create(() ->
        {
            final String publisher = jsonObject.getString(ProjectJSONJava.projectSignaturePublisherPropertyName).await();
            final String project = jsonObject.getString(ProjectJSONJava.projectSignatureProjectPropertyName).await();
            final String version = jsonObject.getString(ProjectJSONJava.projectSignatureVersionPropertyName).await();
            return ProjectSignature.create(publisher, project, version);
        });
    }
}
