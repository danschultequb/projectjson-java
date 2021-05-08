package qub;

public class ProjectJSON extends JSONObjectWrapperBase
{
    private static final String schemaPropertyName = "$schema";
    private static final String publisherPropertyName = "publisher";
    private static final String projectPropertyName = "project";
    private static final String versionPropertyName = "version";
    private static final String javaPropertyName = "java";

    private ProjectJSON(JSONObject json)
    {
        super(json);
    }

    /**
     * Create a ProjectJSON object around an empty JSON object.
     * @return The ProjectJSON object that wraps an empty JSON object.
     */
    public static ProjectJSON create()
    {
        return ProjectJSON.create(JSONObject.create());
    }

    /**
     * Create a ProjectJSON object from the provided JSON object.
     * @param json The JSON object to wrap.
     * @return The ProjectJSON object that wraps the provided JSON object.
     */
    public static ProjectJSON create(JSONObject json)
    {
        return new ProjectJSON(json);
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

        return JSON.parseObject(text)
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
    }

    /**
     * Parse a ProjectJSON object from the provided characters.
     * @param characters The characters to parse.
     * @return The result of attempting to parse a ProjectJSON object.
     */
    public static Result<ProjectJSON> parse(Iterable<Character> characters)
    {
        PreCondition.assertNotNull(characters, "characters");

        return JSON.parseObject(characters)
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
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

    private String getString(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        return this.json.getString(propertyName)
            .catchError()
            .await();
    }

    private ProjectJSON setString(String propertyName, String propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");
        PreCondition.assertNotNullAndNotEmpty(propertyValue, "propertyValue");

        this.json.setString(propertyName, propertyValue);
        return this;
    }

    /**
     * Get the $schema property value.
     * @return The $schema property value.
     */
    public String getSchema()
    {
        return this.getString(ProjectJSON.schemaPropertyName);
    }

    /**
     * Set the $schema property value.
     * @param schema The schema property value.
     * @return This object for method chaining.
     */
    public ProjectJSON setSchema(String schema)
    {
        PreCondition.assertNotNullAndNotEmpty(schema, "schema");

        return this.setString(ProjectJSON.schemaPropertyName, schema);
    }

    /**
     * Set the $schema property value.
     * @param schemaPath The schema property value.
     * @return This object for method chaining.
     */
    public ProjectJSON setSchema(Path schemaPath)
    {
        PreCondition.assertNotNull(schemaPath, "schemaPath");
        PreCondition.assertFalse(schemaPath.endsWith('/') || schemaPath.endsWith('\\'), "schemaPath.endsWith('/') || schemaPath.endsWith('\\')");

        return this.setSchema("file:///" + schemaPath.toString());
    }

    /**
     * Set the $schema property value.
     * @param schemaFile The schema property value.
     * @return This object for method chaining.
     */
    public ProjectJSON setSchema(File schemaFile)
    {
        PreCondition.assertNotNull(schemaFile, "schemaFile");

        return this.setSchema(schemaFile.getPath());
    }

    /**
     * Set the $schema property value.
     * @param schemaUrl The schema property value.
     * @return This object for method chaining.
     */
    public ProjectJSON setSchema(URL schemaUrl)
    {
        PreCondition.assertNotNull(schemaUrl, "schemaUrl");

        return this.setSchema(schemaUrl.toString());
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
    public VersionNumber getVersion()
    {
        VersionNumber result;

        final String versionString = this.getString(ProjectJSON.versionPropertyName);
        if (versionString == null)
        {
            result = null;
        }
        else if (versionString.isEmpty())
        {
            result = VersionNumber.create();
        }
        else
        {
            result = VersionNumber.parse(versionString).await();
        }

        return result;
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
     * Set the version.
     * @param version The version.
     */
    public ProjectJSON setVersion(VersionNumber version)
    {
        PreCondition.assertNotNullAndNotEmpty(version, "version");

        return this.setString(ProjectJSON.versionPropertyName, version.toString());
    }

    /**
     * Set the Java options.
     * @param java The Java options.
     */
    public ProjectJSON setJava(ProjectJSONJava java)
    {
        PreCondition.assertNotNull(java, "java");

        this.json.setObject(ProjectJSON.javaPropertyName, java.toJson());
        return this;
    }

    /**
     * Get the Java options.
     * @return The Java options.
     */
    public ProjectJSONJava getJava()
    {
        final JSONObject javaJsonObject = this.json.getObject(ProjectJSON.javaPropertyName).catchError().await();
        return javaJsonObject == null ? null : ProjectJSONJava.create(javaJsonObject);
    }
}
