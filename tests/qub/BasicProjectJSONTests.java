package qub;

public interface BasicProjectJSONTests
{
    static void test(TestRunner runner)
    {
        runner.testGroup(BasicProjectJSON.class, () ->
        {
            ProjectJSONTests.test(runner, BasicProjectJSON::create);

            runner.test("create()", (Test test) ->
            {
                final BasicProjectJSON projectJSON = BasicProjectJSON.create();
                test.assertNull(projectJSON.getPublisher());
                test.assertNull(projectJSON.getProject());
                test.assertNull(projectJSON.getVersion());
            });

            runner.testGroup("create(JSONObject)", () ->
            {
                runner.test("with null", (Test test) ->
                {
                    test.assertThrows(() -> BasicProjectJSON.create(null),
                        new PreConditionFailure("json cannot be null."));
                });

                final Action2<JSONObject, BasicProjectJSON> parseTest = (JSONObject json, BasicProjectJSON expected) ->
                {
                    runner.test("with " + json, (Test test) ->
                    {
                        test.assertEqual(expected, BasicProjectJSON.create(json));
                    });
                };

                parseTest.run(
                    JSONObject.create(),
                    BasicProjectJSON.create());
                parseTest.run(
                    JSONObject.create()
                        .setString("publisher", "a"),
                    BasicProjectJSON.create()
                        .setPublisher("a"));
                parseTest.run(
                    JSONObject.create()
                        .setString("project", "b"),
                    BasicProjectJSON.create()
                        .setProject("b"));
                parseTest.run(
                    JSONObject.create()
                        .setString("version", "c"),
                    BasicProjectJSON.create()
                        .setVersion("c"));
                parseTest.run(
                    JSONObject.create()
                        .setObject("java", JSONObject.create()),
                    BasicProjectJSON.create(JSONObject.create()
                            .setObject("java", JSONObject.create())));
            });
        });
    }
}
