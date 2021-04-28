mvn verify -Dcucumber.options="--tags '(not @security) and (not @wip) and (@UI or (not @UI and not @API))'"
mvn serenity:aggregate