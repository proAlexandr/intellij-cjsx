# CJSX webstorm plugin

## Build from sources (MAC)

1. Add Intellij Platform Plugin SDK based on Webstorm 2016.1
(see http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/prerequisites.html)
(1.4. Configure SDK and source files)

2. Add to the SDK additional files
/Applications/WebStorm.app/Contents/plugins/coffeescript-core/lib/coffeescript-core.jar
/Applications/WebStorm.app/Contents/plugins/coffeescript-core/lib/resources_en.jar
/Applications/WebStorm.app/Contents/plugins/JavaScriptLanguage/lib/javascript-openapi.jar
/Applications/WebStorm.app/Contents/plugins/JavaScriptLanguage/lib/JavaScriptLanguage.jar
/Applications/WebStorm.app/Contents/plugins/JavaScriptLanguage/lib/resources_en.jar

3. All dependencies installed. Build a plugin archive.
(see http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/deploying_plugin.html)
