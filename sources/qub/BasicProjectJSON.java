package qub;

public class BasicProjectJSON extends JSONObjectWrapperBase implements ProjectJSON
{
    private static final String schemaPropertyName = "$schema";
    private static final String publisherPropertyName = "publisher";
    private static final String projectPropertyName = "project";
    private static final String versionPropertyName = "version";

    private BasicProjectJSON(JSONObject json)
    {
        super(json);
    }

    /**
     * Create a ProjectJSON object around an empty JSON object.
     * @return The ProjectJSON object that wraps an empty JSON object.
     */
    public static BasicProjectJSON create()
    {
        return BasicProjectJSON.create(JSONObject.create());
    }

    /**
     * Create a ProjectJSON object from the provided JSON object.
     * @param json The JSON object to wrap.
     * @return The ProjectJSON object that wraps the provided JSON object.
     */
    public static BasicProjectJSON create(JSONObject json)
    {
        return new BasicProjectJSON(json);
    }

    private String getString(String propertyName)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");

        return this.json.getString(propertyName)
            .catchError()
            .await();
    }

    private BasicProjectJSON setString(String propertyName, String propertyValue)
    {
        PreCondition.assertNotNullAndNotEmpty(propertyName, "propertyName");
        PreCondition.assertNotNullAndNotEmpty(propertyValue, "propertyValue");

        this.json.setString(propertyName, propertyValue);
        return this;
    }

    @Override
    public String getSchema()
    {
        return this.getString(BasicProjectJSON.schemaPropertyName);
    }

    @Override
    public BasicProjectJSON setSchema(String schema)
    {
        PreCondition.assertNotNullAndNotEmpty(schema, "schema");

        return this.setString(BasicProjectJSON.schemaPropertyName, schema);
    }

    @Override
    public String getPublisher()
    {
        return this.getString(BasicProjectJSON.publisherPropertyName);
    }

    @Override
    public BasicProjectJSON setPublisher(String publisher)
    {
        PreCondition.assertNotNullAndNotEmpty(publisher, "publisher");

        return this.setString(BasicProjectJSON.publisherPropertyName, publisher);
    }

    @Override
    public String getProject()
    {
        return this.getString(BasicProjectJSON.projectPropertyName);
    }

    @Override
    public BasicProjectJSON setProject(String project)
    {
        PreCondition.assertNotNullAndNotEmpty(project, "project");

        return this.setString(BasicProjectJSON.projectPropertyName, project);
    }

    @Override
    public VersionNumber getVersion()
    {
        VersionNumber result;

        final String versionString = this.getString(BasicProjectJSON.versionPropertyName);
        if (Strings.isNullOrEmpty(versionString))
        {
            result = null;
        }
        else
        {
            result = VersionNumber.parse(versionString).await();
        }

        return result;
    }

    @Override
    public BasicProjectJSON setVersion(String version)
    {
        PreCondition.assertNotNullAndNotEmpty(version, "version");

        return this.setString(BasicProjectJSON.versionPropertyName, version);
    }
}
