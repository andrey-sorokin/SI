@echo off
 setLocal EnableDelayedExpansion
 set CLASSPATH="
 for /R ../../lib %%a in (*.jar) do (
   set CLASSPATH=!CLASSPATH!;%%a
 )
 set CLASSPATH=!CLASSPATH!"
rem  echo !CLASSPATH!
java -Xms512m -Xmx1024m -classpath !CLASSPATH! ru.rstyle.si.MyServiceDemo 
