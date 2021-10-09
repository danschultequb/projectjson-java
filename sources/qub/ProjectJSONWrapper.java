package qub;

public interface ProjectJSONWrapper<T extends ProjectJSON> extends ProjectJSON
{
    @Override
    T setSchema(String schema);

    @Override
    @SuppressWarnings("unchecked")
    default T setSchema(Path schemaPath)
    {
        return (T)ProjectJSON.super.setSchema(schemaPath);
    }

    @Override
    @SuppressWarnings("unchecked")
    default T setSchema(File schemaFile)
    {
        return (T)ProjectJSON.super.setSchema(schemaFile);
    }

    @Override
    @SuppressWarnings("unchecked")
    default ProjectJSON setSchema(URL schemaUrl)
    {
        return (T)ProjectJSON.super.setSchema(schemaUrl);
    }

    @Override
    T setPublisher(String publisher);

    @Override
    T setProject(String project);

    @Override
    T setVersion(String version);

    @Override
    @SuppressWarnings("unchecked")
    default T setVersion(VersionNumber version)
    {
        return (T)ProjectJSON.super.setVersion(version);
    }
}
