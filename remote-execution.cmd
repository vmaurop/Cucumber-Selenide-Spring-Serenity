call mvn clean verify -Dcontext="chrome" -Dwebdriver.remote.driver=chrome -Dinjected.tags=browser:chrome  -Dwebdriver.remote.url=htt -Dcucumber.options="--tags '(not @security) and (not @wip) and (@UI or (not @UI and not @API))'" %*
call mvn serenity:aggregate -Dsysinfo.build=SUT_version
