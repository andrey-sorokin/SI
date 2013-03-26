@echo off
 setLocal EnableDelayedExpansion
 set CLASSPATH="
 for /R ../../lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
 )
 set CLASSPATH=!CLASSPATH!"
rem  echo !CLASSPATH!
java -Dfile.encoding=UTF-8 -Duser.language=en -Duser.region=us -server -Xms512m -Xmx1024m -classpath !CLASSPATH! ru.rstyle.si.main.Sender
