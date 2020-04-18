package qub;

public class ProjectJSON
{
    private static final String publisherPropertyName = "publisher";
    private static final String projectPropertyName = "project";
    private static final String versionPropertyName = "version";
    private static final String javaPropertyName = "java";

    private final JSONObject jsonObject;

    private ProjectJSON(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "jsonObject");

        this.jsonObject = jsonObject;
    }

    /**
     * Create a ProjectJSON object from the provided JSON object.
     * @param jsonObject The JSON object to wrap.
     * @return The ProjectJSON object that wraps the provided JSON object.
     */
    public static ProjectJSON create(JSONObject jsonObject)
    {
        PreCondition.assertNotNull(jsonObject, "rootObject");

        return new ProjectJSON(jsonObject);
    }

    /**
     * Create a ProjectJSON object around an empty JSON object.
     * @return The ProjectJSON object that wraps an empty JSON object.
     */
    public static ProjectJSON create()
    {
        return ProjectJSON.create(JSONObject.create());
    }

    private String getString(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        return this.jsonObject.getString(propertyName)
            .catchError()
            .await();
    }

    private ProjectJSON setString(String propertyName, String propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");
        PreCondition.assertNotNullAndNotEmpty(propertyValue, "propertyValue");

        this.jsonObject.setString(propertyName, propertyValue);
        return this;
    }

    /**
     * Get the publisher.
     * @return The publisher.
     */
    public String getPublisher()
    {
        return this.getString(ProjectJSON.publisherPropertyName);
    }

    /**
     * Set the publisher.
     * @param publisher The publisher.
     */
    public ProjectJSON setPublisher(String publisher)
    {
        PreCondition.assertNotNullAndNotEmpty(publisher, "publisher");

        return this.setString(ProjectJSON.publisherPropertyName, publisher);
    }

    /**
     * Get the project name.
     * @return The name of the project.
     */
    public String getProject()
    {
        return this.getString(ProjectJSON.projectPropertyName);
    }

    /**
     * Set the project name.
     * @param project The name of the project.
     */
    public ProjectJSON setProject(String project)
    {
        PreCondition.assertNotNullAndNotEmpty(project, "project");

        return this.setString(ProjectJSON.projectPropertyName, project);
    }

    /**
     * Get the version.
     * @return The version.
     */
    public String getVersion()
    {
        return this.getString(ProjectJSON.versionPropertyName);
    }

    /**
     * Set the version.
     * @param version The version.
     */
    public ProjectJSON setVersion(String version)
    {
        PreCondition.assertNotNullAndNotEmpty(version, "version");

        return this.setString(ProjectJSON.versionPropertyName, version);
    }

    /**
     * Set the Java options.
     * @param java The Java options.
     */
    public ProjectJSON setJava(ProjectJSONJava java)
    {
        PreCondition.assertNotNull(java, "java");

        this.jsonObject.setObject(ProjectJSON.javaPropertyName, java.toJson());
        return this;
    }

    /**
     * Get the Java options.
     * @return The Java options.
     */
    public ProjectJSONJava getJava()
    {
        final JSONObject javaJsonObject = this.jsonObject.getObject(ProjectJSON.javaPropertyName).catchError().await();
        return javaJsonObject == null ? null : ProjectJSONJava.create(javaJsonObject);
    }

    @Override
    public boolean equals(Object rhs)
    {
        return rhs instanceof ProjectJSON && this.equals((ProjectJSON)rhs);
    }

    public boolean equals(ProjectJSON rhs)
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

    /**
     * Parse a ProjectJSON object from the provided file.
     * @param projectJsonFile The file to parse.
     * @return The result of attempting to parse a ProjectJSON file.
     */
    public static Result<ProjectJSON> parse(File projectJsonFile)
    {
        PreCondition.assertNotNull(projectJsonFile, "projectJsonFile");

        return JSON.parseObject(projectJsonFile)
            .then((JSONObject json) -> ProjectJSON.create(json));
    }

    /**
     * Parse a ProjectJSON object from the provided bytes.
     * @param bytes The bytes to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(ByteReadStream bytes)
    {
        PreCondition.assertNotNull(bytes, "bytes");

        return JSON.parseObject(bytes)
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
    }

    /**
     * Parse a ProjectJSON object from the provided characters.
     * @param characters The characters to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(CharacterReadStream characters)
    {
        PreCondition.assertNotNull(characters, "characters");

        return JSON.parseObject(characters)
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
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
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
    }
}
