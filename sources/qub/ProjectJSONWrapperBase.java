package qub;

public abstract class ProjectJSONWrapperBase<T extends ProjectJSON> implements ProjectJSONWrapper<T>
{
    private final ProjectJSON projectJson;

    protected ProjectJSONWrapperBase(ProjectJSON projectJson)
    {
        PreCondition.assertNotNull(projectJson, "projectJson");

        this.projectJson = projectJson;
    }

    @Override
    public String getSchema()
    {
        return this.projectJson.getSchema();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T setSchema(String schema)
    {
        this.projectJson.setSchema(schema);
        return (T)this;
    }

    @Override
    public String getPublisher()
    {
        return this.projectJson.getPublisher();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T setPublisher(String publisher)
    {
        this.projectJson.setPublisher(publisher);
        return (T)this;
    }

    @Override
    public String getProject()
    {
        return this.projectJson.getProject();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T setProject(String project)
    {
        this.projectJson.setProject(project);
        return (T)this;
    }

    @Override
    public VersionNumber getVersion()
    {
        return this.projectJson.getVersion();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T setVersion(String version)
    {
        this.projectJson.setVersion(version);
        return (T)this;
    }

    @Override
    public JSONObject toJson()
    {
        return this.projectJson.toJson();
    }

    @Override
    public String toString()
    {
        return JSONObjectWrapper.toString(this);
    }

    @Override
    public boolean equals(Object rhs)
    {
        return JSONObjectWrapper.equals(this, rhs);
    }
}
