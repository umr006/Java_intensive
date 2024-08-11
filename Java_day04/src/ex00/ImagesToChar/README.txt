# delete directory if exists
rm -rf target
# create directory
mkdir target
# compile the project
javac -d ./target src/java/edu.school21.printer/*/*.java
# run the project
java -classpath target edu.school21.printer.app.Program /Users/new/Desktop/Java_intensive/Java_day04/src/ex00/it.bmp