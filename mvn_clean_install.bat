set file.encoding=UTF-8
set JAVA_HOME=E:/JAVA/jdk18/
call mvn -e clean compile -Dmaven.test.skip=false -DdownloadSources=true -DdownloadSource=true


pause