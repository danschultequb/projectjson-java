package qub;

import java.util.Objects;

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

    private String mainClass;
    private String shortcutName;
    private String version;
    private String outputFolder;
    private Integer maximumErrors;
    private Integer maximumWarnings;
    private Iterable<PathPattern> sourceFilePatterns;
    private Iterable<ProjectSignature> dependencies;

    /**
     * Get the main class.
     * @return The main class.
     */
    public String getMainClass()
    {
        return mainClass;
    }

    /**
     * Set the main class.
     * @param mainClass The main class.
     */
    public ProjectJSONJava setMainClass(String mainClass)
    {
        this.mainClass = mainClass;
        return this;
    }

    /**
     * Get the shortcut name.
     * @return The shortcut name.
     */
    public String getShortcutName()
    {
        return shortcutName;
    }

    /**
     * Set the shortcut name.
     * @param shortcutName The shortcut name.
     */
    public ProjectJSONJava setShortcutName(String shortcutName)
    {
        this.shortcutName = shortcutName;
        return this;
    }

    /**
     * Get the Java version to use when building source files.
     * @return The Java version to use when building source files.
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * Set the Java version to use when building source files.
     * @param version The Java version to use when building source files.
     */
    public ProjectJSONJava setVersion(String version)
    {
        this.version = version;
        return this;
    }

    /**
     * Get the name of the outputFolder.
     * @return The name of the outputFolder.
     */
    public String getOutputFolder()
    {
        return outputFolder;
    }

    /**
     * Set the name of the outputFolder.
     * @param outputFolder The name of the outputFolder.
     */
    public ProjectJSONJava setOutputFolder(String outputFolder)
    {
        this.outputFolder = outputFolder;
        return this;
    }

    public Iterable<PathPattern> getSourceFilePatterns()
    {
        return sourceFilePatterns;
    }

    /**
     * Set the maximum number of errors that the compiler should report before halting compilation.
     * If nothing is specified (maximumErrors is null), then the default (100) will be used.
     * @param maximumErrors The maximum number of errors that the compiler should report before
     *                      halting compilation.
     * @return This object for method chaining.
     */
    public ProjectJSONJava setMaximumErrors(Integer maximumErrors)
    {
        this.maximumErrors = maximumErrors;
        return this;
    }

    /**
     * Get the maximum number of errors that the compiler should report before halting compilation.
     * If nothing is specified (maximumErrors is null), then the default (100) will be used.
     * @return The maximum number of errors that the compiler should report before halting
     * compilation.
     */
    public Integer getMaximumErrors()
    {
        return maximumErrors;
    }

    /**
     * Set the maximum number of warnings that the compiler should report. If nothing is specified
     * (maximumWarnings is null), then the default (100) will be used.
     * @param maximumWarnings The maximum number of warnings that the compiler should report.
     * @return This object for method chaining.
     */
    public ProjectJSONJava setMaximumWarnings(Integer maximumWarnings)
    {
        this.maximumWarnings = maximumWarnings;
        return this;
    }

    /**
     * Get the maximum number of warnings that the compiler should report. If nothing is specified
     * (maximumWarnings is null), then the default (100) will be used.
     * @return The maximum number of warnings that the compiler should report.
     */
    public Integer getMaximumWarnings()
    {
        return maximumWarnings;
    }

    public ProjectJSONJava setSourceFilePatterns(Iterable<PathPattern> sourceFilePatterns)
    {
        this.sourceFilePatterns = sourceFilePatterns;
        return this;
    }

    /**
     * Get the dependencies for this project.
     * @return The dependencies for this project.
     */
    public Iterable<ProjectSignature> getDependencies()
    {
        return dependencies;
    }

    /**
     * Set the dependencies for this project.
     * @param dependencies The dependencies for this project.
     */
    public ProjectJSONJava setDependencies(Iterable<ProjectSignature> dependencies)
    {
        this.dependencies = dependencies;
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
            Comparer.equal(this.mainClass, rhs.mainClass) &&
            Comparer.equal(this.shortcutName, rhs.shortcutName) &&
            Comparer.equal(this.version, rhs.version) &&
            Comparer.equal(this.outputFolder, rhs.outputFolder) &&
            Comparer.equal(this.maximumErrors, rhs.maximumErrors) &&
            Comparer.equal(this.maximumWarnings, rhs.maximumWarnings) &&
            Comparer.equal(this.sourceFilePatterns, rhs.sourceFilePatterns) &&
            Comparer.equal(this.dependencies, rhs.dependencies);
    }

    @Override
    public String toString()
    {
        return this.toJson().toString();
    }

    public JSONObject toJson()
    {
        final JSONObject result = JSONObject.create();

        if (!Strings.isNullOrEmpty(this.mainClass))
        {
            result.setString(ProjectJSONJava.mainClassPropertyName, this.mainClass);
        }
        if (!Strings.isNullOrEmpty(this.shortcutName))
        {
            result.setString(ProjectJSONJava.shortcutNamePropertyName, this.shortcutName);
        }
        if (!Strings.isNullOrEmpty(this.version))
        {
            result.setString(ProjectJSONJava.versionPropertyName, this.version);
        }
        if (!Strings.isNullOrEmpty(this.outputFolder))
        {
            result.setString(ProjectJSONJava.outputFolderPropertyName, this.outputFolder);
        }
        if (!Iterable.isNullOrEmpty(this.sourceFilePatterns))
        {
            result.set(ProjectJSONJava.sourceFilesPropertyName, JSONArray.create(this.sourceFilePatterns.map(PathPattern::toString).map(JSONString::get)));
        }
        if (this.maximumErrors != null)
        {
            result.setNumber(ProjectJSONJava.maximumErrorsPropertyName, this.maximumErrors);
        }
        if (this.maximumWarnings != null)
        {
            result.setNumber(ProjectJSONJava.maximumWarningsPropertyName, this.maximumWarnings);
        }
        if (!Iterable.isNullOrEmpty(this.dependencies))
        {
            result.set(ProjectJSONJava.dependenciesPropertyName, JSONArray.create(this.dependencies.map(ProjectSignature::toJson)));
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    public static Result<ProjectJSONJava> parse(JSONObject javaObject)
    {
        PreCondition.assertNotNull(javaObject, "javaObject");

        return Result.create(() ->
        {
            final ProjectJSONJava result = new ProjectJSONJava();
            javaObject.getString(ProjectJSONJava.mainClassPropertyName)
                .then(result::setMainClass)
                .catchError()
                .await();
            javaObject.getString(ProjectJSONJava.shortcutNamePropertyName)
                .then(result::setShortcutName)
                .catchError()
                .await();
            javaObject.getString(ProjectJSONJava.versionPropertyName)
                .catchError(WrongTypeException.class, () -> javaObject.getNumberSegment(ProjectJSONJava.versionPropertyName).await().toString())
                .then(result::setVersion)
                .catchError()
                .await();
            javaObject.getString(ProjectJSONJava.outputFolderPropertyName)
                .then(result::setOutputFolder)
                .catchError()
                .await();
            javaObject.getString(ProjectJSONJava.sourceFilesPropertyName)
                .then((String sourceFilesPattern) ->
                {
                    if (!Strings.isNullOrEmpty(sourceFilesPattern))
                    {
                        result.setSourceFilePatterns(Iterable.create(PathPattern.parse(sourceFilesPattern)));
                    }
                })
                .catchError(WrongTypeException.class, () ->
                {
                    javaObject.getArray(ProjectJSONJava.sourceFilesPropertyName)
                        .then((JSONArray sourceFilesArray) ->
                        {
                            result.setSourceFilePatterns(sourceFilesArray
                                .instanceOf(JSONString.class)
                                .map(JSONString::getValue)
                                .where(value -> !Strings.isNullOrEmpty(value))
                                .map(PathPattern::parse));
                        })
                        .await();
                })
                .catchError()
                .await();
            javaObject.getNumber(ProjectJSONJava.maximumErrorsPropertyName)
                .then((Double maximumErrors) -> result.setMaximumErrors(maximumErrors.intValue()))
                .catchError()
                .await();
            javaObject.getNumber(ProjectJSONJava.maximumWarningsPropertyName)
                .then((Double maximumWarnings) -> result.setMaximumWarnings(maximumWarnings.intValue()))
                .catchError()
                .await();
            javaObject.getArray(ProjectJSONJava.dependenciesPropertyName)
                .then((JSONArray dependenciesArray) ->
                {
                    result.setDependencies(dependenciesArray
                        .map((JSONSegment dependencyElement) ->
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
                                dependency = ProjectSignature.parse((JSONObject)dependencyElement)
                                    .catchError()
                                    .await();
                            }
                            return dependency;
                        })
                        .where(Objects::nonNull));
                })
                .catchError()
                .await();

            PostCondition.assertNotNull(result, "result");

            return result;
        });
    }
}
