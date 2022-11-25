set -e
 
rm -rf student-submission
git clone $1 student-submission
cd student-submission
 
FILE=./ListExamples.java
if test -f "$FILE" ;
then
    echo "$FILE exists."
else
    echo "$FILE does not exist in this directory or is not a regular file."
    echo "Grade: 2/10"
    exit 1
fi
 
mkdir -p ./testdir
cp ./ListExamples.java ./testdir
cp ../TestListExamples.java ./testdir
 
cd ./testdir
set +e
javac -cp ".;../../lib/hamcrest-core-1.3.jar;../../lib/junit-4.13.2.jar" *.java
if [ $? -eq 0 ]
then
    echo "Compiled Successfully."
else
    echo "Did not Compile Successfully."
    echo "Grade: 5/10"
    exit 1
fi
 
java -cp ".;../../lib/hamcrest-core-1.3.jar;../../lib/junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples
if [ $? -eq 0 ]
then
    echo "Java Ran Successfully."
    echo "Grade: 10/10"
else
    echo "Java did not run Successfully."
    echo "Grade: 7/10"
fi
 
 
