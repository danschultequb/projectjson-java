package qub;

public interface ProjectJSON extends JSONObjectWrapper
{
    /**
     * Create a ProjectJSON object around an empty JSON object.
     * @return The ProjectJSON object that wraps an empty JSON object.
     */
    static ProjectJSON create()
    {
        return ProjectJSON.create(JSONObject.create());
    }

    /**
     * Create a ProjectJSON object from the provided JSON object.
     * @param json The JSON object to wrap.
     * @return The ProjectJSON object that wraps the provided JSON object.
     */
    static ProjectJSON create(JSONObject json)
    {
        return BasicProjectJSON.create(json);
    }

    /**
     * Parse a ProjectJSON object from the provided file.
     * @param projectJsonFile The file to parse.
     * @return The result of attempting to parse a ProjectJSON file.
     */
    static Result<ProjectJSON> parse(File projectJsonFile)
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
    static Result<ProjectJSON> parse(ByteReadStream bytes)
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
    static Result<ProjectJSON> parse(CharacterReadStream characters)
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
    static Result<ProjectJSON> parse(String text)
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
    static Result<ProjectJSON> parse(Iterable<Character> characters)
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
    static Result<ProjectJSON> parse(Iterator<Character> characters)
    {
        PreCondition.assertNotNull(characters, "characters");

        return JSON.parseObject(characters)
            .then((JSONObject rootObject) -> ProjectJSON.create(rootObject));
    }

    /**
     * Get the $schema property value.
     * @return The $schema property value.
     */
    String getSchema();

    /**
     * Set the $schema property value.
     * @param schema The schema property value.
     * @return This object for method chaining.
     */
    ProjectJSON setSchema(String schema);

    /**
     * Set the $schema property value.
     * @param schemaPath The schema property value.
     * @return This object for method chaining.
     */
    default ProjectJSON setSchema(Path schemaPath)
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
    default ProjectJSON setSchema(File schemaFile)
    {
        PreCondition.assertNotNull(schemaFile, "schemaFile");

        return this.setSchema(schemaFile.getPath());
    }

    /**
     * Set the $schema property value.
     * @param schemaUrl The schema property value.
     * @return This object for method chaining.
     */
    default ProjectJSON setSchema(URL schemaUrl)
    {
        PreCondition.assertNotNull(schemaUrl, "schemaUrl");

        return this.setSchema(schemaUrl.toString());
    }

    /**
     * Get the publisher.
     * @return The publisher.
     */
    String getPublisher();

    /**
     * Set the publisher.
     * @param publisher The publisher.
     */
    ProjectJSON setPublisher(String publisher);

    /**
     * Get the project name.
     * @return The name of the project.
     */
    String getProject();

    /**
     * Set the project name.
     * @param project The name of the project.
     */
    ProjectJSON setProject(String project);

    /**
     * Get the version.
     * @return The version.
     */
    VersionNumber getVersion();

    /**
     * Set the version.
     * @param version The version.
     */
    ProjectJSON setVersion(String version);

    /**
     * Set the version.
     * @param version The version.
     */
    default ProjectJSON setVersion(VersionNumber version)
    {
        PreCondition.assertNotNullAndNotEmpty(version, "version");

        return this.setVersion(version.toString());
    }
}
