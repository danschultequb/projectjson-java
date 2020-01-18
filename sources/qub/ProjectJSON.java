package qub;

public class ProjectJSON
{
    private static final String publisherPropertyName = "publisher";
    private static final String projectPropertyName = "project";
    private static final String versionPropertyName = "version";
    private static final String javaPropertyName = "java";

    private String publisher;
    private String project;
    private String version;
    private ProjectJSONJava java;

    /**
     * Get the publisher.
     * @return The publisher.
     */
    public String getPublisher()
    {
        return this.publisher;
    }

    /**
     * Set the publisher.
     * @param publisher The publisher.
     */
    public ProjectJSON setPublisher(String publisher)
    {
        this.publisher = publisher;
        return this;
    }

    /**
     * Get the project name.
     * @return The name of the project.
     */
    public String getProject()
    {
        return this.project;
    }

    /**
     * Set the project name.
     * @param project The name of the project.
     */
    public ProjectJSON setProject(String project)
    {
        this.project = project;
        return this;
    }

    /**
     * Get the version.
     * @return The version.
     */
    public String getVersion()
    {
        return this.version;
    }

    /**
     * Set the version.
     * @param version The version.
     */
    public ProjectJSON setVersion(String version)
    {
        this.version = version;
        return this;
    }

    /**
     * Set the Java options.
     * @param java The Java options.
     */
    public ProjectJSON setJava(ProjectJSONJava java)
    {
        this.java = java;
        return this;
    }

    /**
     * Get the Java options.
     * @return The Java options.
     */
    public ProjectJSONJava getJava()
    {
        return this.java;
    }

    @Override
    public boolean equals(Object rhs)
    {
        return rhs instanceof ProjectJSON && this.equals((ProjectJSON)rhs);
    }

    public boolean equals(ProjectJSON rhs)
    {
        return rhs != null &&
            Comparer.equal(this.publisher, rhs.publisher) &&
            Comparer.equal(this.project, rhs.project) &&
            Comparer.equal(this.version, rhs.version) &&
            Comparer.equal(this.java, rhs.java);
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
        final JSONObject result = JSONObject.create();

        if (!Strings.isNullOrEmpty(this.publisher))
        {
            result.setString(ProjectJSON.publisherPropertyName, this.publisher);
        }
        if (!Strings.isNullOrEmpty(this.project))
        {
            result.setString(ProjectJSON.projectPropertyName, this.project);
        }
        if (!Strings.isNullOrEmpty(this.version))
        {
            result.setString(ProjectJSON.versionPropertyName, this.version);
        }
        if (this.java != null)
        {
            result.set(ProjectJSON.javaPropertyName, this.java.toJson());
        }

        PostCondition.assertNotNull(result, "result");

        return result;
    }

    /**
     * Parse a ProjectJSON object from the provided file.
     * @param projectJsonFile The file to parse.
     * @return The result of attempting to parse a ProjectJSON file.
     */
    public static Result<ProjectJSON> parse(File projectJsonFile)
    {
        PreCondition.assertNotNull(projectJsonFile, "projectJsonFile");

        return Result.create(() ->
        {
            ProjectJSON result;
            try (final ByteReadStream readStream = new BufferedByteReadStream(projectJsonFile.getContentByteReadStream().await()))
            {
                result = ProjectJSON.parse(readStream.asCharacterReadStream()).await();
            }
            return result;
        });
    }

    /**
     * Parse a ProjectJSON object from the provided text.
     * @param text The text to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(String text)
    {
        PreCondition.assertNotNull(text, "text");

        return ProjectJSON.parse(Strings.iterable(text));
    }

    /**
     * Parse a ProjectJSON object from the provided characters.
     * @param characters The characters to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(Iterable<Character> characters)
    {
        PreCondition.assertNotNull(characters, "characters");

        return ProjectJSON.parse(characters.iterate());
    }

    /**
     * Parse a ProjectJSON object from the provided characters.
     * @param characters The characters to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(Iterator<Character> characters)
    {
        PreCondition.assertNotNull(characters, "characters");

        return JSON.parseObject(characters)
            .then((JSONObject rootObject) -> ProjectJSON.parse(rootObject).await());
    }

    /**
     * Parse a ProjectJSON object from the provided JSONObject.
     * @param rootObject The rootObject to parse.
     * @return The result of attempting to parse a JSON object.
     */
    public static Result<ProjectJSON> parse(JSONObject rootObject)
    {
        PreCondition.assertNotNull(rootObject, "rootObject");

        return Result.create(() ->
        {
            ProjectJSON projectJson = new ProjectJSON();

            rootObject.getString(ProjectJSON.publisherPropertyName)
                .then(projectJson::setPublisher)
                .catchError()
                .await();
            rootObject.getString(ProjectJSON.projectPropertyName)
                .then(projectJson::setProject)
                .catchError()
                .await();
            rootObject.getString(ProjectJSON.versionPropertyName)
                .then(projectJson::setVersion)
                .catchError()
                .await();
            rootObject.getObject(ProjectJSON.javaPropertyName)
                .then((JSONObject javaObject) -> projectJson.setJava(ProjectJSONJava.parse(javaObject).await()))
                .catchError()
                .await();

            return projectJson;
        });
    }
}
